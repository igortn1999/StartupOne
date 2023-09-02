import '../styles/codeOutput.css'

function CodeOutput(props :any){

    return <div className="CodeOutput">
        <h1>{props.text?props.text:"O Resultado do seu código aparecerá aqui"}</h1>
    </div>
}

export default CodeOutput;
