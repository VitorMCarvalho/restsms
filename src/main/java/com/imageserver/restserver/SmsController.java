package com.imageserver.restserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.imageserver.restserver.Repository.PessoaRepository;
import com.imageserver.restserver.Repository.FilaRepository;
import com.imageserver.restserver.model.Pessoa;
import com.imageserver.restserver.model.OrganizacaoFila;

@RestController
public class SmsController {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    FilaRepository filaRepository;
    
    @GetMapping("/enviarSms/:num")
    public void enviar(@PathVariable("numero") String num){
        OrganizacaoFila fila = filaRepository.findById(0);
        Long numero = Long.valueOf(num);
        fila.getFila().add(numero);
        fila.setFila(Arrays.sort(fila.getFila(), Collections.reverseOrder()));
        filaRepository.save(fila);
        HelloTelesign.enviarSms(numero, Arrays.binarySearch(fila, numero));
    }

}
