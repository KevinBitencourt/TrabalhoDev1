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

import com.projeto.ChinaEstore.entidade.Venda;
import com.projeto.ChinaEstore.repository.VendaRepository;

@Controller
public class VendaController {
   @Autowired
   private VendaRepository vendaRepository;
   @PostMapping("/vendas")
   @ResponseBody
   public Venda salvarVenda(@RequestBody Venda venda){
     vendaRepository.save(venda);
       return venda;
   }
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
