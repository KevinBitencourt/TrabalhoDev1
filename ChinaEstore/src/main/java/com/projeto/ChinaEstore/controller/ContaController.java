package com.projeto.ChinaEstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.ChinaEstore.entidade.Conta;
import com.projeto.ChinaEstore.repository.ContaRepository;



@Controller
public class ContaController {
    @Autowired
    private ContaRepository contaRepository;
    @GetMapping("/conta/saldo/{id}")
    @ResponseBody
    public String saldoConta(@PathVariable("id")Long id){
        Optional<Conta> ct = contaRepository.findById(id);
        if(ct.isEmpty()){
        throw new IllegalArgumentException("Conta não existe");
        }
        return ct.get().getSaldo();
    }
    

}   

