package ec.edu.espe.arquitectura.servidor1_arias.mapper;

import ec.edu.espe.arquitectura.servidor1_arias.dto.TransaccionDTO;
import ec.edu.espe.arquitectura.servidor1_arias.model.Transaccion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransaccionMapper {
  public static Transaccion buildTransaccion(TransaccionDTO dto) {
    return Transaccion.builder()
        .codigoInterno(dto.getCodigoInterno())
        .cuentaOrigen(dto.getCuentaOrigen())
        .cuentaDestino(dto.getCuentaDestino())
        .valor(dto.getValor())
        .fecha(dto.getFecha())
        .estado(dto.getEstado())
        .build();
  }

  public static TransaccionDTO buildTransaccionDTO(Transaccion transaccion) {
    return TransaccionDTO.builder()
        .codigoInterno(transaccion.getCodigoInterno())
        .cuentaOrigen(transaccion.getCuentaOrigen())
        .cuentaDestino(transaccion.getCuentaDestino())
        .valor(transaccion.getValor())
        .fecha(transaccion.getFecha())
        .estado(transaccion.getEstado())
        .build();
  }
}
