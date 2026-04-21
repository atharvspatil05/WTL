import { Link } from "react-router-dom";

function EventCard({ event }) {
  return (
    <div style={{ border: "1px solid gray", padding: "10px", margin: "10px" }}>
      <h3>{event.name}</h3>
      <p>Date: {event.date}</p>
      <p>Club: {event.club}</p>

      <Link to={`/events/${event.id}`}>
        <button>View Details</button>
      </Link>
    </div>
  );
}

export default EventCard;