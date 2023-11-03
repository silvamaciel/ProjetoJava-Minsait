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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")

public class ContatoController {

    @Autowired
    private ContatoService contatoService;
    
    @Operation(summary = "Adiciona um contato a uma pessoa")
    @PostMapping("/pessoas/{id}/contatos")
    public Contato adicionarContatoAPessoa(@PathVariable Long id, @RequestBody Contato contato) {
        return contatoService.saveContato(contato);
    }

    @Operation(summary = "Lista todos os contatos")
    @GetMapping("/{id}")
    public Contato getContatoPorId(@PathVariable Long id) {
        return contatoService.getContatoById(id);
    }

    @Operation(summary = "Lista todos os contatos de uma pessoa")
    @GetMapping("/pessoas/{idPessoa}/contatos")
    public List<Contato> listarContatosDeUmaPessoa(@PathVariable Long idPessoa) {
        return contatoService.getContatosByPessoaId(idPessoa);
    }

    @Operation(summary = "Atualiza um contato pelo ID")
    @PutMapping("/{id}")
    public Contato atualizarContato(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
        return contatoService.atualizarContato(id, contatoAtualizado);
    }

    @Operation(summary = "Deleta um contato pelo ID")
    @DeleteMapping("/{id}")
    public void deletarContato(@PathVariable Long id) {
        contatoService.deleteContatoById(id);
    }
}
