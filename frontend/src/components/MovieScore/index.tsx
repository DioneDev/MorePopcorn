import MovieStars from "../MovieStars";
import "./styles.css";

function MovieScore(){

    const score = 4.3;
    const count = 25;

    return(

        <div className="myclass-score-container">
            <p className="myclass-score-value">
                {score > 0 ? score.toFixed(1) : "Seja o primeiro a avaliar este filme!"}
            </p>

            <MovieStars />

            <p className="myclass-score-count">
                {count} Avaliações
            </p>
        </div>
    );
}
export default MovieScore;