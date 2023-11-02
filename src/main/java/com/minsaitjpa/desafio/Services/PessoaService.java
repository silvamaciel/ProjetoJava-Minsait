package com.minsaitjpa.desafio.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsaitjpa.desafio.Entity.Pessoa;
import com.minsaitjpa.desafio.Repositories.PessoaRepository;

import io.swagger.annotations.ApiOperation;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @ApiOperation("Salvar uma nova Pessoa")
    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @ApiOperation("Obter uma Pessoa por ID")
    public Pessoa getPessoaById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    @ApiOperation("Listar todas as Pessoas")
    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    @ApiOperation("Remover uma Pessoa por ID")
    public void deletePessoaById(Long id) {
        pessoaRepository.deleteById(id);
    }

    @ApiOperation("Atualizar uma Pessoa existente por ID")
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
