import React from "react";
import { Routes, Route } from "react-router-dom"

import { PrivateRoute } from "./Router";

import { SignIn } from "../pages/SingIn";


export const Routers: React.FC = () => {
  return (
    <Routes>
      <Route path="/" element={
        <PrivateRoute redirectTo="dashboard">
          <SignIn />
        </PrivateRoute>} />
    </Routes>
  );
};