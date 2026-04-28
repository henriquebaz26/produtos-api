package com.henriquebazdev.produtos_api;

import java.util.List;

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
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    // READ
    @GetMapping
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Long id) {
        Produto product = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        product.setNome(produto.getNome());
        product.setPreco(produto.getPreco());
        product.setQuantidade(produto.getQuantidade());

        return repository.save(product);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
