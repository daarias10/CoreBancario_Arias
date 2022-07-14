package ec.edu.espe.arquitectura.servidor1_arias.dao;

import ec.edu.espe.arquitectura.servidor1_arias.model.Cliente;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
  Optional<Cliente> findByCodigoInterno(String codigoInterno);
}
