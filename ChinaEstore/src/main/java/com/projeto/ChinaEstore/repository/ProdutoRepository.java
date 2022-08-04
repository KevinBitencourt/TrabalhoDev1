package com.projeto.ChinaEstore.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ChinaEstore.entidade.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
}
