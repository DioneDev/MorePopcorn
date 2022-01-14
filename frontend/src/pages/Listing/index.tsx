import MovieScore from "../../components/MovieScore";
import Pagination from "../../components/Pagination";

function Listing(){
    return(
        // Usando Fragment <> </> porque a funcao aceita apenas 1 componemte
        <> 
            <Pagination />
            <MovieScore />
        </>
    );
}
export default Listing;