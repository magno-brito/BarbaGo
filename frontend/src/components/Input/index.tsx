import React, { InputHTMLAttributes, useState, useCallback } from "react";
import { IconBaseProps } from 'react-icons';
import { FiAlertCircle } from 'react-icons/fi';
import { UseFormRegister, useFormContext } from 'react-hook-form';

import { Container, Error } from "./style";

interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
  name: string;
  containerStyle?: {};
  icon?: React.ComponentType<IconBaseProps>;
  register: UseFormRegister<any>;
  error?: string;
}

const Input: React.FC<InputProps> = ({ name, containerStyle, icon: Icon, register, error, ...rest }) => {
  const [isFocused, setIsFocused] = useState(false);
  const [isFilled, setIsFilled] = useState(false);

  const handleInputFocus = useCallback(() => {
    setIsFocused(true);
  }, []);

  const handleInputBlur = useCallback((event: React.FocusEvent<HTMLInputElement>) => {
    setIsFocused(false);
    setIsFilled(!!event.target.value);
  }, []);

  return (
    <Container style={containerStyle} isErrored={!!error} isFocused={isFocused} isFilled={isFilled}>
      {Icon && <Icon size={20} />}

      <input
        onFocus={handleInputFocus}
        {...register(name)} 
        {...rest}
        onBlur={handleInputBlur}
      />

      {error &&
        <Error title={error}>
          <FiAlertCircle color="#c53030" size={20} />
        </Error>
      }
    </Container>
  );
};

export { Input };
