package ec.edu.espe.arquitectura.servidor1_arias.dao;

import ec.edu.espe.arquitectura.servidor1_arias.model.Narcotraficante;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NarcotraficanteRepository extends MongoRepository<Narcotraficante, String> {
  Optional<Narcotraficante> findByCodigoInterno(String codigoInterno);

  List<Narcotraficante> findByNombreCompleto(String nombreCompleto);
}
