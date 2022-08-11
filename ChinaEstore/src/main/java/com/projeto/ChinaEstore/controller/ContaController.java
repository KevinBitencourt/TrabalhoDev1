package com.projeto.ChinaEstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.ChinaEstore.entidade.Conta;
import com.projeto.ChinaEstore.repository.ContaRepository;



@Controller
public class ContaController {
    @Autowired
    private ContaRepository contaRepository;

    @PostMapping("/contas")
    @ResponseBody
    public Conta salvarConta(@RequestBody Conta conta){
      contaRepository.save(conta);
        return conta;
    }
    @GetMapping("/contas/lista")
    @ResponseBody
    public List<Conta> listarContas(){
        List<Conta > ct = new ArrayList<>();
       ct = contaRepository.findAll();
        return ct;
    }
    @RequestMapping(path="/conta/delete/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletarContaPorId(@PathVariable ("Id")Long id){
        contaRepository.deleteById(id);
        return "Conta Deletada";
    } 
 
    @RequestMapping(path="/conta/lista/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Conta> listaContaPorId(@PathVariable ("Id")Long id){
       Optional<Conta> obj = contaRepository.findById(id);
        return obj;
    }

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

