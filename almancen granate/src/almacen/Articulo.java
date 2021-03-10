package almacen;

public class Articulo {

	private int id;
	private String nombre;
	private String codBarras;
	private double precio;
	public Articulo(int id, String nombre, String codBarras, double precio)throws Exception {
		super();
		this.id = id;
		this.nombre = nombre;
		this.setCodBarras(codBarras);
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) throws Exception{
		if(!validarCodBarras(codBarras)) {
			throw new Exception("el codigo de barras del articulo es incorrecto");
		}
		else {
			this.codBarras=codBarras;
		}
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codBarras == null) ? 0 : codBarras.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Articulo other = (Articulo) obj;
		if (codBarras == null) {
			if (other.codBarras != null)
				return false;
		} else if (!codBarras.equals(other.codBarras))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
			return false;
		return true;
	}

	


	@Override
	public String toString() {
		return "\nArticulo id " + id + "  nombre " + nombre + "  codBarras " + codBarras + "  precio " + precio + "";
	}
	public boolean validarCodBarras(String codBarras) {
		boolean cond = false;
		int cod = codBarras.length();
		if (cod == 13) {
			cond = true;		
		} 
		return cond;
	}
}
