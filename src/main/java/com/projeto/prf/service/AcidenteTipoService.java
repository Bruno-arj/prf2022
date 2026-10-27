package com.projeto.prf.service;

import com.projeto.prf.model.AcidenteTipo;
import com.projeto.prf.repository.AcidenteTipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcidenteTipoService {

    private final AcidenteTipoRepository tipoRepository;

    public AcidenteTipoService(AcidenteTipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public List<AcidenteTipo> listarTodos() {
        return tipoRepository.findAll();
    }

    public long contarTipos() {
        return tipoRepository.count();
    }
}