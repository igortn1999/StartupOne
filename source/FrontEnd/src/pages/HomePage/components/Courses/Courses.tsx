import { useEffect, useState } from "react";
import Career from "./Career/CareerCard";
import "./styles/Courses.css";
import API_URL from "../../../../config";

function Courses() {

  const [courses,setCourses] = useState([{"id":1,"name":"Python","description":"Learn python today!","estimateHours":50.0,"overviewUrl":"DXmCU7v9glM","image":"","markers":[]}]);
  useEffect(()=>{
    fetch(`${API_URL}/api/courses`)
    .then(res => res.json())
    .then(data => {
     // enter you logic when the fetch is successful
      console.log(data)
      setCourses(data);
    })
    .catch(error => {
      // enter your logic for when there is an error (ex. error toast)
     console.log(error)
    })
  },[])
  console.log(API_URL);

  return (
    <section className="cursos" id="catalogo">
      <h1 className="titulo-carreira">Trilhas de Carreira</h1>
      <section className="catalogo-carreira">
        <Career title="Cientista de Dados" lessons={95} demoMode={"blocked"} language={"Python"} imageurl={"https://media.istockphoto.com/id/1364317541/photo/data-scientists-hand-of-programmer-touching-and-analyzing-development-at-various-information.webp?b=1&s=170667a&w=0&k=20&c=6Tfu775xvgW8XbfT45IJSsniRJfzGi3_UxeB7Yz5tAY="}/>
        <Career title="Dev Full Stack" demoMode={"blocked"} lessons={180} language={"HTML,CSS,JS"} imageurl={"https://kinsta.com/pt/wp-content/uploads/sites/3/2021/12/what-is-a-full-stack-developer-1024x512.png"}/>
        <Career title="Dev Front-End" demoMode={"blocked"} lessons={54} language={"HTML,CSS,JS"} imageurl={"https://kinsta.com/pt/wp-content/uploads/sites/3/2021/12/front-end-developer-1024x512.png"}/>
        <Career title="Dev Back-End" demoMode={"blocked"} lessons={126} language={"Python"} imageurl={"https://assets.bitdegree.org/online-learning-platforms/storage/media/2018/08/what-is-a-web-developer.jpg"}/>
      </section>
      <hr></hr>
      <h1 className="titulo-catalogo">Cursos</h1>
      <section className="catalogo-cursos">
      {
        courses?courses.map((course)=><Career title={course.name} lessons={course.estimateHours} imageurl={"https://th.bing.com/th/id/OIP.nUYOwBlsmc2xTLmGRzBTCQHaHa?pid=ImgDet&rs=1"} id={course.id}/>):<Career title="Python" lessons={10} imageurl={"https://th.bing.com/th/id/OIP.nUYOwBlsmc2xTLmGRzBTCQHaHa?pid=ImgDet&rs=1"} id="1"/>
      }
        <Career title="Análise de dados" demoMode={"blocked"} lessons={10} imageurl={"https://static.vecteezy.com/system/resources/thumbnails/004/578/623/small_2x/analyze-text-data-free-vector.jpg"}/>
        <Career title="Machine Learning" demoMode={"blocked"} lessons={10} imageurl={"https://i.pinimg.com/736x/a1/bf/26/a1bf26ed5b91a1fa9bbd8b79baeabdbc--color-psychology-serenity.jpg"}/>
        <Career title="Java" demoMode={"blocked"} lessons={20} imageurl={"https://th.bing.com/th/id/R.c2656bd56d27b85fccfceb307298f28e?rik=vfgjAHxsh7UiSA&riu=http%3a%2f%2fimage.digitalinsightresearch.in%2fuploads%2fimagelibrary%2fcbr%2fjava.jpg&ehk=vn97rntDxEtOc3Cbaz4ljrRGWJJhTekLa6AxVl8q%2bDU%3d&risl=&pid=ImgRaw&r=0"}/>
      </section>
    </section>
  );
}

export default Courses;
