import "./App.css";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import Home from "./Home";
import TrainerList from "./Traninerlist";
import TrainerDetail from "./TrainerDetails";

function App() {
  return (
 
      <BrowserRouter>
      <h1>My Academy Trainers App</h1>
      <div style={{ display: "flex", alignItems: "center", gap: "5px" }}>
        <Link to={"/"}>Home</Link>
        <p> | </p>
        <Link to={"/trainers"}>Show Trainers</Link>
      </div>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainerList />} />
          <Route path="/trainers/:id" element={<TrainerDetail/>} />
        </Routes>
      </BrowserRouter>

  );
}

export default App;
