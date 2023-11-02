package com.minsaitjpa.desafio.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsaitjpa.desafio.Entity.Contato;
import com.minsaitjpa.desafio.Repositories.ContatoRepository;

@Service
public class ContatoService {
    
    @Autowired
    private ContatoRepository contatoRepository;

    public Contato saveContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public Contato getContatoById(Long id) {
        return contatoRepository.findById(id).orElse(null);
    }
    
    public List<Contato> getContatosByPessoaId(Long pessoaId) {
        return contatoRepository.findByPessoaId(pessoaId);
    }

    public List<Contato> getAllContatos() {
        return contatoRepository.findAll();
    }

    public void deleteContatoById(Long id) {
        contatoRepository.deleteById(id);
    }

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
