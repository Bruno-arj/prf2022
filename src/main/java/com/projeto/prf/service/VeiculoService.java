package com.projeto.prf.service;

import com.projeto.prf.model.Veiculo;
import com.projeto.prf.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public long contarVeiculos() {
        return veiculoRepository.count();
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }
}