package com.minsaitjpa.desafio.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsaitjpa.desafio.Entity.Pessoa;
import com.minsaitjpa.desafio.Repositories.PessoaRepository;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa getPessoaById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public void deletePessoaById(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoaExistente = pessoaRepository.findById(id).orElse(null);

        if (pessoaExistente != null) {
            pessoaExistente.setNome(pessoaAtualizada.getNome());
            pessoaExistente.setEndereco(pessoaAtualizada.getEndereco());
            pessoaExistente.setCep(pessoaAtualizada.getCep());
            pessoaExistente.setCidade(pessoaAtualizada.getCidade());
            pessoaExistente.setUf(pessoaAtualizada.getUf());

            return pessoaRepository.save(pessoaExistente);
        } else {
            return null;
        }
    }

}
