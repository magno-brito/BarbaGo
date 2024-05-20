import React from "react";
import { Routes, Route } from "react-router-dom"

import { PrivateRoute } from "./Router";

import { SignIn } from "../pages/SingIn";
import { SignUp } from "../pages/SingUp";
import { Dashboard } from "../pages/Dashboard";


export const Routers: React.FC = () => {
  return (
    <Routes>
      <Route path="/" element={
        <PrivateRoute redirectTo="dashboard">
          <SignIn />
        </PrivateRoute>} />

        <Route path="/signup" element={
        <PrivateRoute redirectTo="/">
          <SignUp />
        </PrivateRoute>} />

        <Route path="/dashboard" element={
        <PrivateRoute redirectTo="/">
          <Dashboard />
        </PrivateRoute>} />
    </Routes>
    
  );
};