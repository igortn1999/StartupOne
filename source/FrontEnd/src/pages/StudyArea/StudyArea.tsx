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
import API_URL from "../../config";

function StudyArea(props: any) {
  const [code, setCode] = useState(props.code);
  const [codeResults,setCodeResults] = useState({"error":undefined,"code":""});

  function handleSubmission() {
    const data = {
      code: code,
      lessonId: Number(props.id),
      validationType: "regex",
    };

    const url = `${API_URL}/api/courses/validate`; // Replace with your API endpoint

    fetch(url, {
      method: "post",
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    
      //make sure to serialize your JSON body
      body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
      setCodeResults(data);
      // do whatever you want with the data
    });
  }

  return (
    <>
      <Navbar />
      <div className="lesson-page">
        <section className="lesson-header">
          <h1>{props.title}</h1>
        </section>
        <div className="lesson">
          <iframe
            width="100%"
            height="500rem"
            src={`https://www.youtube.com/embed/${props.embedId}`}
            allow="picture-in-picture"
            allowFullScreen
            title="Embedded youtube"
          />
        </div>
        <section
          className="lesson-content"
          dangerouslySetInnerHTML={{ __html: props.lessonContent }}
        ></section>
        <div className="StudyArea">
          <div className="hands-on-material">
            <section>
              <p>{props.handsOnIntro}</p>
            </section>
            <section className="tasks">
              {props.tasks.map((task: string, i: number) => (
                <div className="form-check">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    value=""
                    id={`flexCheckCheckedDisabled${i + 1}`}
                  />
                  <label
                    className="form-check-label"
                    htmlFor={`flexCheckCheckedDisabled${i + 1}`}
                  >
                    {task}
                  </label>
                </div>
              ))}
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
          <CodeOutput text={codeResults}/>
        </div>
        <div className="control-bar">
          <button>Anteior</button>
          <button onClick={(e)=>{
            handleSubmission();
          }}>Executar Código</button>
          <button>Próximo</button>
        </div>
      </div>
    </>
  );
}

export default StudyArea;
