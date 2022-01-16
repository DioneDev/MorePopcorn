package com.devsuperior.morePopcorn.controllers;

import com.devsuperior.morePopcorn.dto.MovieDTO;
import com.devsuperior.morePopcorn.dto.ScoreDTO;
import com.devsuperior.morePopcorn.services.MovieService;
import com.devsuperior.morePopcorn.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO){
        MovieDTO movieDTO = scoreService.saveScore(scoreDTO);
        return movieDTO;
    }
}
