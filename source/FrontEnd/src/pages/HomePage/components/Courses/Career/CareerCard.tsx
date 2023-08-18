import "./styles/career.css";

function Career(props: any) {
  return (
    <div className="card-carreira">
         <img
        src={
          props.imageurl
        }
        className="imagem-card"
      />
      <section className="content-carreira">
        <h5>{props.title}</h5>
        <p>Aulas: {props.lessons}</p>
        <p>Linguagem: {props.language}</p>
        <p>Certificado Incluso</p>
        <button className="course-begin">
            Começar
        </button>
      </section>
    </div>
  );
}
export default Career;
