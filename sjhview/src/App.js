import './App.css';
import React from "react";
import LoginMove from "./LoginMove";
import {createGlobalStyle} from "styled-components";
import {Route, Routes} from "react-router-dom";
import HeaderComponent from "./HeaderComponent";
import FooterComponent from "./FooterComponent";
import BoardList from "./board/BoardList";
import BoardCreate from "./board/BoardCreate";
import Error from "./error";
import BoardRead from "./board/BoardRead";
import BoardUpdate from "./board/BoardUpdate";
import ChatRoom from "./Chat/ChatRoom";

// 배경색
const GlobalStyle = createGlobalStyle`
  body {
    background: #e9ecef;
  }
`;

// Router로 실질적 주소값에 따른 Component 호출
function App() {

  return (
    <div className="App">
        <GlobalStyle/>
        <HeaderComponent/>
        <Routes>
            <Route path="/" element={<BoardList />} />
            <Route path="/Login" element={<LoginMove />} />
            <Route path={"/board"} element={<BoardList />}/>
            <Route path={"/create-board/:no"} element={<BoardUpdate />}/>
            <Route path={"/create-board"} element={<BoardCreate />}/>
            <Route path={'/board/:no'} element={<BoardRead />}/>
            <Route path={"/chat"} element={<ChatRoom/>}/>
            <Route path={'*'} element={<Error/>}/>
        </Routes>
        <FooterComponent/>
    </div>
  );
}

export default App;
