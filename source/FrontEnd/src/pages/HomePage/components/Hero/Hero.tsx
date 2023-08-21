import "./styles/Hero.css";
import learnCode from "../../../assets/learn_code.png";

function Hero() {
  return (
    <section className="hero">
      <article className="presentation">
        <h1>Boas Vindas a Codi.Go</h1>
        <h3>{"< Seu aprendizado começa aqui >"}</h3>
        <p>
          Plataforma de ensino que fornece material para o aprendizado e
          exercícios hands-on com correção em tempo real, sem a necessidade de
          configurar o computador previamente.
        </p>
      </article>
      <div className="learn-code-presentation">
      <img src={learnCode} className="learn-code"/>
      </div>

    </section>
  );
}

export default Hero;
