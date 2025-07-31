import "./style.css";

export default function DisplayOfficeSpace() {
  const items = [
    {
      name: "DBS 1",
      rent: 50000,
      address: "Chennai",
      img: "https://images.unsplash.com/photo-1505409859467-3a796fd5798e?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    },
    {
      name: "DBS 2",
      rent: 60000,
      address: "Hyderabad",
      img: "https://images.unsplash.com/photo-1497366811353-6870744d04b2?q=80&w=1169&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    },
    {
      name: "DBS 3",
      rent: 80000,
      address: "Bangalore",
      img: "https://plus.unsplash.com/premium_photo-1661879435429-a396d927c686?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fG9mZmljZSUyMHNwYWNlfGVufDB8fDB8fHww",
    },
    {
      name: "DBS 4",
      rent: 100000,
      address: "Delhi",
      img: "https://images.unsplash.com/photo-1578991624414-276ef23a534f?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fG9mZmljZSUyMHNwYWNlfGVufDB8fDB8fHww",
    },
    {
      name: "DBS 5",
      rent: 40000,
      address: "Kolkata",
      img: "https://images.unsplash.com/photo-1587702068694-a909ef4aa346?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fG9mZmljZSUyMHNwYWNlfGVufDB8fDB8fHww",
    },
  ];

  return (
    <div className="outerdiv">
      {items.map((item, index) => (
        <div key={index} className="listdiv">
          <img src={item.img} alt="office space"  />
          <h2>Name: {item.name}</h2>
          <h3 style={{ color: item.rent <= 60000 ? "red" : "green" }}>
            Rent: Rs. {item.rent}
          </h3>
          <h3>Address: {item.address}</h3>
        </div>
      ))}
    </div>
  );
}
