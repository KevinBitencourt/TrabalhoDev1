package com.projeto.ChinaEstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.ChinaEstore.entidade.Venda;
@Repository
public interface VendaRepository extends JpaRepository<Venda,Long> {
    
}
