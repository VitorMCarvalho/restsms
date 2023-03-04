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
@Table(name = "organizacaoFila")
public class OrganizacaoFila {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @com.google.gson.annotations.SerializedName("fila")
    @Expose
    @Column(name = "fila", updatable = true, nullable = true)
    private List<Long> fila;
}
