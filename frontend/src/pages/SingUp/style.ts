import styled, { css, keyframes } from "styled-components";
import { shade } from 'polished';

import SignUpBackground from '../../assets/sign-up-background.jpg';

interface TypeButtonProps {
  selected: boolean;
}

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

const appearFromRight = keyframes`
  from{
    opacity: 0;
    transform: translateX(50px);
  }
  to{
    opacity: 1;
    transform: translateX(0);
  }
`;

export const AnimationContainer = styled.div`
  display: flex;
  flex-direction: column;

  justify-content: center;
  align-items: center;

  animation: ${appearFromRight} 1s;

   form {
    margin: 80px 0;
    width: 340px;
    text-align: center;

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
  background: url(${SignUpBackground}) no-repeat center;
  background-size: cover;
`; 

export const TypeButton = styled.button<TypeButtonProps>`
  padding: 6px 4px;
  margin-right: 20px;
  background: transparent; 
  color: #333;  
  cursor: pointer;
  border: none; 
  border-bottom: 3px solid transparent;

  transition: all 0.3s ease;  
  font-family: 'Roboto', sans-serif;
  font-size: 16px;

  &:focus {
    outline: none;  
  }

  ${props => props.selected && css`
    color: #F4EDE8;  
    border-bottom: 3px solid #BB86FC; 
  `} 
`;

export const LogoContainer = styled.div`
  width: 250px;
  margin-top:25%;
  margin-bottom:80px;
  margin-left:40px;
  background-color: white;
  
`; 

export const Hr = styled.div`
  border: none;
  height: 2px;
  background-color: #BB86FC;
`; 

