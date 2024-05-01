import React, { useCallback, useRef } from "react";
import { FiArrowLeft, FiMail, FiUser, FiLock } from 'react-icons/fi'
import { Link, useNavigate } from "react-router-dom";

import { Input } from '../../components/Input';
import { Button } from '../../components/Button';

import { Container, Content, AnimationContainer, Background } from "./style";

import api from "../../services/api";
import { useToast } from "../../hooks/toast";

import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as Yup from 'yup';
import useAuth from "../../hooks/auth";

interface ISignUpFormData {
  name: string;
  email: string;
  password: string;
}

const SignUp: React.FC = () => {
  const { addToast } = useToast();
  const navigate = useNavigate();

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
    try{
      await api.post('users',{
        name: data.name,
        email: data.email,
        password: data.password
      });
    } catch(error) {
      addToast({
        type: 'error',
        title: 'Erro no Cadastro',
        description: 'Ocorreu um erro ao fazer cadastro, cheque as credenciais'
      });
    }
  
    addToast({
      type: 'success',
      title: 'Cadastro realizado',
      description: 'Você já pode fazer seu login'
    });

    navigate('/');
  };

  return (
    <Container>
      <Background />
      <Content>
        <AnimationContainer>
          <form onSubmit={handleSubmit(onSubmit)}>
            <h1>Faça seu cadastro</h1>
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