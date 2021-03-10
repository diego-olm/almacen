package almacen;

import java.time.LocalTime;

public class DiaRetiro {
	private int id;
	private int diaSemana;
	private LocalTime horaDesde;
	private LocalTime horaHasta;
	private int intervalo;

	public DiaRetiro(int id, int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		super();
		this.id = id;
		this.diaSemana = diaSemana;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
		this.intervalo = intervalo;
	}

	public int getId() {
		return id;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public LocalTime getHoraDesde() {
		return horaDesde;
	}

	public LocalTime getHoraHasta() {
		return horaHasta;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}

	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}

	public String toString() {
		return "\nDiaRetiro id: " + id + ", diaSemana: " + diaSemana + ", horaDesde: " + horaDesde + ", horaHasta: "
				+ horaHasta + ", intervalo: " + intervalo;
	}
}