import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import StudyArea from "./pages/StudyArea/StudyArea";
import { useParams } from "react-router-dom";
function App(props: any) {
  const [count, setCount] = useState(0);
  const { id } = useParams();

  if (id == '1') {
    var title = "Introdução ao Python";
    var embedIdLesson = "BW9Va5syNC0";
    var lessonContent = `
  <h1>Variáveis e Tipos de Dados</h1>
  <h2>Visão geral</h2>
  <p>Na programação, as variáveis são usadas para armazenar valores que podem ser manipulados e acessados durante a execução do programa. Em Python, a declaração de uma variável é feita atribuindo um valor a ela. \n 
  Por exemplo
  </p>
  <code>nome = "João" <br></br>
  idade = <span class="orange">25</span> <br></br>
  altura = <span class="blue">1.75</span></code>
  <p>Em Python, existem diferentes tipos de dados que podem ser atribuídos às variáveis. Alguns dos tipos de dados básicos são:</p>
  <h2>Inteiros</h2>
  <p>representa números inteiros, como 1, 10, -5, etc. <br></br>
  Exemplo</p>
  <code>idade = <span class="orange">25</span></code>
  <h2>Número de ponto flutuante</h2>
  <p>representa números com casas decimais, como 3.14, 2.5, etc. 
<br></br>
  Exemplo</p>
  <code>altura = <span class="blue">1.75</span></code>
  
  <h2>Hands On</h2>
  `;

    var tasks = [
      "Crie uma variável com a sua idade",
      "Crie uma variável com seu nome",
    ];

    var handsOnIntro = `Agora que você 
  já aprendeu alguns
  dos tipos básicos
  de dados do Python
  faça o seguinte:`;

    var code = `#Escreva seu codigo abaixo\nmessage = "Hello World!" \n\nprint(message)`;
  } else {
    var embedIdLesson = "wgGu8ph3m6A";
    var title = "Listas em Python";
    var lessonContent = `
    <h1>Listas em Python</h1>

    <h2>O que são listas?</h2>
    <p>Uma lista é uma estrutura de dados que permite armazenar um conjunto ordenado de elementos. Em Python, as listas são flexíveis e podem conter elementos de diferentes tipos, como números inteiros, números de ponto flutuante, strings e até outras listas. Listas são uma das estruturas de dados mais usadas em Python devido à sua versatilidade.</p>

    <h2>Acessando Elementos da Lista</h2>
    <p>Para acessar elementos de uma lista, use colchetes '[]' com o índice do elemento desejado. Lembre-se de que os índices em Python começam em 0. Por exemplo:</p>
    <code>primeira_fruta = frutas[<span class="blue">0</span>]  # A primeira fruta é "maçã"<br>
    segunda_fruta = frutas[<span class="blue">1</span>]   # A segunda fruta é "banana"</code>

    <h2>Alterando Elementos da Lista</h2>
    <p>Você pode alterar o valor de um elemento em uma lista atribuindo um novo valor ao índice desejado:</p>
    <code>frutas[<span class="blue">2</span>] = "limão"  # Altera a terceira fruta para "limão"</code>

    <h2>Adicionando Elementos à Lista</h2>
    <p>Para adicionar elementos a uma lista, você pode usar o método 'append()' para adicionar um elemento no final da lista:</p>
    <code>frutas.append(<span class="orange">"morango"</span>)  # Adiciona "morango" ao final da lista</code>

    <h2>Removendo Elementos da Lista</h2>
    <p>Para remover elementos de uma lista, você pode usar o método 'pop()' especificando o índice do elemento a ser removido:</p>
    <code>fruta_removida = frutas.pop(<span class="blue">2</span>)  # Remove a terceira fruta ("limão") e a armazena em fruta_removida</code>

    <h2>Tamanho da Lista</h2>
    <p>Você pode obter o tamanho de uma lista usando a função 'len()': </p>
    <code>tamanho = <span class="blue">len(</span>frutas<span class="blue">)</span>  # Retorna o número de elementos na lista</code>

    <h2>Verificando a Existência de um Elemento na Lista</h2>
    <p>Para verificar se um elemento está presente em uma lista, você pode usar o operador 'in':</p>
    <code>if "maçã" in frutas:<br>
        &emsp;print("Maçã está na lista de frutas!")</code>

    <h2>Hands-On</h2>
    `;

    var tasks = ["Crie uma Lista com suas três comidas favoritas"];

    var handsOnIntro = `Agora que você 
    já aprendeu alguns
    dos tipos básicos
    de dados do Python
    faça o seguinte:`;

    var code = `#Escreva seu codigo abaixo\n#Crie uma Lista com suas três comidas favoritas\n`;
  }

  return (
    <div className="App">
      <div>
        <StudyArea
          title={title}
          embedId={embedIdLesson}
          lessonContent={lessonContent}
          tasks={tasks}
          handsOnIntro={handsOnIntro}
          code={code}
        />
      </div>
    </div>
  );
}

export default App;
