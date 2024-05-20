import React from "react";
import { Routes, Route } from "react-router-dom"

import { PrivateRoute } from "./Router";

import { SignIn } from "../pages/SingIn";
import { SignUp } from "../pages/SingUp";
<<<<<<< HEAD
import { Dashboard } from "../pages/Dashboard";
=======
import { DashBoard } from "../pages/Dashboard";
>>>>>>> b232e55efd9046f02b83460e303f1cb2f3e26f44


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
<<<<<<< HEAD
          <Dashboard />
=======
          <DashBoard />
>>>>>>> b232e55efd9046f02b83460e303f1cb2f3e26f44
        </PrivateRoute>} />
    </Routes>
    
  );
};