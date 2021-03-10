package almacen;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

	private LocalDate dia;
	private LocalTime hora;
	private boolean ocupado;
	public Turno(LocalDate dia, LocalTime hora, boolean ocupado) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.ocupado = ocupado;
	}
	public LocalDate getDia() {
		return dia;
	}
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + (ocupado ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turno other = (Turno) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (ocupado != other.ocupado)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Turno [dia=" + dia + ", hora=" + hora + ", ocupado=" + ocupado + "]";
	} 
	
	
}


