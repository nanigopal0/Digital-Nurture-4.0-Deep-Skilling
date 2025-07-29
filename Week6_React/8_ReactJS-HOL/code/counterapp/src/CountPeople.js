import React from "react";
import "./style.css";

export default class CountPeople extends React.Component {
  constructor() {
    super();
    this.state = {
      entryCount: 0,
      exitCount: 0,
      c: 0,
    };
  }

  updateEntry() {
    this.setState((prev, props) => {
      return { entryCount: prev.entryCount + 1 };
    });
  }
  updateExit() {
    this.setState((prev, props) => {
      return { exitCount: prev.exitCount + 1 };
    });
  }
  render() {
    return (
      <div className="outerdiv">
        <div className="innerdiv">
          <button onClick={() => this.updateEntry()}>Login</button>
          <p>{this.state.entryCount} People Entered!!</p>
        </div>
        <div className="innerdiv">
          <button onClick={() => this.updateExit()}>Exit</button>
          <p>{this.state.exitCount} People Left!!</p>
        </div>
      </div>
    );
  }
}
