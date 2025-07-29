

export default function ScoreBelow70(props) {
  function filterPlayersScoreBelow70() {
    return props.players.filter((player) => player.score <= 70);
  }

  return (
    <div>
      {filterPlayersScoreBelow70().map((player, index) => {
        return (
          <div key={index}>
            <li>
              Mr. {player.name}
              <span>{player.score}</span>
            </li>
          </div>
        );
      })}
    </div>
  );
}
