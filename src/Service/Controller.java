package Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Scanner;
import Model.Reservation;

public class Controller {

    HashSet<Reservation> listasDeReservas = new HashSet<>();

    Scanner sc = new Scanner(System.in);

    public void createReservation() {
        System.out.println("Nome do Restaurante: ");
        String nomeRestaurante = sc.next();

        System.out.println("Especialidades do restaurante: ");
        String especialidades = sc.next();

        System.out.println("Nome do Titular da Reserva: ");
        String nomeCliente = sc.next();

        System.out.println("Número de Pessoas: ");
        int numeroDeClientes = sc.nextInt();

        System.out.println("Hora: ");
        int hora = sc.nextInt();

        System.out.println("Minutos: ");
        int min = sc.nextInt();

        LocalTime horario = LocalTime.of(hora, min);

        System.out.println("Mês: ");
        int mes = sc.nextInt();
        System.out.println("Dia: ");
        int dia = sc.nextInt();
        LocalDate date = LocalDate.of(2024, mes, dia);

        int disponibilidadeDeReserva = 50;
        Long id = getNextId();

        Reservation reserva = new Reservation(nomeRestaurante, especialidades, disponibilidadeDeReserva, nomeCliente,
                numeroDeClientes, horario, date, id);
        listasDeReservas.add(reserva);

    }

    public Long getNextId() {
        long maxId = 0;
        for (Reservation reserva : listasDeReservas) {
            long id = reserva.getId();
            if (id > maxId) {

                maxId = id;
            }

        }
        return maxId + 1;
    }

    public void listarReservas() {

        if (listasDeReservas.isEmpty()) {
            System.out.println("Nenhuma reserva criada :/");
        } else {
            System.out.println("Listando Reservas :> ");
            for (Reservation reserva : listasDeReservas) {
                System.out.println("Id: " + reserva.getId() + "\n" + "Titular da reserva: " + reserva.getNomeCliente()
                        + "\n" + "Dia: " + reserva.getDia() + "\n" + "Horário: " + reserva.getHorario() + "\n"
                        + "Número de pessoas: " + reserva.getNumeroDeClientes());
            }
        }

    }

  
    public void deletarVaga() {
    	  System.out.println("Id da reserva? ");
    	  Long id = sc.nextLong();

        if (listasDeReservas.removeIf(reserva -> reserva.getId() == id)) {
            System.out.println("Reserva Deletada >_<");
        } else {
            System.out.println("Erro ao deletar reserva");
        }

    }

    public void update() {
        System.out.println("Qual ID da reserva que deseja editar? ");

        Long id = sc.nextLong();
        int hora;
        int minuto;
        int dia;
        int mes;
        int numeroDePessoas;
        String restaurante;
        String nomeTit;

        for (Reservation reserva : listasDeReservas) {
            if (id.equals(reserva.getId())) {
                System.out.println("Dia: ");
                dia = sc.nextInt();
                System.out.println("Mês");
                mes = sc.nextInt();
                LocalDate date = LocalDate.of(2024, mes, dia);

                reserva.setDia(date);

                System.out.println("Hora: ");
                hora = sc.nextInt();

                System.out.println("Minutos: ");
                minuto = sc.nextInt();

                LocalTime horario = LocalTime.of(hora, minuto);
                reserva.setHorario(horario);

                System.out.println("Quantidade de Pessoas: ");
                numeroDePessoas = sc.nextInt();
                reserva.setNumeroDeClientes(numeroDePessoas);

                System.out.println("Restaurante: ");
                restaurante = sc.next();
                reserva.setNomeRestaurante(restaurante);

                System.out.println("Nome do Titular: ");
                nomeTit = sc.next();
                reserva.setNomeCliente(nomeTit);

            }
        }

    }

}
