package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation extends Restaurant {

	private String nomeCliente;
	private int numeroDeClientes;
	private LocalTime horario;
	private LocalDate dia;
	private Long id;

	public Reservation(String nomeRestaurante, String especialidades, int disponibilidadeDeReserva, String nomeCliente,
			int numeroDeClientes, LocalTime horario, LocalDate dia, Long id) {
		super(nomeRestaurante, especialidades, disponibilidadeDeReserva);
		this.nomeCliente = nomeCliente;
		this.numeroDeClientes = numeroDeClientes;
		this.horario = horario;
		this.dia = dia;
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getNumeroDeClientes() {
		return numeroDeClientes;
	}

	public void setNumeroDeClientes(int numeroDeClientes) {
		this.numeroDeClientes = numeroDeClientes;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setNomeRestaurante(String newName) {
		super.setNomeRestaurante(newName);
	}

}
