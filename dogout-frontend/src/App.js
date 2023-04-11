import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import PageNotFound from "./components/PageNotFound";
import Navigator from "./components/main-pages/Navigator";
import Login from "./components/main-pages/Login"
import "./css/App.css"
import SignUp from "./components/main-pages/SignUp";

function App() {
  return (
    <Router>
      <div className="App">
      <Routes>
        {/* Wrong paths */}
        <Route path="*" element={<PageNotFound />} />

        {/* Guest paths */}
        <Route path="/" element={<Navigator />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/login" element={<Login />} />

        {/* User paths */}
        <Route path="/home" element="home" />
        <Route path="/places" element="places" />
        <Route path="/my-doggy" element="my-doggy" />
        <Route path="/settings" element="settings" />
        <Route path="/place/:id" element="place:id" />

      </Routes>
      </div>
    </Router>
  );
}

export default App;
