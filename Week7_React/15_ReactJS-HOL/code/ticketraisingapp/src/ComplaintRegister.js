import { useState } from "react";
import "./style.css";
function ComplaintRegister() {
  const [name, setName] = useState("");
  const random = () => {
    return "REF" + Math.ceil(Math.random() * 10000000000);
  };

  const handleSubmit = (e) => {
   
    const refId = random();
    alert(
      "Thanks " +
        name +
        "\nYour complaint was submitted\nReference Id is " +
        refId
    );
  };

  return (
    <div>
      <h1>Register your complaint here!!</h1>
      <form>
        <div className="inpdiv">
          <label>Employee Name:</label>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <div className="inpdiv">
          <label>Complaint:</label>
          <textarea></textarea>
        </div>
        <button onClick={handleSubmit}>Submit</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
