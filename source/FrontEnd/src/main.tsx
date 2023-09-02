import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './pages/HomePage/Home';
import CourseDetails from './pages/CourseDetails/courseDetails';

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/lesson" element={<App />}></Route>  
        <Route path="/course/:id" element={<CourseDetails />}></Route>

      </Routes>
    </BrowserRouter>
)
