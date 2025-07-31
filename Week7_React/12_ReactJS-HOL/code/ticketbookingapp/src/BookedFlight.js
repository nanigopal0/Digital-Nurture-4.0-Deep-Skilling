import './style.css';

export default function BookedFlight(props) {

  if (!props.isLogin) {
    return <div style={{ color: "orange" }}>Login required!</div>;
  }

  return (
    <div>
      <h1>Booked Flight</h1>
      {props.bookedFlight.map((flight) => (
        <div key={flight.id} className='card'>
          <h2>
            {flight.source} -{`>`} {flight.destination}
          </h2>
          <h3 style={{color: "blue"}}>{flight.name}</h3>
          <h3 style={{color: "orange"}}>Price: {flight.price}</h3>
          <h4>Date: {flight.date}</h4>
        </div>
      ))}
    </div>
  );
}
