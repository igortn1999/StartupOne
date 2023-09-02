import "./styles/Lesson.css";
import complete from "../assets/check-circle.png";
import incomplete from "../assets/oval.png";
import clock from "../assets/clock.png";
import { Link, useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";

function Lesson(props: any) {
  const navigate = useNavigate();
  function handleClick() {
    window.scroll(0,0);
    navigate(`/lesson/${props.id}`);
  }

  return (
    <div className="lesson">
      <div className="lesson-information">
        {props.status === "complete" ? (
          <img className="statusIcon" src={complete} />
        ) : (
          <img className="statusIcon glow" src={incomplete} />
        )}

        <p>{props.title}</p>
        <img src={clock} />
        <p>{props.duration}</p>
        {props.status === "complete" ? (
          <button className="start-lesson" onClick={handleClick}>
            Revisar
          </button>
        ) : (
          <button className="start-lesson" onClick={handleClick}>
            Começar
          </button>
        )}
      </div>
    </div>
  );
}

export default Lesson;
