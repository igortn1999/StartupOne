import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './pages/HomePage/Home';

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}>
        <Route path="lesson" element={<App />}></Route>  
        </Route>
      </Routes>
    </BrowserRouter>
)
