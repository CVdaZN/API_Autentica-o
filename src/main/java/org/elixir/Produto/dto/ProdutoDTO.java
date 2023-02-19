package org.elixir.Produto.dto;

import org.elixir.Produto.model.Produto;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

public record ProdutoDTO(Long id,
                         @NotNull String nome,
                         @NotNull Double preco,
                         String descricao) {

    public ProdutoDTO(Long id, String nome, Double preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    Produto ToModel() {
        return new Produto(null, nome(), preco(), descricao());
    }
}
