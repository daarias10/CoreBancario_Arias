package ec.edu.espe.arquitectura.servidor1_arias.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TransaccionEnum {
  EJECUTADO("EJE", "Ejecutado"),
  BLOQUEADO("BLO", "Bloqueado");

  private final String value;
  private final String text;
}
