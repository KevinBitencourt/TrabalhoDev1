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

import com.projeto.ChinaEstore.entidade.Produto;
import com.projeto.ChinaEstore.repository.ProdutoRepository;



@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    @PostMapping("/produtos")
    @ResponseBody
    public Produto salvarProduto (@RequestBody Produto produto){
      produtoRepository.save(produto);
        return produto;
    }
    @GetMapping("/produtos/lista")
    @ResponseBody
    public List<Produto> listarProdutos(){
        List<Produto > pd = new ArrayList<>();
       pd = produtoRepository.findAll();
        return pd;
    }

    @RequestMapping(path="/produtos/delete/{Id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletarProdutoPorId(@PathVariable ("Id")Long id){
               produtoRepository.deleteById(id);
        return "Produto Deletado";
    }

    @RequestMapping(path="/produto/lista/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Produto> listaClientePorId(@PathVariable ("Id")Long id){
       Optional<Produto> obj = produtoRepository.findById(id);
        return obj;
    }

}