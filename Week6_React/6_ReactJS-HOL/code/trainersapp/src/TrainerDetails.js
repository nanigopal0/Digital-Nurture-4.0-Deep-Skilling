import { useParams } from "react-router-dom";
import trainersMock from "./TrainersMock";
import { useEffect, useState } from "react";

export default function TrainerDetail() {
  const param = useParams();
  const [trainer, setTrainer] = useState({});

  useEffect(() => {
    getTrainerData();
  }, [param.id]);
  const getTrainerData = () => {
    setTrainer(
      trainersMock.filter((trainer) => trainer.trainerId === param.id).at(0)
    );
  };
  return (
    <div>
      <h1>Trainer Details</h1>
      <div>
        <h3>
          {trainer.name} ({trainer.technology})
        </h3>

        <p>{trainer.email}</p>
        <p>{trainer.phone}</p>
        <div style={{ marginLeft: "20px" }}>
          {trainer.skills &&
            trainer.skills.map((skill, index) => <li key={index}>{skill}</li>)}
        </div>
      </div>
    </div>
  );
}
