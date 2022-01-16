import axios from "axios";
import { useEffect, useState } from "react";
import MovieCard from "../../components/MovieCard";
import Pagination from "../../components/Pagination";
import { MoviePage } from "../../types/movie";
import { BASE_URL } from "../../utils/requests";

function Listing(){

    const[pageNumber, setPageNumber] = useState(0);

    const[page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=title`)
        .then(response => {
            const data = response.data as MoviePage;
            setPage(data);
        });

    }, [pageNumber]);

    return(
        // Usando Fragment <> </> porque a funcao aceita apenas 1 componemte
        <> 
            <Pagination />
            
            <div className="container">
                <div className="row">
                    
                    {/* === Divisao grid system do bootstrap ===
                        sm < 576px 12 col de 12 ou 1 card por linha
                        sm > 576px 6 col de 12 ou 2 card por linha
                        lg > 992px 4 col de 12 ou 3 card por linha
                        xl > 1200px 3 col de 12 ou 4 card por linha
                    */}

                    {page.content.map(movie => (
                        
                        <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3"> 
                            <MovieCard movie={movie} />
                        </div>
                    ))}
                </div>
            </div>
        </>
    );
}
export default Listing;