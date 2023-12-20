package com.empresa.apireservaciones.repositories;

import com.empresa.apireservaciones.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
