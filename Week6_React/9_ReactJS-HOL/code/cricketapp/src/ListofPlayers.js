import React from "react";

export default class ListofPlayers extends React.Component {
  render() {
    return (
      <div>
        {this.props.players.map((player, index) => {
          return (
            <div>
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
}
