package almacen;

import java.time.LocalDate;

public abstract class Entrega  {

	protected int id;
	protected LocalDate fecha;
	protected boolean efectivo;
	
	public Entrega(int id, LocalDate fecha, boolean efectivo) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.efectivo = efectivo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isEfectivo() {
		return efectivo;
	}

	public void setEfectivo(boolean efectivo) {
		this.efectivo = efectivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (efectivo ? 1231 : 1237);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
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
		Entrega other = (Entrega) obj;
		if (efectivo != other.efectivo)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entrega [id=" + id + ", fecha=" + fecha + ", efectivo=" + efectivo + "]";
	}
	
	
	
}
