export default function ListOfIndianPlayers(props) {
  return (
    <div>
      {props.players.map((player, index) => (
        <li>Mr. {player}</li>
      ))}
    </div>
  );
}
