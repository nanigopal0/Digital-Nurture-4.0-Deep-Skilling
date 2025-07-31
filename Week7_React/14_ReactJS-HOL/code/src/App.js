import "./App.css";
import EvenPlayers from "./EvenPlayers";
import ListOfIndianPlayers from "./ListofIndianPlayers";
import ListofPlayers from "./ListofPlayers";
import OddPlayers from "./OddPlayers";
import ScoreBelow70 from "./ScoreBelow70";

function App() {
  const players = [
    { name: "Sachin Tendulkar", score: 100 },
    { name: "Sourav Ganguly", score: 90 },
    { name: "Virat Kohli", score: 120 },
    { name: "MS Dhoni", score: 110 },
    { name: "Rohit Sharma", score: 130 },
    { name: "Yuvraj Singh", score: 70 },
    { name: "Rahul Dravid", score: 80 },
    { name: "Virender Sehwag", score: 95 },
    { name: "Jack", score: 50 },
    { name: "Hardik Pandya", score: 75 },
    { name: "Micheal", score: 70 },
  ];

  const T20Players = ["Sachin Tendulkar", "Virat Kohli", "MS Dhoni"];

  const RanjiTrophyPlayers = ["Rohit Sharma", "Yuvraj Singh", "Raina"];
  const mergedIndianTeam = [...T20Players, ...RanjiTrophyPlayers];

  var flag = false;
  if (flag) {
    return (
      <div style={{ margin: "20px" }}>
        <h1>List of Players</h1>
        <ListofPlayers players={players} />
        <h1>List of Players having Score Less Than 70</h1>
        <ScoreBelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div style={{ margin: "20px" }} >
        <h1>Indian Team</h1>
        <h1>Odd Team</h1>
        {OddPlayers(mergedIndianTeam)}
        <h1>Even Team</h1>
        {EvenPlayers(mergedIndianTeam)}
        <h1>List of Indian Player Merged</h1>
        <ListOfIndianPlayers players={mergedIndianTeam} />
      </div>
    );
  }
}

export default App;
