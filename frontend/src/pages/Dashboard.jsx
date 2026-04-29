import { useEffect, useState } from "react";
import API from "../api/api";

export default function Dashboard() {
  const [stats, setStats] = useState({
    total: 0,
    available: 0,
    occupied: 0,
  });

  useEffect(() => {
    fetchStats();
  }, []);

  const fetchStats = async () => {
    try {
      const res = await API.get("/slots");

      const slots = res.data;

      const total = slots.length;
      const available = slots.filter(s => !s.occupied).length;
      const occupied = slots.filter(s => s.occupied).length;

      setStats({ total, available, occupied });

    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div className="p-10 space-y-8">

      <h1 className="text-3xl font-bold text-white">
        📊 Dashboard Overview
      </h1>

      <div className="grid grid-cols-3 gap-6">

        <div className="bg-white/10 p-6 rounded-xl backdrop-blur-lg">
          <p className="text-gray-300">Total Vehicles</p>
          <h2 className="text-3xl font-bold text-white">{stats.total}</h2>
        </div>

        <div className="bg-white/10 p-6 rounded-xl backdrop-blur-lg">
          <p className="text-gray-300">Available Slots</p>
          <h2 className="text-3xl font-bold text-green-400">
            {stats.available}
          </h2>
        </div>

        <div className="bg-white/10 p-6 rounded-xl backdrop-blur-lg">
          <p className="text-gray-300">Occupied Slots</p>
          <h2 className="text-3xl font-bold text-red-400">
            {stats.occupied}
          </h2>
        </div>

      </div>

    </div>
  );
}