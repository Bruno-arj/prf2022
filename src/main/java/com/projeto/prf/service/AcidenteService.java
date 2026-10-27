package com.projeto.prf.service;

import com.projeto.prf.model.Acidente;
import com.projeto.prf.repository.AcidenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AcidenteService {

    private final AcidenteRepository acidenteRepository;

    public AcidenteService(AcidenteRepository acidenteRepository) {
        this.acidenteRepository = acidenteRepository;
    }

    public long contarAcidentes() {
        return acidenteRepository.count();
    }

    public Optional<Acidente> buscarPorId(Integer id) {
        return acidenteRepository.findById(id);
    }

    public List<Acidente> buscarPorUf(String uf) {
        return acidenteRepository.findByUfIgnoreCase(uf);
    }

    public List<Acidente> buscarPorMunicipio(String municipio) {
        return acidenteRepository.findByMunicipioIgnoreCase(municipio);
    }

    public List<Acidente> buscarPorPeriodo(
            LocalDate dataInicial,
            LocalDate dataFinal) {

        return acidenteRepository.findByDataAcidenteBetween(
                dataInicial,
                dataFinal
        );
    }
}