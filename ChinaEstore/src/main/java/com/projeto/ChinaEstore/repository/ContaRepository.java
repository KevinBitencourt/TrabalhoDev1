package com.projeto.ChinaEstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.ChinaEstore.entidade.Conta;

public interface ContaRepository extends JpaRepository<Conta,Long>{
    
}
