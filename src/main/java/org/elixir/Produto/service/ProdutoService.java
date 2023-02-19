package org.elixir.Produto.service;

import org.elixir.Produto.exception.ProductNullException;
import org.elixir.Produto.exception.ProductPriceException;
import org.elixir.Produto.model.Produto;
import org.elixir.Produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto createProduto(Produto produto) throws Exception {
        if (produto.getNome() == null || produto.getPreco() == null || produto.getDescricao() == null) {
            throw new ProductNullException();
        }
        if (produto.getPreco() <= 0) {
            throw new ProductPriceException();
        }
        return produtoRepository.save(produto);
    }

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }
}
