package com.minsaitjpa.desafio.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsaitjpa.desafio.Entity.Contato;


public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findByPessoaId(Long pessoaId);
}
