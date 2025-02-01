package com.escola.sia.repository.relacoes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.sia.model.relacoes.MonitorDisciplina;
import com.escola.sia.model.relacoes.chavesCompostas.MonitorDisciplinaId;

public interface MonitorDisciplinaRepository extends JpaRepository<MonitorDisciplina, MonitorDisciplinaId> {

}
