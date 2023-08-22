import Navbar from "../Navbar";
import Courses from "./components/Courses/Courses";
import Hero from "./components/Hero/Hero";
import Footer from "./components/Footer/Footer";
function Home(){
    return <div className="home-page">
        <Navbar />
        <Hero />
        <Courses />
        <Footer />
    </div>
}

export default Home;