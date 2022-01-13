import {ReactComponent as Arrow} from "../../assets/img/arrow.svg";
import "./styles.css";

function Pagination() {
    return(
        <div className="myclass-pagination-container">
            <div className="myclass-pagination-box">
                <button className="myclass-pagination-button" disabled={true} >
                    <Arrow />
                </button>

                <p>{`${1} de ${3}`}</p>

                <button className="myclass-pagination-button" disabled={false} >
                    <Arrow className="myclass-flip-horizontal" />
                </button>
            </div>
        </div>
    );
}
export default Pagination;