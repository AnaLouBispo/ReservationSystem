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
        System.out.print("Nome do Restaurante: ");
        String nomeRestaurante = sc.next();

        System.out.print("Especialidades do restaurante: ");
        String especialidades = sc.next();

        System.out.print("Nome do Titular da Reserva: ");
        String nomeCliente = sc.next();

        int numeroDeClientes = 0;

        do {
            System.out.print("Número de Pessoas: ");
            try {
                numeroDeClientes = sc.nextInt();
                if (numeroDeClientes > 8) {
                    System.out.println("Limite de Pessoas atingido :(");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                sc.next();
            }
        } while (true);

        int hora = 0;

        do {
            System.out.print("Hora: ");
            try {
                hora = sc.nextInt();
                if (hora < 00 || hora > 23) {
                    System.out.println("Horário inválido. Digite um número entre 00 e 23.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                sc.next();
            }

        } while (true);

        int min = 0;

        do {
            System.out.print("Minutos: ");
            try {
                min = sc.nextInt();
                if (min > 59) {
                    System.out.println("Horário Inválido");
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                sc.next();

            }
        } while (true);

        int mes = 0;

        do {
            System.out.print("Mês: ");
            try {
                mes = sc.nextInt();
                if (mes > 12 || mes < 1) {
                    System.out.println("Mês Inválido :(");
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                sc.next();
            }
        } while (true);

        int dia = 0;

        do {
            System.out.print("Dia: ");
            try {
                dia = sc.nextInt();
                if (dia < 1 || dia > 31) {
                    System.out.println("Data Inválida");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                sc.next();
            }
        } while (true);

        LocalTime horario = LocalTime.of(hora, min);
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
            System.out.print("Listando Reservas :> ");
            for (Reservation reserva : listasDeReservas) {
                System.out.print("Id: " + reserva.getId() + "\n" + "Titular da reserva: " + reserva.getNomeCliente()
                        + "\n" + "Dia: " + reserva.getDia() + "\n" + "Horário: " + reserva.getHorario() + "\n"
                        + "Número de pessoas: " + reserva.getNumeroDeClientes());
            }
        }
    }

    public void deletarVaga() {
        System.out.print("Id da reserva? ");
        Long id = sc.nextLong();

        if (listasDeReservas.removeIf(reserva -> reserva.getId() == id)) {
            System.out.println("Reserva Deletada >_<");
        } else {
            System.out.println("Erro ao deletar reserva");
        }
    }

    public void update() {
        System.out.print("Qual ID da reserva que deseja editar? ");

        Long id = sc.nextLong();
        int hora;
        int minuto;
        int dia;
        int mes;
        int numeroDePessoas;
        String restaurante;
        String nomeTit;
        String especialidades;

        if(listasDeReservas.isEmpty()) {
            System.out.println("Não ha nenhuma reserva feita : (");
        }
        for (Reservation reserva : listasDeReservas) {
            if (id == reserva.getId()) {
                System.out.print("Nome do Restaurante: ");
                restaurante = sc.next();
                reserva.setNomeRestaurante(restaurante);

                System.out.print("Especialidades do restaurante: ");
                especialidades = sc.next();
                reserva.setEspecialidades(especialidades);
                System.out.print("Nome do Titular da Reserva: ");
                nomeTit = sc.next();
                reserva.setNomeCliente(nomeTit);
                do {
                    System.out.print("Número de Pessoas: ");
                    try {
                        numeroDePessoas = sc.nextInt();
                        if (numeroDePessoas > 8) {
                            System.out.println("Limite de Pessoas atingido :(");
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                        sc.next();
                    }
                } while (true);
                reserva.setNumeroDeClientes(numeroDePessoas);

                do {
                    System.out.print("Hora: ");
                    try {
                        hora = sc.nextInt();
                        if (hora < 00 || hora > 23) {
                            System.out.println("Horário inválido. Digite um número entre 00 e 23.");
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                        sc.next();
                    }
                } while (true);

                do {
                    System.out.print("Minutos: ");
                    try {
                        minuto = sc.nextInt();
                        if (minuto > 59) {
                            System.out.println("Horário Inválido");
                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                        sc.next();

                    }
                } while (true);

                do {
                    System.out.print("Mês: ");
                    try {
                        mes = sc.nextInt();
                        if (mes > 12 || mes < 1) {
                            System.out.println("Mês Inválido :(");
                        } else {
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                        sc.next();
                    }
                } while (true);

                do {
                    System.out.print("Dia: ");
                    try {
                        dia = sc.nextInt();
                        if (dia < 1 || dia > 31) {
                            System.out.println("Data Inválida");
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Valor inválido. Por favor, digite um número inteiro.");
                        sc.next();
                    }
                } while (true);

                LocalTime horario = LocalTime.of(hora, minuto);
                reserva.setHorario(horario);
                LocalDate date = LocalDate.of(2024, mes, dia);
                reserva.setDia(date);

            } else {
                System.out.println("Não há nenhuma reserva com esse id (╯_╰) ");
            }
        }

    }
}
