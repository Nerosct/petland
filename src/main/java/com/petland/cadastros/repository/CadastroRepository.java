package com.petland.cadastros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petland.cadastros.model.entity.CadastroEntity;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroEntity, Integer> {
}
