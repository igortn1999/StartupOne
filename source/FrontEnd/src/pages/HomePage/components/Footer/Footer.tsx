import logo from "../../../assets/logo.png";
import pinkBar from "../../../assets/pink_bar.svg";
import linkedIn from "../../../assets/linkedin.png";
import facebook from "../../../assets/facebook.png";
import instagram from "../../../assets/instagram.png";
import twitter from "../../../assets/twitter.png";
import "./styles/footer.css";

function Footer() {
  return (
    <div className="Footer">
      <img src={logo} width={300} height={50} />
      <img className="separator" src={pinkBar}/>
      <ul>
        <li>Sobre nós</li>
        <li>Catálogo</li>
        <li>Comunidade</li>
      </ul>
      <img className="separator" src={pinkBar}/>
      <ul>
        <li>FAQ</li>
        <li>Ajuda</li>
        <li>Licenças</li>
      </ul>

      <img className="separator" src={pinkBar}/>
      <div className="social-media">
        <ul>
          <li><img src={linkedIn}  alt="LinkedIn Logo" className="social-media-logo"/></li>
          <li><img src={instagram}  alt="instagram Logo" className="social-media-logo"/></li>
          <li><img src={facebook}  alt="facebook Logo" className="social-media-logo"/></li>
          <li><img src={twitter}  alt="twitter Logo" className="social-media-logo"/></li>
        </ul>
      </div>
      <hr className="footer-hr"></hr>
      <p className="rights">2023 © CODI.GO OFICIAL - FEITO POR CODI.GO - TODOS OS DIREITOS RESERVADOS</p>
    </div>
  );
}

export default Footer;
