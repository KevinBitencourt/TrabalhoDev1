package com.projeto.ChinaEstore.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.ChinaEstore.entidade.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
}
