import "./styles/Lesson.css";
import complete from "../assets/check-circle.png";
import incomplete from "../assets/oval.png";
import clock from "../assets/clock.png";

function Lesson(props :any){
    return <div className="lesson">

        <div className="lesson-information">
        {
            props.status==="complete"?<img className="statusIcon" src={complete}/>:<img className="statusIcon glow" src={incomplete}/>
        }
        
        <p>{props.title}</p>
        <img src={clock}/>
        <p>{props.duration}</p>
        {
            props.status==="complete"?<button className="start-lesson">Revisar</button>:<button  className="start-lesson">Começar</button>

        }
        </div>
       
    </div>
}

export default Lesson;