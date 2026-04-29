import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import AnimatedBackground from "./components/AnimatedBackground";

import Dashboard from "./pages/Dashboard";
import Park from "./pages/Park";
import Exit from "./pages/Exit";
import Slots from "./pages/Slots";

function App() {
  return (
    <BrowserRouter>
      <AnimatedBackground />
      <Navbar />

      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/park" element={<Park />} />
        <Route path="/exit" element={<Exit />} />
        <Route path="/slots" element={<Slots />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;