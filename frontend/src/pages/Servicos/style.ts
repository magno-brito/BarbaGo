import styled, { keyframes } from "styled-components";
import { shade } from 'polished';

import SignInBackground from '../../assets/sign-in-background.jpg';
import LogoBackGround from '../../assets/logo.svg';


export const Container = styled.div`
  height: 100vh;
  display: flex;
  align-items: stretch;
`;


export const Content = styled.div`
  display: flex;
  flex-direction: column;

  justify-content: center;
  align-items: center;

  width: 100%;
  max-width: 700px;

`;

const appearFromLeft = keyframes`
  from{
    opacity: 0;
    transform: translateX(-50px);
  }
  to{
    opacity: 1;
    transform: translateX(0);
  }
`;


export const AnimationContainer = styled.div`
  display: flex;
  flex-direction: column;

  justify-content: left;
  align-items: left;

  animation: ${appearFromLeft} 1s;

   form {
    margin: 80px 0;
    width: 340px;
    text-align: left;

    h1 {
      margin-bottom: 24px;
    }

    a{
      color: #F4EDE8;
      display: block;
      text-decoration: none;
      margin-top: 24px;
      transition: color 0.2s;
      
      &:hover {
        color: ${shade(0.4, '#F4EDE8')};
      }
    }
  }

  > a {
    color: #BB86FC;
    display: block;
    text-decoration: none;
    margin-top: 24px;
    transition: color 0.2s;

    display: flex;
    align-items: center;
      
    &:hover {
      color: ${shade(0.4, '#BB86FC')};
    }

    svg{
      margin: 1px 14px 0 0;
    }
  }
`;

export const Background = styled.div`
  flex: 1;
  background: url(${SignInBackground}) no-repeat center;
  background-size: cover;
`; 

export const LogoContainer = styled.div`
  width: 200px;
  margin-top:40px;
  margin-bottom:40px;
  background-color: white;
`; 

export const Hr = styled.div`
  border: none;
  height: 2px;
  background-color: #BB86FC;
`; 
