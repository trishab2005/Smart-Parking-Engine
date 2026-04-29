import { useState } from "react";
import API from "../api/api";

export default function Park() {
  const [vehicleNumber, setVehicleNumber] = useState("");
  const [vehicleType, setVehicleType] = useState("CAR");

  const handlePark = async () => {
    try {
      await API.post("/parking/park", {
        vehicleNumber,
        vehicleType,
      });
      alert("Parked 🚗");
    } catch {
      alert("Error");
    }
  };

  return (
    <div className="p-10 space-y-6">

      <h1 className="text-3xl font-bold text-white">
        🚗 Park Vehicle
      </h1>

      <div className="bg-white/10 p-6 rounded-xl w-[400px]">

        <input
          placeholder="Vehicle Number"
          className="p-2 mb-3 w-full text-black"
          onChange={(e) => setVehicleNumber(e.target.value)}
        />

        <select
          className="p-2 mb-3 w-full text-black"
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

    </div>
  );
}