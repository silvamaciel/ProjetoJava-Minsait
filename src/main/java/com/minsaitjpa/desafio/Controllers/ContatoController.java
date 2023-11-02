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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/contatos")

@Api(value = "Contato Controller", description = "Operações relacionadas a Contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @ApiOperation(value = "Adicionar um novo Contato a uma Pessoa")
    @PostMapping("/pessoas/{id}/contatos")
    public Contato adicionarContatoAPessoa(@PathVariable Long id, @RequestBody Contato contato) {
        return contatoService.saveContato(contato);
    }

    @ApiOperation(value = "Obter um Contato por ID")
    @GetMapping("/{id}")
    public Contato getContatoPorId(@PathVariable Long id) {
        return contatoService.getContatoById(id);
    }
    
    @ApiOperation(value = "Listar todos os Contatos de uma Pessoa")
    @GetMapping("/pessoas/{idPessoa}/contatos")
    public List<Contato> listarContatosDeUmaPessoa(@PathVariable Long idPessoa) {
        return contatoService.getContatosByPessoaId(idPessoa);
    }

    @ApiOperation(value = "Atualizar um Contato existente por ID")
    @PutMapping("/{id}")
    public Contato atualizarContato(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
        return contatoService.atualizarContato(id, contatoAtualizado);
    }

    @ApiOperation(value = "Remover um Contato por ID")
    @DeleteMapping("/{id}")
    public void deletarContato(@PathVariable Long id) {
        contatoService.deleteContatoById(id);
    }
}
