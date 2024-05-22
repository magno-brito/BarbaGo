import React, { useCallback, useRef, useState } from "react";
import { FiArrowLeft, FiMail, FiUser, FiLock } from 'react-icons/fi'
import { Link, useNavigate } from "react-router-dom";

import { Input } from '../../components/Input';
import { Button } from '../../components/Button';

import { Container, Content, AnimationContainer, Background, TypeButton } from "./style";

import api from "../../services/api";
import { useToast } from "../../hooks/toast";

import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as Yup from 'yup';

import LogoBarba from '../../assets/logo.svg';


import { AxiosError } from 'axios';
import { Hr, LogoContainer } from "../SingUp/style";

interface ISignUpFormData {
  name: string;
  email: string;
  password: string;
}

const SignUp: React.FC = () => {
  const { addToast } = useToast();
  const navigate = useNavigate();
  const [userType, setUserType] = useState('usuario');

  const validationSchema = Yup.object().shape({
    name: Yup.string().required('Nome é obrigatória'),
    email: Yup.string().required('E-mail é obrigatório').email('Digite um e-mail válido'),
    password: Yup.string().required('Senha é obrigatória')
  });

  const {
    register,
    handleSubmit,
    formState: { errors }
  } = useForm({
    resolver: yupResolver(validationSchema)
  });

  const onSubmit = async (data: ISignUpFormData) => {
    try {
      await api.post(`/${userType}`, {
        nome: data.name,
        email: data.email,
        senha: data.password
      });
      addToast({
        type: 'success',
        title: 'Cadastro realizado',
        description: 'Você já pode fazer seu login no sistema'
      });
      navigate('/');
    } catch (error) {
      addToast({
        type: 'error',
        title: 'Erro no cadastro',
        description: 'O e-mail já está em uso, por favor tente outro!'
      });
    }
  };

  return (
    <Container>
      <Background />
      <Content>
        <AnimationContainer>
          <form onSubmit={handleSubmit(onSubmit)}>
          <LogoContainer>
            <Hr></Hr>
            <img src={LogoBarba} alt="Logo" style={{ width: '250px', marginBottom: '-4px' }} /> {/* Add logo image */}
            <Hr></Hr>
            </LogoContainer>

            <h1>Faça seu cadastro</h1>
            
            <div style={{ marginBottom: 20 }}>
              <TypeButton type="button" onClick={() => setUserType('usuario')} selected={userType === 'usuario'}>
                Sou Usuário
              </TypeButton>
              <TypeButton type="button" onClick={() => setUserType('barbeiro')} selected={userType === 'barbeiro'}>
                Sou Barbeiro
              </TypeButton>
            </div>

            <Input name="name" icon={FiUser} placeholder="Nome" register={register} error={errors.name?.message} />
            <Input name="email" icon={FiMail} placeholder="E-mail" register={register} error={errors.email?.message} />
            <Input name="password" icon={FiLock} type="password" placeholder="Senha" register={register} error={errors.password?.message} />
            <Button type="submit" >Cadastrar</Button>
          </form>
          <Link to={"/"} >
            <FiArrowLeft />
            Voltar para login
          </Link>
        </AnimationContainer>
      </Content>
    </Container>
  )
};

export { SignUp };