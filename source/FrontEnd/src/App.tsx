import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import StudyArea from './pages/StudyArea/StudyArea';

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <div>
        <StudyArea />
      </div>
    </div>
  )
}

export default App
