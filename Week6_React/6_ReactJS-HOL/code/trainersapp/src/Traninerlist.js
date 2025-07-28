import { Link } from "react-router-dom";
import trainersMock from "./TrainersMock";

export default function TrainerList() {
  return (
    <div>
      <h3>Trainers list</h3>
      <div style={{ marginLeft: "20px" }}>
        {trainersMock.map((trainer) => (
          <li key={trainer.trainerId}>
            <Link to={`/trainers/${trainer.trainerId}`}>{trainer.name}</Link>
          </li>
        ))}
      </div>
    </div>
  );
}
