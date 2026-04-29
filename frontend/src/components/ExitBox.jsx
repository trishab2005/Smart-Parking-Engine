import { useState } from "react";
import API from "../api/api";

export default function ExitBox() {
  const [recordId, setRecordId] = useState("");

  const handleExit = async () => {
    try {
      const res = await API.post("/parking/exit", {
        recordId: Number(recordId),
      });

      alert("Exited 🚪 Fee: ₹" + res.data.fee);
    } catch (e) {
      alert(e.response?.data?.message || "Error");
    }
  };

  return (
    <div className="bg-white/10 backdrop-blur-lg p-6 rounded-xl shadow">
      <h2 className="mb-3">Exit Vehicle</h2>

      <input
        placeholder="Record ID"
        className="w-full p-2 mb-2 text-black"
        onChange={(e) => setRecordId(e.target.value)}
      />

      <button
        onClick={handleExit}
        className="bg-red-500 px-4 py-2 rounded"
      >
        Exit 🚪
      </button>
    </div>
  );
}