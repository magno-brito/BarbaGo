import styled, { css } from "styled-components";
import { Tooltip } from "../Tooltip";

interface ContainerProps {
  isFocused: boolean;
  isFilled: boolean;
  isErrored: boolean;
}

export const Container = styled.div<ContainerProps>`
  background: #232129;
  border-radius: 10px;
  padding: 16px;
  width: 100%;

  border: 2px solid #232129;
  color: #666360;
  transition: border 0.4s;
  
  display: flex;
  align-items: center;
  
  ${props => props.isErrored && css`
    border: 2px solid #c53030;
  ` }

  ${props => props.isFocused && css`
    border: 2px solid #BB86FC;
    color: #BB86FC;
  ` }

  ${props => props.isFilled && css`
    color: #BB86FC;
  ` }

  & + div {
    margin-top: 8px;
  }

  input {
    flex: 1;
    background: transparent;
    border: 0;
    color: #F4EDE8;
    font-family: 'Roboto', sans-serif;
  }
  svg{
    margin-right: 16px
  }
`;

export const Error = styled(Tooltip)`

  height: 20px;
  margin-left: 16px;

  svg{
    margin: 0;
  }

  span {
    background: #c53030;
    color: #F4EDE8; 
    &::before{
      border-color: #c53030 transparent;
    }
  }
`;