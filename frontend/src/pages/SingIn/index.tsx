import { FiLogIn, FiMail, FiLock } from 'react-icons/fi'
import { Link } from "react-router-dom";

import { Input } from '../../components/Input';
import { Button } from '../../components/Button';

import useAuth from "../../hooks/auth";
import { Container, Content, AnimationContainer, Background } from "./style";

import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as Yup from 'yup';

import { useToast } from "../../hooks/toast";

interface ISignDataForm {
  email: string;
  password: string;
}

const SignIn = () => {
  const { signIn } = useAuth();
  const { addToast } = useToast();

  const validationSchema = Yup.object().shape({
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

  const onSubmit = async (data: ISignDataForm) => {
    try {
      await signIn({
        email: data.email,
        password: data.password
      });
    } catch (error) {
      addToast({
        type: 'error',
        title: 'Erro na autenticação',
        description: 'Ocorreu um erro ao fazer login, cheque as credenciais'
      });
    }
  };

  return (
    <Container>
      <Content>
        <AnimationContainer>

          <form onSubmit={handleSubmit(onSubmit)}>
            <h1>Faça seu login</h1>

            <Input name="email" icon={FiMail} placeholder="E-mail" register={register} error={errors.email?.message} />
            <Input name="password" icon={FiLock} type="password" placeholder="Senha" register={register} error={errors.password?.message} />

            <Button type="submit">Entrar</Button>

            <Link to="forgot-password">Esqueci minha senha</Link>
          </form>

          <Link to="/signup">
            <FiLogIn />
            Criar Conta
          </Link>
        </AnimationContainer>
      </Content>
      <Background />
    </Container>
  );
};

export { SignIn };