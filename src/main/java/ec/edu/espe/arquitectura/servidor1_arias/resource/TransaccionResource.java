package ec.edu.espe.arquitectura.servidor1_arias.resource;

import ec.edu.espe.arquitectura.servidor1_arias.dto.TransaccionDTO;
import ec.edu.espe.arquitectura.servidor1_arias.mapper.TransaccionMapper;
import ec.edu.espe.arquitectura.servidor1_arias.model.Transaccion;
import ec.edu.espe.arquitectura.servidor1_arias.service.TransaccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaccion")
@RequiredArgsConstructor
public class TransaccionResource {
  private final TransaccionService transaccionService;

  @PostMapping
  public ResponseEntity<TransaccionDTO> transferir(@RequestBody TransaccionDTO dto) {
    try {
      Transaccion transaccion =
          transaccionService.transferir(TransaccionMapper.buildTransaccion(dto));
      return ResponseEntity.ok(TransaccionMapper.buildTransaccionDTO(transaccion));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
