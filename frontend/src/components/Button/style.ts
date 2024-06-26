import styled from "styled-components";
import { shade } from "polished";

export const Container = styled.button`
  background: #BB86FC;
  border-radius: 10px;
  height: 56px;
  border: 0;
  padding: 16px;
  width: 100%;
  font-weight: 500;
  color: #312e38;
  margin-top: 16px;
  transition: background-color 0.2s;
  font-family: 'Roboto', sans-serif;

  &:hover{
    background: ${shade(0.2, '#BB86FC')};
  }
}`;