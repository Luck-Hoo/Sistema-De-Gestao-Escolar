package com.escola.sia.repository.relacoes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.sia.model.relacoes.TurmaDisciplina;
import com.escola.sia.model.relacoes.chavesCompostas.TurmaDisciplinaId;

public interface TurmaDisciplinaRepository extends JpaRepository<TurmaDisciplina, TurmaDisciplinaId> {

}
