package br.com.casasbahia.crud_h2.service;

import br.com.casasbahia.crud_h2.model.Produto;
import br.com.casasbahia.crud_h2.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }

    public Produto atualizar(Produto produto) {
        if (!produtoRepository.existsById(produto.getId())) {
            throw new RuntimeException("Produto não encontrado com o ID: " + produto.getId());
        }
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
        produtoRepository.deleteById(id);
    }

}
