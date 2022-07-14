package ec.edu.espe.arquitectura.servidor1_arias.service;

import ec.edu.espe.arquitectura.servidor1_arias.dao.ClienteRepository;
import ec.edu.espe.arquitectura.servidor1_arias.dao.CuentaRepository;
import ec.edu.espe.arquitectura.servidor1_arias.dao.NarcotraficanteRepository;
import ec.edu.espe.arquitectura.servidor1_arias.dao.TransaccionRepository;
import ec.edu.espe.arquitectura.servidor1_arias.enums.TransaccionEnum;
import ec.edu.espe.arquitectura.servidor1_arias.exceptions.NotFoundException;
import ec.edu.espe.arquitectura.servidor1_arias.exceptions.TransaccionException;
import ec.edu.espe.arquitectura.servidor1_arias.model.Cliente;
import ec.edu.espe.arquitectura.servidor1_arias.model.Cuenta;
import ec.edu.espe.arquitectura.servidor1_arias.model.Narcotraficante;
import ec.edu.espe.arquitectura.servidor1_arias.model.Transaccion;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransaccionService {
  private final TransaccionRepository transaccionRepository;
  private final CuentaRepository cuentaRepository;
  private final ClienteRepository clienteRepository;
  private final NarcotraficanteRepository narcotraficanteRepository;

  public List<Narcotraficante> revisionLista(String nombreCompleto) {
    return narcotraficanteRepository.findByNombreCompleto(nombreCompleto);
  }

  public Cliente obtenerCliente(String codigoInterno) {
    return clienteRepository
        .findByCodigoInterno(codigoInterno)
        .orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
  }

  public Cuenta obtenerCuenta(String codigoInterno) {
    return cuentaRepository
        .findByCodigoInterno(codigoInterno)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "No se encontró la cuenta con código interno: " + codigoInterno));
  }

  public Transaccion transferir(Transaccion transaccion) throws TransaccionException {
    Cuenta cuentaOrigen = obtenerCuenta(transaccion.getCuentaOrigen());
    Cuenta cuentaDestino = obtenerCuenta(transaccion.getCuentaDestino());
    BigDecimal valor = transaccion.getValor();
    if (cuentaOrigen.getSaldo().compareTo(valor) < 0) {
      throw new TransaccionException("No hay saldo suficiente");
    }
    Cliente cliente = obtenerCliente(cuentaDestino.getIdCliente());
    if (!this.revisionLista(cliente.getNombreCompleto()).isEmpty()) {
      transaccion.setEstado(TransaccionEnum.BLOQUEADO.getValue());
    } else {
      transaccion.setEstado(TransaccionEnum.EJECUTADO.getValue());
      cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(valor));
      cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(valor));
    }
    transaccion.setCodigoInterno(UUID.randomUUID().toString());
    transaccion.setFecha(new Date());
    return transaccionRepository.save(transaccion);
  }
}
