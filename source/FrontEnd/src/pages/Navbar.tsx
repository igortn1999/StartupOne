import "./Styles/navbar.css";
import logo from "./assets/logo.png";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary navbar-home">
      <div className="container-fluid">
        <img src={logo} className="startup-logo"/>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse nav-items-container" id="navbarNav">
          <ul className="navbar-nav">
            <li className="nav-item">
              <a className="nav-link active" aria-current="page" href="#">
                Home
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">
                Catálogo
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">
                Serviços
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">
                Planos
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">
                Sobre nós
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">
                Login
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#">
                Cadastro
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
