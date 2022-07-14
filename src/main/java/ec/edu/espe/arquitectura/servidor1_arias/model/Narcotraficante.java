package ec.edu.espe.arquitectura.servidor1_arias.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "narcotraficantes")
@TypeAlias("narcotraficantes")
@Data
@Builder
public class Narcotraficante {
  @Id private String id;

  @Indexed(name = "idxu_narcotraficante_codigoInterno", unique = true)
  private String codigoInterno;

  private String nombreCompleto;

  private String sancionado;
}
