import "./App.css";
import DisplayOfficeSpace from "./DisplayOfficeSpace";
import  './style.css';

function App() {
  const el = "Office space";
  return (
    <div className="centerdiv">
      <h1>{el}, at affordable range</h1>
      <DisplayOfficeSpace/>
    </div>
  );
}

export default App;
