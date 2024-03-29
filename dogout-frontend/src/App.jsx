import React, { createContext, useState } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import PageNotFound from "./views/PageNotFound";
import Navigator from "./views/Navigator";
import Login from "./views/Login"
import SignUp from "./views/SignUp";
import Home from "./views/Home";
import Places from "./views/Places";
import MyDoggy from "./views/MyDoggy";
import Settings from "./views/Settings";
import GuestRoutes from "./components/route-settings/GuestRoutes";
import UserRoutes from "./components/route-settings/UserRoutes";

import "./App.css"
import Place from "./views/Place";

export const WarningContext = createContext(null);
export const InformationContext = createContext(null);

function App() {

  const [warning, setWarning] = useState(false);
  const [warningId, setWarningId] = useState(1);

  const [information, setInformation] = useState(false);
  const [informationId, setInformationId] = useState(1);

  return (
    <Router>
      <div className="App">
        <WarningContext.Provider value={{ warning: warning, setWarning: setWarning, warningId: warningId, setWarningId: setWarningId }}>
          <InformationContext.Provider value={{ information: information, setInformation: setInformation, informationId: informationId, setInformationId: setInformationId }}>
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
                <Route path="/places" element={<Places />} />
                <Route path="/my-doggy" element={<MyDoggy />} />
                <Route path="/settings" element={<Settings />} />
                <Route path="/place/:id" element={<Place />} />
              </Route>
            </Routes>
          </InformationContext.Provider>
        </WarningContext.Provider>
      </div>
    </Router>
  );
}

export default App;
