package System;

import java.util.Scanner;

import Service.Controller;

public class Sistema {

	public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);
					Controller hm = new Controller();
					int op = 0;

					do {
						System.out.println(
								"1-Criar Reserva \n2-Listar \n3-Deletar Reserva \n4-Atualizar \n9-Sair");
						op = sc.nextInt();

						System.out.println("-----------------------------");
						switch (op) {
						case 1: {
							hm.createReservation();
							break;
						}
						case 2: {
							hm.listarReservas();
							break;
						}
						
						case 3:{
							hm.deletarVaga();
							break;
						}
						case 4:{
							hm.update();
							break;
						}
						
						case 9: {
							System.exit(0);
						}

						default:
							System.out.println("Opção Invalida");
							break;
						}

					} while (op != 9);
					sc.close();

				}
			}


