package ec.edu.espe.arquitectura.servidor1_arias.dao;

import ec.edu.espe.arquitectura.servidor1_arias.model.Cuenta;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {
  Optional<Cuenta> findByCodigoInterno(String codigoInterno);
}
