import { useState } from "react";
import "./App.css";
import CurrencyConverter from "./CurrencyConverter";
import './style.css';

function App() {
  const [counter, setCounter] = useState(0);

  const incrementCounter = () => {
    setCounter((prev) => prev + 1);
  };
  const decrementCounter = () => {
    setCounter((prev) => prev - 1);
  };

  const sayHello = () => {
    alert("Hello Member 1");
  };

  const welcomeMessage = (msg) => {
    alert(msg);
  };

  const clickMessage = () => {
    alert("I was clicked!");
  };

  return (
    <div className="centerdiv">
      {counter}
      <button
        onClick={() => {
          incrementCounter();
          sayHello();
        }}
      >
        Increment
      </button>
      <button onClick={decrementCounter}>Decrement</button>
      <button onClick={() => welcomeMessage("Welcome")}>Say Welcome</button>
      <button onClick={clickMessage}>Click on me</button>
      <CurrencyConverter />
    </div>
  );
}

export default App;
