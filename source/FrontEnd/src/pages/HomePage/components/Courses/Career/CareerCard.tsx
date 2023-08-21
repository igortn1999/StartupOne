import "./styles/career.css";

function Career(props: any) {
  return (
    <div className="card-carreira">
      <img src={props.imageurl} className="imagem-card" />
      <section className="content-carreira">
        <h5>{props.title}</h5>
        <p>Aulas: {props.lessons}</p>

        {props.language ? <p>Linguagem: {props.language}</p> : ""}

        <p>Certificado Incluso</p>
      </section>
      <div className={`wrapper`}>
        <button className={`course-begin-btn ${props.demoMode}`} onClick={(e)=>{
          alert("Oi");
        }}>
          Começar
        </button>
      </div>
    </div>
  );
}
export default Career;
