package com.devsuperior.morePopcorn.controllers;

import com.devsuperior.morePopcorn.dto.MovieDTO;
import com.devsuperior.morePopcorn.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // RETORNA PAGINA COM A LISTA DE FILMES
    @GetMapping
    public Page<MovieDTO> findAll(Pageable pageable){
        return movieService.findAll(pageable);
    }

    // RETORNA FILME PELO ID
    @GetMapping(value = "/{id}")
    public MovieDTO findById(@PathVariable Long id){
        return movieService.findById(id);
    }
}
