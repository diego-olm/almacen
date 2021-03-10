package almacen;

import java.time.LocalDate;
import java.time.LocalTime;

public class RetiroLocal extends Entrega {

	private LocalTime horaEntrega;

	public RetiroLocal(int id, LocalDate fecha, boolean efectivo, LocalTime horaEntrega) {
		super(id, fecha, efectivo);
		this.horaEntrega = horaEntrega;
	}

	public LocalTime getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(LocalTime horaEntrega) {
		this.horaEntrega = horaEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((horaEntrega == null) ? 0 : horaEntrega.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetiroLocal other = (RetiroLocal) obj;
		if (horaEntrega == null) {
			if (other.horaEntrega != null)
				return false;
		} else if (!horaEntrega.equals(other.horaEntrega))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RetiroLocal [horaEntrega=" + horaEntrega + "]";
	}

	
	
	
}
