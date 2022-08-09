package com.projeto.ChinaEstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ChinaEstore.entidade.Venda;

public interface VendaRepository extends JpaRepository<Venda,Long> {
    
}
