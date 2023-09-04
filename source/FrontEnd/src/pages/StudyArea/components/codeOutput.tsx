import { useState } from "react";
import "../styles/codeOutput.css";

function CodeOutput(props: any) {
    console.log(props.text);
    const execution = props.text.execution;
  
    return (
      <div className="CodeOutput">
        <div className="errorArea" hidden={!props.text.error}>
          <p>{props.text.error ? props.text.error : "Sem erros"}</p>
        </div>
        <h1>{execution ? execution : "Seu código aparecerá aqui"}</h1>
      </div>
    );
  }
  

export default CodeOutput;
