package com.minsaitjpa.desafio.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsaitjpa.desafio.Entity.Contato;
import com.minsaitjpa.desafio.Repositories.ContatoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Service
@Api(value = "ContatoService", description = "Serviço para gerenciamento de Contatos")

public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @ApiOperation("Salvar um novo Contato")

    public Contato saveContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @ApiOperation("Obter um Contato por ID")
    public Contato getContatoById(Long id) {
        return contatoRepository.findById(id).orElse(null);
    }

    @ApiOperation("Obter uma lista de Contatos com base no ID da Pessoa")
    public List<Contato> getContatosByPessoaId(Long pessoaId) {
        return contatoRepository.findByPessoaId(pessoaId);
    }

    @ApiOperation("Listar todos os Contatos")
    public List<Contato> getAllContatos() {
        return contatoRepository.findAll();
    }

    @ApiOperation("Remover um Contato por ID")
    public void deleteContatoById(Long id) {
        contatoRepository.deleteById(id);
    }

    @ApiOperation("Atualizar um Contato existente por ID")
    public Contato atualizarContato(Long id, Contato contatoAtualizado) {
        Contato contatoExistente = contatoRepository.findById(id).orElse(null);

        if (contatoExistente != null) {
            // Atualize os campos do contatoExistente com os valores do contatoAtualizado
            contatoExistente.setTipoContato(contatoAtualizado.getTipoContato());
            contatoExistente.setContato(contatoAtualizado.getContato());

            // Certifique-se de estabelecer o relacionamento com a Pessoa, se necessário
            // contatoExistente.setPessoa(contatoAtualizado.getPessoa());

            return contatoRepository.save(contatoExistente);
        } else {
            return null; // Contato não encontrado.
        }
    }
}
