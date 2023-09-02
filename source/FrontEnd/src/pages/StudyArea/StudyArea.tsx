import { useState, useRef } from "react";
import AceEditor from "react-ace";
import "./styles/StudyArea.css";
import "ace-builds/src-noconflict/theme-dracula";
import "ace-builds/src-noconflict/mode-python";
import "ace-builds/src-noconflict/ace";
import CodeOutput from "./components/codeOutput";
import ReactDOMServer from "react-dom/server";
import HtmlToReactParser from "html-to-react";
import Navbar from "../Navbar";

function StudyArea() {
  window.scroll(0,0);
  const [code, setCode] = useState(
    `#Escreva seu codigo abaixo\nmessage = "Hello World!" \n\nprint(message)`
  );
  const embedId = "BW9Va5syNC0";
  const lessonContent = `
  <h1>Variáveis e Tipos de Dados</h1>
  <h2>Visão geral</h2>
  <p>Na programação, as variáveis são usadas para armazenar valores que podem ser manipulados e acessados durante a execução do programa. Em Python, a declaração de uma variável é feita atribuindo um valor a ela. \n 
  Por exemplo
  </p>
  <code>nome = "João" <br></br>
  idade = <span class="orange">25</span> <br></br>
  altura = <span class="blue">1.75</span></code>
  <p>Em Python, existem diferentes tipos de dados que podem ser atribuídos às variáveis. Alguns dos tipos de dados básicos são:</p>
  <h2>Inteiros</h2>
  <p>representa números inteiros, como 1, 10, -5, etc. <br></br>
  Exemplo</p>
  <code>idade = <span class="orange">25</span></code>
  <h2>Número de ponto flutuante</h2>
  <p>representa números com casas decimais, como 3.14, 2.5, etc. 
<br></br>
  Exemplo</p>
  <code>altura = <span class="blue">1.75</span></code>
  
  <h2>Hands On</h2>
  `;

  const handsOnIntro = `Agora que você 
  já aprendeu alguns
  dos tipos básicos
  de dados do Python
  faça o seguinte:`;

  return (
    <>
      <Navbar />
      <div className="lesson-page">
        <section className="lesson-header">
          <h1>Conceitos Básicos de programação</h1>
        </section>
        <div className="lesson">
          <iframe
            width="100%"
            height="500rem"
            src={`https://www.youtube.com/embed/${embedId}`}
            allow="picture-in-picture"
            allowFullScreen
            title="Embedded youtube"
          />
        </div>
        <section
          className="lesson-content"
          dangerouslySetInnerHTML={{ __html: lessonContent }}
        ></section>
        <div className="StudyArea">
          <div className="hands-on-material">
            <section>
              <p>{handsOnIntro}</p>
            </section>
            <section className="tasks">
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="checkbox"
                  value=""
                  id="flexCheckCheckedDisabled"
                />
                <label
                  className="form-check-label"
                  htmlFor="flexCheckCheckedDisabled"
                >
                  Crie uma variável com a sua idade
                </label>
              </div>
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="checkbox"
                  value=""
                  id="flexCheckCheckedDisabled2"
                />
                <label
                  className="form-check-label"
                  htmlFor="flexCheckCheckedDisabled2"
                >
                  Crie uma variável com o seu nome
                </label>
              </div>
            </section>
          </div>
          <AceEditor
            mode="python"
            theme="dracula"
            value={code}
            onChange={(value) => setCode(value)}
            name="editor"
            style={{ width: "100%", height: "500px" }}
            fontSize={"16px"}
            editorProps={{ $blockScrolling: true }}
          />
          <CodeOutput />
        </div>
      </div>
    </>
  );
}

export default StudyArea;
