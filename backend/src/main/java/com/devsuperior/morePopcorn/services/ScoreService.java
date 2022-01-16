package com.devsuperior.morePopcorn.services;

import com.devsuperior.morePopcorn.dto.MovieDTO;
import com.devsuperior.morePopcorn.dto.ScoreDTO;
import com.devsuperior.morePopcorn.entities.Movie;
import com.devsuperior.morePopcorn.entities.Score;
import com.devsuperior.morePopcorn.entities.User;
import com.devsuperior.morePopcorn.repositories.MovieRepository;
import com.devsuperior.morePopcorn.repositories.ScoreRepository;
import com.devsuperior.morePopcorn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO){

        User user = userRepository.findByEmail(scoreDTO.getEmail());

        if(user == null){
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());

        score = scoreRepository.saveAndFlush(score);

        // REGRA PARA SOMAR AS AVALIACOES
        double sum = 0.0;

        for(Score scoreItem : movie.getScoreSet()){
            sum = sum + scoreItem.getValue();
        }
        double average = sum / movie.getScoreSet().size();

        // REGRA PARA SALVAR A MEDIA DE AVALIACOES NO FILME
        movie.setScore(average);
        movie.setCount(movie.getScoreSet().size());
        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }

}
