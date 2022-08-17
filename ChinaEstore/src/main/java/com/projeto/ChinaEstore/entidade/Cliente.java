package com.projeto.ChinaEstore.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    
    private String nome;
    private String cpf;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Conta conta;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produtos;
}