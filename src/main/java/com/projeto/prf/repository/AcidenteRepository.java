package com.projeto.prf.repository;

import com.projeto.prf.model.Acidente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AcidenteRepository extends JpaRepository<Acidente, Integer> {

    List<Acidente> findByUfIgnoreCase(String uf);

    List<Acidente> findByMunicipioIgnoreCase(String municipio);

    List<Acidente> findByDataAcidenteBetween(
            LocalDate dataInicial,
            LocalDate dataFinal
    );
}