package com.minsaitjpa.desafio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minsaitjpa.desafio.Dtos.PessoaDTO;
import com.minsaitjpa.desafio.Entity.Pessoa;
import com.minsaitjpa.desafio.Services.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;



@RestController
@RequestMapping("/api/pessoas")

@Api(value = "Pessoa Controller", description = "Operações relacionadas a Pessoas")

public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @ApiOperation(value = "Criar uma nova Pessoa")

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.savePessoa(pessoa);
    }

    @ApiOperation(value = "Obter uma Pessoa por ID")

    @GetMapping("/{id}")
    public Pessoa getPessoaPorId(@PathVariable Long id) {
        return pessoaService.getPessoaById(id);
    }

    @ApiOperation(value = "Listar todas as Pessoas")
    @GetMapping
    public List<Pessoa> listarTodasPessoas() {
        return pessoaService.getAllPessoas();
    }

    @ApiOperation(value = "Atualizar uma Pessoa existente por ID")
    @PutMapping("/{id}")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        return pessoaService.atualizarPessoa(id, pessoaAtualizada);
    }
    
    @ApiOperation(value = "Remover uma Pessoa por ID")
    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaService.deletePessoaById(id);
    }

    @ApiOperation(value = "Obter uma Pessoa para Mala Direta por ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Pessoa encontrada para Mala Direta", response = PessoaDTO.class),
        @ApiResponse(code = 404, message = "Pessoa não encontrada")
    })
    
    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaDTO> getPessoaParaMalaDireta(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.getPessoaById(id);
        if (pessoa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getEndereco(), pessoa.getCep(), pessoa.getCidade(), pessoa.getUf());

        return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
    }
    
}
