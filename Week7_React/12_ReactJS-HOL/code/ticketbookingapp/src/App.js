import { useState } from "react";
import "./App.css";
import FlightDetails from "./FlightDetails";
import BookedFlight from "./BookedFlight";
import "./style.css";
import "react-router-dom";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";

function App() {
  const [isLogin, setIsLogin] = useState(false);
  const [bookedFlight, setBookedFlight] = useState([]);

  const flightDetails = [
    {
      id: 1,
      name: "Indigo",
      source: "Delhi",
      destination: "Bangalore",
      price: 30000,
      date: "01-08-2025",
    },
    {
      id: 2,
      name: "Air India",
      source: "Bangalore",
      destination: "London",
      price: 90000,
      date: "05-08-2025",
    },
    {
      id: 3,
      name: "Indigo",
      source: "Delhi",
      destination: "Hyderabad",
      price: 30000,
      date: "02-08-2025",
    },
    {
      id: 4,
      name: "Air India",
      source: "Mumbai",
      destination: "Delhi",
      price: 40000,
      date: "04-08-2025",
    },
    {
      id: 5,
      name: "Indigo",
      source: "Pune",
      destination: "Mumbai",
      price: 40000,
      date: "03-08-2025",
    },
    {
      id: 6,
      name: "Air India",
      source: "Kolkata",
      destination: "Delhi",
      price: 30000,
      date: "01-08-2025",
    },
    {
      id: 7,
      name: "Indigo",
      source: "Delhi",
      destination: "Ayodha",
      price: 30000,
      date: "03-08-2025",
    },
  ];

  const bookFlight = (flight) => {
    setBookedFlight([...bookedFlight, flight]);
  };

  return (
    <BrowserRouter>
      {isLogin ? (
        <div className="head">
          <h1>Welcome back</h1>
          <button
            onClick={() => setIsLogin(false)}
            style={{ backgroundColor: "crimson" }}
          >
            Logout
          </button>
        </div>
      ) : (
        <div className="head">
          <h1>Please Sign up</h1>
          <button
            style={{ backgroundColor: "darkcyan" }}
            onClick={() => setIsLogin(true)}
          >
            Sign up
          </button>
        </div>
      )}

      <div className="tab">
        <Link to="/flight"><li>Flight Details</li></Link>
        {isLogin && <Link to="/book"><li>Booked Flight</li></Link>}
      </div>

      <Routes className="tab">
        <Route
          path="/flight"
          element={
            <FlightDetails
              flightDetails={flightDetails}
              bookedFlight={bookedFlight}
              book={bookFlight}
              isLogin={isLogin}
            />
          }
        />
        <Route
          path="/book"
          element={
            <BookedFlight bookedFlight={bookedFlight} isLogin={isLogin} />
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
