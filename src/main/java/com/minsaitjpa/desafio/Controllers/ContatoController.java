package com.minsaitjpa.desafio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsaitjpa.desafio.Entity.Contato;
import com.minsaitjpa.desafio.Services.ContatoService;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/pessoas/{id}")
    public Contato adicionarContatoAPessoa(@PathVariable Long id, @RequestBody Contato contato) {
        // Você deve implementar a lógica para associar o Contato à Pessoa com o ID
        // fornecido.
        // contato.setPessoa(pessoaService.getPessoaById(id));
        return contatoService.saveContato(contato);
    }

    @GetMapping("/{id}")
    public Contato getContatoPorId(@PathVariable Long id) {
        return contatoService.getContatoById(id);
    }
    
    @GetMapping("/pessoas/{idPessoa}")
    public List<Contato> listarContatosDeUmaPessoa(@PathVariable Long idPessoa) {
        // Você deve implementar a lógica para obter todos os Contatos associados a uma Pessoa com o ID fornecido.
        // Exemplo: contatoService.getContatosByPessoaId(idPessoa);
        return contatoService.getContatosByPessoaId(idPessoa);
    }

    @PutMapping("/{id}")
    public Contato atualizarContato(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
        return contatoService.atualizarContato(id, contatoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarContato(@PathVariable Long id) {
        contatoService.deleteContatoById(id);
    }
}