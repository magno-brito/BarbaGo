import React from "react";
import { Routes, Route } from "react-router-dom"

import { PrivateRoute } from "./Router";

import { SignIn } from "../pages/SingIn";
import { SignUp } from "../pages/SingUp";
import { Dashboard } from "../pages/DashboardBarbeiro";
import { DashboardUsuario } from "../pages/DashboardUsuario";
import { Servicos } from "../pages/Servicos";



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

        <Route path="/dashboard/barbeiro" element={
        <PrivateRoute redirectTo="/">
          <Dashboard />
        </PrivateRoute>} />

        <Route path="/dashboard/usuario" element={
        <PrivateRoute redirectTo="/">
          <DashboardUsuario />
        </PrivateRoute>} />

        <Route path="/servicos" element={
        <PrivateRoute redirectTo="/">
          <Servicos />
        </PrivateRoute>} />

    </Routes>
    
  );
};