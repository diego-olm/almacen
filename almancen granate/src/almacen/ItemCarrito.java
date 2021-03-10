package almacen;

public class ItemCarrito {

	private Articulo articulo;
	private int cantidad;
	public ItemCarrito(Articulo articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articulo == null) ? 0 : articulo.hashCode());
		result = prime * result + cantidad;
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
		ItemCarrito other = (ItemCarrito) obj;
		if (articulo == null) {
			if (other.articulo != null)
				return false;
		} else if (!articulo.equals(other.articulo))
			return false;
		if (cantidad != other.cantidad)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "\n " + articulo + " cantidad " + cantidad + "";
	}
	public double calcularSubTotalItem() {
		double total=this.articulo.getPrecio()*this.cantidad;
		return total;
	}
	
}
