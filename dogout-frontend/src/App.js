import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import PageNotFound from "./views/PageNotFound";
import Navigator from "./views/Navigator";
import Login from "./views/Login"
import SignUp from "./views/SignUp";
import Home from "./views/Home";
import GuestRoutes from "./components/route-settings/GuestRoutes";
import UserRoutes from "./components/route-settings/UserRoutes";

import "./App.css"

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          {/* Wrong paths */}
          <Route path="*" element={<PageNotFound />} />

          {/* Guest paths */}
          <Route element={<GuestRoutes />}>
            <Route path="/" element={<Navigator />} />
            <Route path="/signup" element={<SignUp />} />
            <Route path="/login" element={<Login />} />
          </Route>

          {/* User paths */}
          <Route element={<UserRoutes />}>
            <Route path="/home" element={<Home />} />
            <Route path="/places" element="places" />
            <Route path="/my-doggy" element="my-doggy" />
            <Route path="/settings" element="settings" />
            <Route path="/place/:id" element="place:id" />
          </Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
