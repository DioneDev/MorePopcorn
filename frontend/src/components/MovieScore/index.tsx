import MovieStars from "../MovieStars";
import "./styles.css";

type Props = {
    score: number;
    count: number;
}

function MovieScore({ score, count } : Props){

    return(

        <div className="myclass-score-container">
            <p className="myclass-score-value">
                {score > 0 ? score.toFixed(1) : "Seja o primeiro a avaliar este filme!"}
            </p>

            <MovieStars score={score} />

            <p className="myclass-score-count">
                {count} avaliações
            </p>
        </div>
    );
}
export default MovieScore;