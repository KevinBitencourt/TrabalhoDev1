package com.projeto.ChinaEstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.ChinaEstore.entidade.Cliente;
import com.projeto.ChinaEstore.entidade.Produto;
import com.projeto.ChinaEstore.entidade.Venda;
import com.projeto.ChinaEstore.repository.ClienteRepository;
import com.projeto.ChinaEstore.repository.ProdutoRepository;
import com.projeto.ChinaEstore.repository.VendaRepository;

@Controller
public class VendaController {
    @Autowired
    private ClienteController ct;
    @Autowired
    private ProdutoController obj;

   @Autowired
   private VendaRepository vendaRepository;
   private ClienteRepository clienteRepository;
   private ProdutoRepository produtoRepository;
   /*@RequestMapping(path="/venda/{id1}/{id2}", method = RequestMethod.GET)
   @ResponseBody
   public Venda salvar(@PathVariable("id1")Long id1, @PathVariable("id2")Long id2){
    Produto pdt;
   
   Optional<Produto> produto; // = new Produto();
    Optional<Cliente> cliente;// = new Cliente();
    Venda venda = new Venda();
    
    cliente = clienteRepository.findById(id1);
    produto = produtoRepository.findById(id2);
    //pdt = produto;
    venda.getCliente();
    venda.getProduto();
    return venda;
    } */

   @GetMapping("/vendas/lista")
   @ResponseBody
   public List<Venda> listarVendas(){
       List<Venda > vd = new ArrayList<>();
      vd = vendaRepository.findAll();
       return vd;
   }
   @RequestMapping(path="/venda/delete/{Id}", method = RequestMethod.DELETE)
   @ResponseBody
   public String deletarVendaPorId(@PathVariable ("Id")Long id){
       vendaRepository.deleteById(id);
       return "Venda Deletada";
   }

   @RequestMapping(path="/venda/lista/{Id}", method = RequestMethod.GET)
   @ResponseBody
   public Optional<Venda> listaVendaPorId(@PathVariable ("Id")Long id){
      Optional<Venda> obj = vendaRepository.findById(id);
       return obj;
   }

}
