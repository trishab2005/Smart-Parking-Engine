import { useState } from "react";
import API from "../api/api";

export default function Exit() {
  const [id, setId] = useState("");

  const handleExit = async () => {
  try {
    const res = await API.post("/parking/exit", {
      recordId: Number(id), // ✅ FIXED
    });

    alert(`Exited 🚪\nFee: ₹${res.data.fee}`);
    console.log(res.data);

  } catch (err) {
    console.log("ERROR 👉", err.response?.data);
    alert(err.response?.data || "Exit failed");
  }
};

  return (
    <div className="p-10 space-y-6">

      <h1 className="text-3xl font-bold text-white">
        🚪 Exit Vehicle
      </h1>

      <div className="bg-white/10 p-6 rounded-xl w-[400px]">

        <input
          placeholder="Record ID"
          className="p-2 mb-3 w-full text-black"
          onChange={(e) => setId(e.target.value)}
        />

        <button
          onClick={handleExit}
          className="bg-red-500 px-4 py-2 rounded"
        >
          Exit 🚪
        </button>

      </div>

    </div>
  );
}