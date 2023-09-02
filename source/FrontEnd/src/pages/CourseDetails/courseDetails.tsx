import "./styles/courseDetails.css";

import Footer from "../HomePage/components/Footer/Footer";
import Navbar from "../Navbar";
import Lesson from "./components/Lesson";
import { useParams } from 'react-router-dom';
import { useEffect, useState } from "react";
import API_URL from "../../config";

function CourseDetails() {
  const embedId = "DXmCU7v9glM";
  const { id } = useParams();

  const [lessons,setLessons] = useState([
    {
      "id": 1,
      "course": {
        "id": 1,
        "name": "Python",
        "description": "Learn python today!",
        "estimateHours": 50.0,
        "overviewUrl": "DXmCU7v9glM",
        "image": "",
        "markers": []
      },
      "name": "introdução",
      "details": "O curso Python, do zero ao avançado é um curso completo para quem deseja aprender Python e se tornar um desenvolvedor com conhecimentos intermediários. O curso é ministrado pelo professor John Doe, é atualizado com a última versão do, Python 3.11 e inclui 10 cases reais para ajudar você a desenvolver as habilidades de programação.",
      "estimateHours": 0.25,
      "videoUrl": "BW9Va5syNC0",
      "codeExample": "#Escreva seu codigo abaixo\r\nidade=12\r\n\r\nnome = \"John Doe\"",
      "publishDate": "2023-09-02T11:25:07.794+00:00",
      "lang": "Python",
      "task": "Crie uma variável com a sua idade, Crie uma variável com o seu nome"
    },
    {
      "id": 2,
      "course": {
        "id": 1,
        "name": "Python",
        "description": "Learn python today!",
        "estimateHours": 50.0,
        "overviewUrl": "DXmCU7v9glM",
        "image": "",
        "markers": []
      },
      "name": "Arrays",
      "details": "learn how to use arrays in python!",
      "estimateHours": 0.5,
      "videoUrl": "RfCUO02nWGY",
      "codeExample": "Não há codigo, apenas veja esta receita da palmirinha!",
      "publishDate": "2023-09-02T11:25:07.810+00:00",
      "lang": "Python",
      "task": "Faça sua propria receita com a palmirinha!"
    }
  ])
  window.scroll(0,0);

  useEffect(()=>{
    fetch(`${API_URL}/api/courses/id/${id}/classes`)
    .then(res => res.json())
    .then(data => {
     // enter you logic when the fetch is successful
      console.log(data)
      setLessons(data);
    })
    .catch(error => {
      // enter your logic for when there is an error (ex. error toast)
     console.log(error)
    })
  },[])
  console.log(API_URL);
  
  return (
    <>
      <Navbar />
      <div className="course-details">
      <iframe
            width="74%"
            height="500rem"
            src={`https://www.youtube.com/embed/${lessons[0].course.overviewUrl}`}
            allow="picture-in-picture"
            allowFullScreen
            title="Embedded youtube"
          />
        <h1>Python</h1>
        <h2>do básico ao avançado</h2>

        <section className="course-description">
          {
            lessons?lessons[0].details: <p>
            O curso Python, do zero ao avançado é um curso completo para quem
            deseja aprender Python e se tornar um desenvolvedor com
            conhecimentos intermediários. O curso é ministrado pelo professor
            John Doe, é atualizado com a última versão do, Python 3.11 e inclui
            10 cases reais para ajudar você a desenvolver as habilidades de
            programação.
          </p>
          }
         
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
            <div className="progress-bar" style={{ width: "25%" }}>
              25%
            </div>
          </div>
          <p>30 / 150 Minutos</p>
        </div>
        <section className="course-list">

          {lessons?lessons.map((lesson)=><Lesson
            title={lesson.name}
            duration={`${lesson.estimateHours*60} Minutos`}
            status={"complete"}
          />):<>
          
          <Lesson
            title={"Introdução"}
            duration={"15 Minutos"}
            status={"complete"}
          />
          <Lesson title={"Condicionais"} duration={"45 Minutos"} />
          <Lesson title={"Loops"} duration={"15 Minutos"} />
          <Lesson title={"Funções"} duration={"45 Minutos"} />
          </>}
          <Lesson title={"Condicionais"} duration={"45 Minutos"} />
          <Lesson title={"Loops"} duration={"15 Minutos"} />
          <Lesson title={"Funções"} duration={"45 Minutos"} />
        </section>
      </div>
      <Footer />
    </>
  );
}
export default CourseDetails;
