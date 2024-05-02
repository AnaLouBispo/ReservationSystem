package Model;

public class Restaurant {

	private String nomeRestaurante;
	private String especialidades;
	private int DisponibilidadeDeReserva;
	public Restaurant(String nomeRestaurante, String especialidades, int disponibilidadeDeReserva) {
		super();
		this.nomeRestaurante = nomeRestaurante;
		this.especialidades = especialidades;
		DisponibilidadeDeReserva = disponibilidadeDeReserva;
	}
	public String getNomeRestaurante() {
		return nomeRestaurante;
	}
	public void setNomeRestaurante(String nome) {
		this.nomeRestaurante = nome;
	}
	public String getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(String especialidades) {
		this.especialidades = especialidades;
	}
	public int getDisponibilidadeDeReserva() {
		return DisponibilidadeDeReserva;
	}
	public void setDisponibilidadeDeReserva(int disponibilidadeDeReserva) {
		DisponibilidadeDeReserva = disponibilidadeDeReserva;
	}


}
