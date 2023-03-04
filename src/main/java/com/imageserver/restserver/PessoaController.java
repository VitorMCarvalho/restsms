package com.imageserver.restserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.imageserver.restserver.Repository.PessoaRepository;
import com.imageserver.restserver.model.Pessoa;

import java.util.List;
import java.util.Objects;

@RestController
public class PessoaController {
    
    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/pessoas")
    public List<Pessoa> listAll(){
        return  pessoaRepository.findAll();
    }

    @PostMapping("/pessoas")
    public Pessoa save(@RequestBody Pessoa novaPessoa){
        if(novaPessoa.getIdade() < 0 || novaPessoa.getIdade() > 120){
            return null;
        }else if(Objects.isNull(novaPessoa) || Objects.equals(novaPessoa,"")){
            return null;
        }else{
            return pessoaRepository.save(novaPessoa);
        }
    }

    @DeleteMapping("/pessoas/:id")
    public void deleteImages(@PathVariable("id") Long id){
        pessoaRepository.deleteById(id);
    }

    @PutMapping("/pessoas/:id")
    public Pessoa save(@PathVariable("id") Long id, @RequestBody Pessoa novaPessoa){
        if(novaPessoa.getIdade() < 0 || novaPessoa.getIdade() > 120){
            return null;
        }else if(Objects.isNull(novaPessoa) || Objects.equals(novaPessoa,"")){
            return null;
        }else{
            Pessoa pessoaAntiga = pessoaRepository.findById(id);
            if(Objects.isNull(pessoaAntiga)){
                return null;
            }
            pessoaAntiga.setNome(novaPessoa.getNome());
            pessoaAntiga.setIdade(novaPessoa.getIdade());
            pessoaAntiga.setPosicao(novaPessoa.getPosicao());
            return pessoaRepository.save(pessoaAntiga);
        }
    }
}
