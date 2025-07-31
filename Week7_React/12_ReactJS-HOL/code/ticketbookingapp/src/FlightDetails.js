import "./style.css";

export default function FlightDetails(props) {
  const bookFlight = (flight) => {
    console.log(flight);
    props.book(flight);
  };

  const isBooked = (id) => {
    return (
      props.bookedFlight.length != 0 &&
      props.bookedFlight.filter((b) => b.id == id).length !== 0
    );
  };

  return (
    <div>
      <h1>Flight Details</h1>
      {props.flightDetails.map((flight) => (
        <div key={flight.id} className="card">
          <h2 style={{ color:"purple"}}>
            {flight.source} -{`>`} {flight.destination}
          </h2>
          <h3 style={{ color: "blue" }}>{flight.name} </h3>
          <h3 style={{ color: "orange" }}>Price: {flight.price}</h3>
          <h4>Date: {flight.date}</h4>
          {isBooked(flight.id) && <h3 style={{ color: "green" }}>Booked</h3>}
          {props.isLogin && !isBooked(flight.id) && (
            <button onClick={() => bookFlight(flight)}>Book</button>
          )}
        </div>
      ))}
    </div>
  );
}
