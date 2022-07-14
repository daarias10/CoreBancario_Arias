package ec.edu.espe.arquitectura.servidor1_arias.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum NarcotraficanteEnum {
  SI("SI", "Sí"),
  NO("NO", "No");

  private final String value;
  private final String text;
}
