package com.minsaitjpa.desafio.Dtos;



public class PessoaDTO {
    private Long id;
    private String nome;

    // Atributo para a mala direta que retorna um endereço formatado
    private String malaDireta;

    public PessoaDTO() {
    }

    public PessoaDTO(Long id, String nome, String endereco, String cep, String cidade, String uf) {
        this.id = id;
        this.nome = nome;
        this.malaDireta = String.format("%s - CEP: %s - %s/%s", endereco, cep, cidade, uf);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMalaDireta() {
        return malaDireta;
    }

    public void setMalaDireta(String malaDireta) {
        this.malaDireta = malaDireta;
    }
    

}
