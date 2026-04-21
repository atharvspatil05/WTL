import { useParams } from "react-router-dom";
import { events } from "../data/events";

function EventDetails() {
  const { id } = useParams();
  const event = events.find((e) => e.id === Number(id));

  if (!event) return <p className="p-8 text-red-500">Event not found!</p>;

  return (
    <div className="p-10 max-w-3xl mx-auto bg-white shadow-lg rounded-xl mt-10">
      <h2 className="text-3xl font-bold text-gray-800 mb-4">{event.name}</h2>
      <p className="text-gray-600 mb-2"><strong>Date:</strong> {event.date}</p>
      <p className="text-gray-600 mb-2"><strong>Club:</strong> {event.club}</p>
      <p className="text-gray-700 mt-4">{event.description}</p>

      <button
        onClick={() => alert("Registered Successfully!")}
        className="mt-6 w-full bg-green-500 text-white py-2 rounded hover:bg-green-600 transition"
      >
        Register for Event
      </button>
    </div>
  );
}

export default EventDetails;