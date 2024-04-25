import React, { ReactNode } from "react";
import { Container } from "./style";

interface ITooltipProps {
  children?: ReactNode;
  title: string;
  className?: string;
}

const Tooltip: React.FC<ITooltipProps> = ({
  title,
  children,
  className = ''
}) => {
  return (
    <Container className={className}>
      {children}
      <span>{title}</span>
    </Container>
  )
}

export { Tooltip };