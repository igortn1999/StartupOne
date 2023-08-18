import Career from "./Career/CareerCard";
import "./styles/Courses.css";

function Courses() {
  return (
    <section className="cursos">
      <h1 className="titulo-carreira">Trilhas de Carreira</h1>
      <section className="catalogo-carreira">
        <Career title="Cientista de Dados" lessons={95} language={"python"} imageurl={"https://media.istockphoto.com/id/1364317541/photo/data-scientists-hand-of-programmer-touching-and-analyzing-development-at-various-information.webp?b=1&s=170667a&w=0&k=20&c=6Tfu775xvgW8XbfT45IJSsniRJfzGi3_UxeB7Yz5tAY="}/>
        <Career title="Cientista de Dados" lessons={95} language={"python"} imageurl={"https://media.istockphoto.com/id/1364317541/photo/data-scientists-hand-of-programmer-touching-and-analyzing-development-at-various-information.webp?b=1&s=170667a&w=0&k=20&c=6Tfu775xvgW8XbfT45IJSsniRJfzGi3_UxeB7Yz5tAY="}/>
        <Career title="Cientista de Dados" lessons={95} language={"python"} imageurl={"https://media.istockphoto.com/id/1364317541/photo/data-scientists-hand-of-programmer-touching-and-analyzing-development-at-various-information.webp?b=1&s=170667a&w=0&k=20&c=6Tfu775xvgW8XbfT45IJSsniRJfzGi3_UxeB7Yz5tAY="}/>
        <Career title="Cientista de Dados" lessons={95} language={"python"} imageurl={"https://media.istockphoto.com/id/1364317541/photo/data-scientists-hand-of-programmer-touching-and-analyzing-development-at-various-information.webp?b=1&s=170667a&w=0&k=20&c=6Tfu775xvgW8XbfT45IJSsniRJfzGi3_UxeB7Yz5tAY="}/>
        <Career title="Cientista de Dados" lessons={95} language={"python"} imageurl={"https://media.istockphoto.com/id/1364317541/photo/data-scientists-hand-of-programmer-touching-and-analyzing-development-at-various-information.webp?b=1&s=170667a&w=0&k=20&c=6Tfu775xvgW8XbfT45IJSsniRJfzGi3_UxeB7Yz5tAY="}/>
      </section>
      <hr></hr>
      <h1 className="titulo-catalogo">Cursos</h1>
      <section className="catalogo-cursos">
        <Career title="Python" lessons={95} language={"python"} imageurl={"https://assets.stickpng.com/images/5848152fcef1014c0b5e4967.png"}/>
      </section>
    </section>
  );
}

export default Courses;
