import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <div className="flex justify-between items-center px-6 py-4 bg-black/50 backdrop-blur-lg shadow">
      <h1 className="text-xl font-bold text-blue-400">
        🚗 Smart Parking
      </h1>

      <div className="space-x-6 text-white">
        <Link to="/">Dashboard</Link>
        <Link to="/park">Park</Link>
        <Link to="/exit">Exit</Link>
        <Link to="/slots">Slots</Link>
      </div>
    </div>
  );
}