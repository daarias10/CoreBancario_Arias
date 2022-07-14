package ec.edu.espe.arquitectura.servidor1_arias.dao;

import ec.edu.espe.arquitectura.servidor1_arias.model.Transaccion;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransaccionRepository extends MongoRepository<Transaccion, String> {
  Optional<Transaccion> findByCodigoInterno(String codigoInterno);
}
