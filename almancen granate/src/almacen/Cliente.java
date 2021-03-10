package almacen;

public class Cliente extends Actor {

	private String apellido;
	private String nombre;
	private long dni;

	public Cliente(int id, Contacto contacto, String apellido, String nombre, long dni) throws Exception {
		super(id, contacto);
		this.apellido = apellido;
		this.nombre = nombre;
		this.setDni(dni);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) throws Exception {
		if (!validarIdentificadorUnico(dni)) {
			throw new Exception("Error: DNI ingresado no valido ");
		} else {
			this.dni = dni;
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + (int) (dni ^ (dni >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Cliente other = (Cliente) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni != other.dni)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " apellido " + apellido + " nombre " + nombre + " dni " + dni + " ";
	}

	@Override
	public boolean validarIdentificadorUnico(long identificador) {
		boolean cond = false;
		if (identificador >= 100000 && identificador <= 99999999) {

			cond = true;
		}
		return cond;
	}

}
