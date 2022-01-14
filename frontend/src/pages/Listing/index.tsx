import MovieStars from "../../components/MovieStars";
import Pagination from "../../components/Pagination";

function Listing(){
    return(
        // Usando Fragment <> </> porque a funcao aceita apenas 1 componemte
        <> 
            <Pagination />
            <MovieStars />
        </>
    );
}
export default Listing;