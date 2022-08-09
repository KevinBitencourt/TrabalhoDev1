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

import com.projeto.ChinaEstore.entidade.Cliente;
import com.projeto.ChinaEstore.repository.ClienteRepository;



@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @PostMapping("/clientes")
    @ResponseBody
    public Cliente salvarCliente(@RequestBody Cliente cliente){
      clienteRepository.save(cliente);
        return cliente;
    }
    @GetMapping("/clientes/lista")
    @ResponseBody
    public List<Cliente> listarClientes(){
        List<Cliente > cl = new ArrayList<>();
       cl = clienteRepository.findAll();
        return cl;
    }
    @RequestMapping(path="/cliente/delete/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletarClientePorId(@PathVariable ("Id")Long id){
        clienteRepository.deleteById(id);
        return "Cliente Deletado";
    }

    @RequestMapping(path="/cliente/lista/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Cliente> listaClientePorId(@PathVariable ("Id")Long id){
       Optional<Cliente> obj = clienteRepository.findById(id);
        return obj;
    }
    //Verifica saldo fora do crud
    @RequestMapping(path="/cliente/lista/saldo/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public String listaSaldoClientePorId(@PathVariable ("Id")Long id){
       Optional<Cliente> obj = clienteRepository.findById(id);
       String saldo = obj.get().getConta().getSaldo();
       if(saldo == null){
        System.out.println("Saldo vazio");
       }
       return obj.get().getConta().getSaldo();
    }
}
