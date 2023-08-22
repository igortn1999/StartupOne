import "./styles/courseDetails.css";

import Footer from "../HomePage/components/Footer/Footer";
import Navbar from "../Navbar";
import Lesson from "./components/Lesson";

function CourseDetails() {
  return (
    <>
      <Navbar />
      <div className="course-details">
        <h1>Python</h1>
        <h2>do básico ao avançado</h2>

        <section className="course-description">
          <p>
            O curso Python, do zero ao avançado é um curso completo para quem
            deseja aprender Python e se tornar um desenvolvedor com
            conhecimentos intermediários. O curso é ministrado pelo professor
            John Doe, é atualizado com a última versão do, Python 3.11 e inclui
            10 cases reais para ajudar você a desenvolver as habilidades de
            programação.
          </p>
        </section>

        <div className="summarized-information">
          <p>Progresso do curso</p>
          <p>Duração total</p>
          <div
            className="progress"
            id="progressbar"
            role="progressbar"
            aria-label="Basic example"
            aria-valuenow={25} // Change this line to use a number
            aria-valuemin={0}
            aria-valuemax={100}
          >
            <div className="progress-bar" style={{ width: "25%" }}>25%</div>
          </div>
          <p>30 / 120 Minutos</p>
        </div>
        <section className="course-list">
          <Lesson
            title={"Introdução"}
            duration={"15 Minutos"}
            status={"complete"}
          />
          <Lesson title={"Conceitos Básicos"} duration={"45 Minutos"} />
          <Lesson title={"Loops"} duration={"120 Minutos"} />
          <Lesson title={"Condicionais"} duration={"15 Minutos"} />
        </section>
      </div>
      <Footer />
    </>
  );
}
export default CourseDetails;
