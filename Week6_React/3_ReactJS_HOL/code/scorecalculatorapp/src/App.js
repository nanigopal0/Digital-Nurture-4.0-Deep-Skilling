import logo from './logo.svg';
import './App.css';
import { CalculateScore } from './components/CalculateScore';

function App() {
  return (
    <div className="App">
    
       <CalculateScore name={"Steeve"} school={"DNV Public School"}
       total={284} goal={3}/>
\
    </div>
  );
}

export default App;
