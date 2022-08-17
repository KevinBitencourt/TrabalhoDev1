package com.projeto.ChinaEstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.ChinaEstore.entidade.Conta;
@Repository
public interface ContaRepository extends JpaRepository<Conta,Long>{
    
}
