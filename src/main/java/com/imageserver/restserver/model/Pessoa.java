package com.imageserver.restserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Data
@Table(name = "pessoas")
public class Pessoa {
    
    @com.google.gson.annotations.SerializedName("nome")
    @Expose
    @Column(name = "nome", updatable = false, nullable = false, length = 50)
    private String nome;
    
    @com.google.gson.annotations.SerializedName("idade")
    @Expose
    @Column(name = "idade", updatable = false, nullable = false)
    private Integer idade;
    
    @com.google.gson.annotations.SerializedName("posicao")
    @Expose
    @Column(name = "posicao", updatable = true, nullable = false)
    private Long posicao;
  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
}
