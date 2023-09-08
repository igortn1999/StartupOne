import { useState, useRef } from "react";
import AceEditor from "react-ace";
import "./styles/StudyArea.css";
import "ace-builds/src-noconflict/theme-dracula";
import "ace-builds/src-noconflict/mode-python";
import "ace-builds/src-noconflict/ace";
import CodeOutput from "./components/codeOutput";
import ReactDOMServer from "react-dom/server";
import HtmlToReactParser from "html-to-react";
import HelpIcon from "../../assets/question.png";
import Navbar from "../Navbar";
import API_URL from "../../config";
import { useNavigate } from "react-router-dom";

function StudyArea(props: any) {
  const [code, setCode] = useState(props.code);
  const [codeResults, setCodeResults] = useState({
    error: undefined,
    code: "",
  });
  const [selectedTasks, setSelectedTasks] = useState(
    Array(props.tasks.length).fill(false)
  );
  const navigate = useNavigate();

  console.log(selectedTasks);
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
        Accept: "application/json",
        "Content-Type": "application/json",
      },

      //make sure to serialize your JSON body
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((data) => {
        setCodeResults(data);
        // do whatever you want with the data
        setSelectedTasks(data.challengeList);
      });
  }

  const handleCheckboxChange = (index: number) => {
    const newSelectedTasks = [...selectedTasks];
    newSelectedTasks[index] = !newSelectedTasks[index];
    setSelectedTasks(newSelectedTasks);
  };

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
                <div className="form-check" key={i}>
                  <input
                    className="form-check-input"
                    type="checkbox"
                    value=""
                    id={`flexCheckCheckedDisabled${i + 1}`}
                    checked={selectedTasks[i]}
                    readOnly
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
          <CodeOutput text={codeResults} />
        </div>
        <div className="control-bar">
          <button id="previous">Anteior</button>
          <button
            id="execute"
            onClick={(e) => {
              handleSubmission();
            }}
          >
            Executar Código
          </button>
          <button
            id="next"
            onClick={(e) => {
              window.scroll(0, 0);
              navigate("/lesson/2");
            }}
          >
            Próximo
          </button>

          <button id="help">
            <img src={HelpIcon} height={30}/>
          </button>
        </div>
      </div>
    </>
  );
}

export default StudyArea;
