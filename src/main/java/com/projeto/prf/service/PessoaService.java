package com.projeto.prf.service;

import com.projeto.prf.model.Pessoa;
import com.projeto.prf.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public long contarPessoas() {
        return pessoaRepository.count();
    }

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }
}