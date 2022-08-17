package com.projeto.ChinaEstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.ChinaEstore.entidade.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
  
   /*public Cliente salvarCliente(Cliente cliente){
       return save(Cliente).;
    }*/
    
}
