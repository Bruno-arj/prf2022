package com.projeto.prf.service;

import com.projeto.prf.model.AcidenteCausa;
import com.projeto.prf.repository.AcidenteCausaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcidenteCausaService {

    private final AcidenteCausaRepository causaRepository;

    public AcidenteCausaService(AcidenteCausaRepository causaRepository) {
        this.causaRepository = causaRepository;
    }

    public List<AcidenteCausa> listarTodas() {
        return causaRepository.findAll();
    }

    public long contarCausas() {
        return causaRepository.count();
    }
}