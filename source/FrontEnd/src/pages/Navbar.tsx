import { Link, useNavigate } from "react-router-dom";
import "./Styles/navbar.css";
import logo from "./assets/logo.png";
function Navbar() {
  const navigate = useNavigate();
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary navbar-home">
      <div className="container-fluid">
        <img
          src={logo}
          id="startup-logo"
          onClick={(e) => {
            navigate("/");
          }}
        />
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
        <div
          className="collapse navbar-collapse nav-items-container"
          id="navbarNav"
        >
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link className="nav-item nav-link" to={"/"}>
                Home
              </Link>
            </li>
            <li className="nav-item">
              <a className="nav-item nav-link" href={"/#catalogo"}>
                Catálogo
              </a>
            </li>
            <li className="nav-item">
              <Link className="nav-item nav-link" to={"/"}>
                Serviços
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-item nav-link" to={"/"}>
                Planos
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-item nav-link" to={"/"}>
                Sobre nós
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-item nav-link" to={"/"}>
                Login
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-item nav-link" to={"/"}>
                Cadastro
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
