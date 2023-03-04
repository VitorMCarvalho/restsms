package com.imageserver.restserver.Repository;

import com.imageserver.restserver.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
