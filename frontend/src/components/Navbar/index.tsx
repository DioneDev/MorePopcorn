import {ReactComponent as GithubIcon} from '../../assets/img/github.svg'; // Adicionado baseUrl no tsconfig.json
import './styles.css';

function Navbar() {
  return (
    <header>
        <nav className="container">
            <div className="myclass-nav-content">

                <h1>MovieNight</h1>
                <a href="https://github.com/DioneDev" target="_blank">
                    <div className="myclass-contact-container">
                        <GithubIcon />
                        <p className="myclass-contact-link">/DioneDev</p>
                    </div>
                </a>
            </div>
        </nav>
    </header>
  );
}
export default Navbar;
