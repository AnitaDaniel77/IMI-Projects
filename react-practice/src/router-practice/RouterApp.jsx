// React Router practice — kept separate from main App.jsx notes
// import Routes, Route and Link from react-router-dom
import { Routes, Route, Link } from "react-router-dom";
import Homepage from "./Homepage.jsx";
import AboutMe from "./AboutMe.jsx";

function RouterApp() {
  return (
    <div>
      {/* nav stays outside Routes so it shows on every page */}
      <nav>
        {/* Link replaces anchor tags so the page does not reload */}
        <Link to="/" className="nav-item">Home</Link>
        <Link to="/about-me" className="nav-item">About Me</Link>
      </nav>

      {/* Routes groups all routes together */}
      <Routes>
        {/* root route shows Homepage */}
        <Route path="/" element={<Homepage />} />
        {/* /about-me route shows AboutMe */}
        <Route path="/about-me" element={<AboutMe />} />
      </Routes>
    </div>
  );
}

export default RouterApp;