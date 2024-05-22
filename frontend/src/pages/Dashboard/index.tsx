import React, { useCallback, useEffect, useMemo, useState } from "react";
import { DayClickEventHandler, Modifiers } from 'react-day-picker';
import { isToday, format, parseISO, isAfter } from 'date-fns';
import "react-datepicker/dist/react-datepicker.css";

import { DayPicker } from 'react-day-picker';
import DatePicker from "react-datepicker";

import { Container, Header, HeaderContainer, Profile, Content, Schedule, Calendar, NextAppointment, Section, Appointment } from "./style";

import { FiClock, FiPower } from "react-icons/fi";
import useAuth from "../../hooks/auth";
import api from "../../services/api";
import { Link } from "react-router-dom";

import { ptBR } from 'date-fns/locale';
import { registerLocale } from 'react-datepicker';


interface IMonthAvailability {
  day: number;
  available: boolean;
}

interface IAppointments {
  id: string;
  date: string;
  hourFormatted: string;
  user: {
    name: string;
    avatar_url: string;
  }
}

interface Modifiers {
    available?: boolean;
    disabled?: boolean;
    [otherKey: string]: boolean | undefined;
}

export const Dashboard: React.FC = () => {
  registerLocale('pt-BR', ptBR);
  const [selectedDate1, setSelectedDate1] = useState(new Date());
  const [currentMonth, setCurrentMonth] = useState(new Date());
  const [monthAvailability, setMonthAvailability] = useState<IMonthAvailability[]>([]);
  const [appointments, setAppointments] = useState<IAppointments[]>([]);
  const [selectedDate, setSelectedDate] = useState<Date | null>(null);

  const { signOut, user } = useAuth();

  const handleDateChange = useCallback((day: Date, modifiers: Modifiers) => {
    if (modifiers.available && !modifiers.disabled) {
      setSelectedDate1(day);
    }
  }, []);

  const handleMonthChange = useCallback((month: Date) => {
    setCurrentMonth(month);
  }, []);

//   useEffect(() => {
//     api.get(`/providers/${user.id}/month-availability`, {
//       params: {
//         year: currentMonth.getFullYear(),
//         month: currentMonth.getMonth() + 1
//       }
//     }).then(response => {
//       setMonthAvailability(response.data);
//     })
//   }, [currentMonth, user.id]);

//   useEffect(() => {
//     api.get<IAppointments[]>('/appointments/me', {
//       params: {
//         year: selectedDate.getFullYear(),
//         month: selectedDate.getMonth() + 1,
//         day: selectedDate.getDate()
//       }
//     }).then(response => {
//       const appointmentsFormatted = response.data.map(appointment => {
//         return {
//           ...appointment,
//           hourFormatted: format(parseISO(appointment.date), 'HH:mm')
//         }
//       });

//       const appoitmentsOrdem = appointmentsFormatted.sort((a, b) => {
//         return parseISO(a.date).getTime() - parseISO(b.date).getTime()
//       });

//       setAppointments(appoitmentsOrdem);
//     })
//   }, [selectedDate]);

  const disabledDays = useMemo(() => {
    const dates = monthAvailability
      .filter(monthDay => monthDay.available === false)
      .map(monthDay => {
        const month = currentMonth.getMonth();
        const year = currentMonth.getFullYear();
        return new Date(year, month, monthDay.day);
      });
    return dates;
  }, [currentMonth, monthAvailability]);

  const seletedDateAsText = useMemo(() => {
    return format(selectedDate1, "'Dia' dd 'de' MMMM")
  }, [selectedDate1])

  const seletedWeekDay = useMemo(() => {
    return format(selectedDate1, 'cccc')
  }, [selectedDate1])

  const morningAppointments = useMemo(() => {
    return appointments.filter(appointment => {
      return parseISO(appointment.date).getHours() < 12;
    })
  }, [appointments]);

  const afternoonAppointments = useMemo(() => {
    return appointments.filter(appointment => {
      return parseISO(appointment.date).getHours() >= 12;
    })
  }, [appointments]);

  const nextAppointment = useMemo(() => {
    return appointments.find(appointment =>
      isAfter(parseISO(appointment.date), new Date())
    );
  }, [appointments])

  return (
    <Container>
      <Header>
        <HeaderContainer>

          <Profile>
            <div>
              <span>Bem vindo</span>
              <Link to="/profile">
                <strong>Nome</strong>
              </Link>

            </div>
          </Profile>

          <button type="button" onClick={signOut}>
            <FiPower />
          </button>
        </HeaderContainer>
      </Header>

      <Content>
        <Schedule>
          <h1>Horarios agendados</h1>
          <p>
            {isToday(selectedDate1) && <span>Hoje</span>}
            <span>{seletedDateAsText}</span>
            <span>{seletedWeekDay}</span>
          </p>

          {isToday(selectedDate1) && nextAppointment && (
            <NextAppointment>
              <strong>Agendamento a seguir</strong>

              <div>
                <img src="#" alt="" />

                <strong>Agendamento</strong>
                <span>
                  <FiClock />
                  {nextAppointment.hourFormatted}
                </span>
              </div>
            </NextAppointment>

          )}

          <Section>
            <strong>Manhã</strong>

            {morningAppointments.length === 0 && (
              <p>Nenhum agenda neste período</p>
            )}

            {morningAppointments.map(appointment => (
              <Appointment key={appointment.id}>
                <span>
                  <FiClock />
                  {appointment.hourFormatted}
                </span>

                <div>
                  <img src={appointment.user.avatar_url} alt="" />

                  <strong>{appointment.user.name}</strong>
                </div>
              </Appointment>
            ))}


          </Section>

          <Section>
            <strong>Tarde</strong>

            {afternoonAppointments.length === 0 && (
              <p>Nenhum agenda neste período</p>
            )}

            {afternoonAppointments.map(appointment => (
              <Appointment key={appointment.id}>
                <span>
                  <FiClock />
                  {appointment.hourFormatted}
                </span>

                <div>
                  <img src={appointment.user.avatar_url} alt="" />

                  <strong>{appointment.user.name}</strong>
                </div>
              </Appointment>
            ))}
          </Section>
          

        </Schedule>

        {/* <Calendar>
          <DayPicker
            weekdaysShort={['D', 'S', 'T', 'Q', 'Q', 'S', 'S']}
            disabledDays={[
              { daysOfWeek: [0, 6] },
              ...disabledDays
            ]}
            modifiers={{
              available: { daysOfWeek: [1, 2, 3, 4, 5] }
            }}
            onDayClick={handleDateChange}
            selectedDays={selectedDate}
            onMonthChange={handleMonthChange}
            
            fromMonth={new Date()}
          />
        </Calendar> */}
        
       <Calendar>
        
        <DatePicker selected={selectedDate} onChange={(date: Date | null)=> setSelectedDate(date)}
        inline
        locale="pt-BR"
        />
         <div>
            {selectedDate ? (
              <p>Teste:data escolida {format(selectedDate, 'MMMM d, yyyy', { locale: ptBR })}</p>
            ) : (
              <p>No date selected</p>
            )}
          </div>

       </Calendar>




      </Content>
    </Container>
  );
}