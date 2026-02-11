package com.listadecontatos.crud.repository;

import com.listadecontatos.crud.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
}
