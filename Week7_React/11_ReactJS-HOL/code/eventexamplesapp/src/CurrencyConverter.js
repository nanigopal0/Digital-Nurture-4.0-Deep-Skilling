import { useState } from "react";

export default function CurrencyConverter() {
  const [amount, setAmount] = useState(0);
  const euro = 100.67;
  const handleSubmit = () => {
    alert("Converting to Euro amount is: " + amount * euro);
  };

  return (
    <div>
      <h1 style={{color:"green"}}>Currency Converter!!!</h1>
      <label>Amount</label>
      <input
        type="number"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
      />
      <label>Currency</label>
      <input type="text" defaultValue={"Euro"} />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}
