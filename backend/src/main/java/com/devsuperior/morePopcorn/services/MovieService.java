package com.devsuperior.morePopcorn.services;

import com.devsuperior.morePopcorn.dto.MovieDTO;
import com.devsuperior.morePopcorn.entities.Movie;
import com.devsuperior.morePopcorn.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // RETORNA PAGINA COM A LISTA DE FILMES DO BANCO
    @Transactional(readOnly = true) // Metodo somente de leitura, fica mais eficiente no banco.
    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> movieListDatabase = movieRepository.findAll(pageable);
        Page<MovieDTO> moviePageDto = movieListDatabase.map(movieItem -> new MovieDTO(movieItem));

        return moviePageDto;
    }

    // RETORNA FILME PELO ID
    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
        Movie movieIdDatabase = movieRepository.findById(id).get();
        MovieDTO movieIdDto = new MovieDTO(movieIdDatabase);

        return movieIdDto;
    }
}
