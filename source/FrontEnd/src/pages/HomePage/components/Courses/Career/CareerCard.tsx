import "./styles/career.css";
import { useNavigate } from "react-router-dom";

function Career(props: any) {

  const navigate = useNavigate();

  return (
    <div className="card-carreira">
      <img src={props.imageurl} className="imagem-card" />
      <section className="content-carreira">
        <h5>{props.title}</h5>
        <p className="field">Aulas</p>
        <p>{props.lessons}</p>

        {props.language ? (
          <>
            <p className="field">Tecnologia</p> <p>{props.language}</p>
          </>
        ) : (
          ""
        )}

        <p>Certificado Incluso</p>
      </section>
      <div className={`wrapper`}>
        <button
          className={`course-begin-btn ${props.demoMode}`}
          onClick={(e) => {
            navigate("/course");
          }}
        >
          Começar
        </button>
      </div>
    </div>
  );
}
export default Career;
