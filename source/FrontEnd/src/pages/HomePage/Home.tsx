import Navbar from "../Navbar";
import Courses from "./components/Courses/Courses";
import Hero from "./components/Hero/Hero";

function Home(){
    return <div className="home-page">
        <Navbar />
        <Hero />
        <Courses />
    </div>
}

export default Home;