import styled from "styled-components";

export const Container = styled.div`
  position: relative;

  span {
    width: 160px;
    background: #BB86FC;
    padding: 8px;
    border-radius: 4px;
    font-size: 14px;
    font-weight: 500;

    position: absolute;
    bottom: calc(100% + 12px);
    left: 50%;
    transform: translateX(-50%);

    opacity: 0;
    visibility: hidden;
    transition: opacity 0.4s;

    color: #312E38;

    &::before {
    content: '';
    border-style: solid;
    border-color: #BB86FC transparent;
    border-width: 6px 6px 0 6px;
    top: 100%;
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    }
  }

  &:hover span {
    opacity: 1;
    visibility: visible;
  }

`;