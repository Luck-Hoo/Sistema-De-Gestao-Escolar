package com.escola.sia.repository;

import com.escola.sia.model.Formacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacaoRepository extends JpaRepository<Formacao, Integer> {

}
