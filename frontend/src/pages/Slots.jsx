import { useEffect, useState } from "react";
import API from "../api/api";

export default function Slots() {
  const [slots, setSlots] = useState([]);

  useEffect(() => {
    API.get("/slots")
      .then(res => setSlots(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div className="p-10 space-y-6">

      <h1 className="text-3xl font-bold text-white">
        🅿️ Slot Status
      </h1>

      <div className="grid grid-cols-5 gap-6">

        {slots.length === 0 ? (
          <p className="text-white text-xl">No slots found</p>
        ) : (
          slots.map((s) => (
            <div
              key={s.id}
              className={`p-4 rounded-xl text-center ${
                s.occupied
                  ? "bg-red-500/30"
                  : "bg-green-500/30"
              }`}
            >
              <p className="font-bold">Slot #{s.id}</p>
              <p>{s.vehicleType}</p>
              <p>
                {s.occupied ? "Occupied ❌" : "Available ✅"}
              </p>
            </div>
          ))
        )}

      </div>

    </div>
  );
}