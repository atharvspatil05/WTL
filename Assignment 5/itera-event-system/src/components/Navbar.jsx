import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="bg-gradient-to-r from-blue-600 to-indigo-600 text-white p-4 flex justify-between items-center shadow-lg">
      <h1 className="text-2xl font-bold">ITERA Events</h1>
      <div className="space-x-6 text-lg">
        <Link className="hover:text-yellow-300 transition" to="/">Home</Link>
        <Link className="hover:text-yellow-300 transition" to="/events">Events</Link>
        <Link className="hover:text-yellow-300 transition" to="/clubs">Clubs</Link>
      </div>
    </nav>
  );
}

export default Navbar;