package com.minsaitjpa.desafio.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsaitjpa.desafio.Entity.Contato;

import io.swagger.annotations.ApiOperation;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    @ApiOperation("Retorna uma lista de contatos com base no ID da pessoa")
    List<Contato> findByPessoaId(Long pessoaId);
}
