import { FiLogIn, FiMail, FiLock } from 'react-icons/fi'
import { Link } from "react-router-dom";
import { Input } from '../../components/Input';
import { Button } from '../../components/Button';
import useAuth from "../../hooks/auth";
import { Container, Content, AnimationContainer, Background, LogoContainer, Hr } from "./style";
import LogoBarba from '../../assets/logo.svg';
import SignUpBackground from '../../assets/sign-up-background.jpg';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import * as Yup from 'yup';

import { useToast } from "../../hooks/toast";

interface ISignDataForm {
  email: string;
  password: string;
}

const Servicos = () => {
  const { signIn } = useAuth();
  const { addToast } = useToast();

  const validationSchema = Yup.object().shape({
    email: Yup.string().required('Nome é obrigatório').email('Digite um e-mail válido'),
    password: Yup.string().required('Descrição é obrigatória')
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

            <LogoContainer>
            <Hr></Hr>
            <img src={LogoBarba} alt="Logo" style={{ width: '200px', marginBottom: '-4px' }} /> {/* Add logo image */}
            <Hr></Hr>
            </LogoContainer>

            <h1>Cadastrar Serviço</h1>

            <Input name="nome" icon={FiMail} placeholder="Nome" register={register} error={errors.email?.message} />
            <Input name="descricao" icon={FiLock} type="text" placeholder="Descrição" register={register} error={errors.password?.message} />
            <Input name="preco" icon={FiMail} placeholder="Preço" register={register} error={errors.email?.message} />

            <Button type="submit">Cadastrar</Button>
          </form>

          
        </AnimationContainer>
      </Content>
      <Background />
    </Container>
  );
};

export { Servicos };