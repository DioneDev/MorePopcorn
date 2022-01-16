package com.devsuperior.morePopcorn.repositories;

import com.devsuperior.morePopcorn.entities.Score;
import com.devsuperior.morePopcorn.entities.ScorePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePrimaryKey> {

}
