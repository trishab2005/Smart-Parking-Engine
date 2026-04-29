import { useState } from "react";
import API from "../api/api";

export default function ParkBox() {
  const [vehicleNumber, setVehicleNumber] = useState("");
  const [vehicleType, setVehicleType] = useState("CAR");

  const handlePark = async () => {
    try {
      const res = await API.post("/parking/park", {
        vehicleNumber,
        vehicleType,
      });

      alert("Parked ✅ Slot ID: " + res.data.slotId);
    } catch (e) {
      alert(e.response?.data?.message || "Error");
    }
  };

  return (
    <div className="bg-white/10 backdrop-blur-lg p-6 rounded-xl shadow">
      <h2 className="mb-3">Park Vehicle</h2>

      <input
        placeholder="Vehicle Number"
        className="w-full p-2 mb-2 text-black"
        onChange={(e) => setVehicleNumber(e.target.value)}
      />

      <select
        className="w-full p-2 mb-2 text-black"
        onChange={(e) => setVehicleType(e.target.value)}
      >
        <option>CAR</option>
        <option>BIKE</option>
      </select>

      <button
        onClick={handlePark}
        className="bg-blue-500 px-4 py-2 rounded"
      >
        Park 🚗
      </button>
    </div>
  );
}