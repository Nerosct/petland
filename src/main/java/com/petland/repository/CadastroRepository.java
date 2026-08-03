package com.petland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petland.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
}
