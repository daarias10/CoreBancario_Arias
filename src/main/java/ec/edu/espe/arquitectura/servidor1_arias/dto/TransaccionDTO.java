package ec.edu.espe.arquitectura.servidor1_arias.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransaccionDTO {
  private String codigoInterno;

  private String cuentaOrigen;

  private String cuentaDestino;

  private BigDecimal valor;

  private Date fecha;

  private String estado;
}
