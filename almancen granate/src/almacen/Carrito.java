package almacen;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito> lstItemCarrito;
	private Entrega entrega;

	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado,double descuento, Cliente cliente,
			Entrega entrega) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = false;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = new ArrayList<ItemCarrito>();
		this.entrega = entrega;
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

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}

	public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cerrado ? 1231 : 1237);
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		long temp;
		temp = Double.doubleToLongBits(descuento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((entrega == null) ? 0 : entrega.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + id;
		result = prime * result + ((lstItemCarrito == null) ? 0 : lstItemCarrito.hashCode());
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
		Carrito other = (Carrito) obj;
		if (cerrado != other.cerrado)
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (Double.doubleToLongBits(descuento) != Double.doubleToLongBits(other.descuento))
			return false;
		if (entrega == null) {
			if (other.entrega != null)
				return false;
		} else if (!entrega.equals(other.entrega))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id != other.id)
			return false;
		if (lstItemCarrito == null) {
			if (other.lstItemCarrito != null)
				return false;
		} else if (!lstItemCarrito.equals(other.lstItemCarrito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carrito id " + id + " fecha " + fecha + " hora " + hora + " cerrado " + cerrado + " descuento "
				+ descuento + " \n cliente " + cliente + " \n " + lstItemCarrito + " \nentrega " + entrega + "\n\n";
	}

	public ItemCarrito traerItemCarrito(Articulo articulo) {
		ItemCarrito item = null;
		int contador = 0;
		while (contador < this.lstItemCarrito.size() && item == null) {
			if (this.lstItemCarrito.get(contador).getArticulo().equals(articulo)) {

				item = this.lstItemCarrito.get(contador);
			} else {
				contador++;
			}

		}
		return item;
	}

	public boolean agregar(Articulo articulo, int cantidad) throws Exception {
		boolean bandera = false;
		if (this.cerrado) {
			throw new Exception("no se puede agregar mas producto ya que se cerro el carrito");
		}

		ItemCarrito item = this.traerItemCarrito(articulo);
		if (item==null) {
			lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
		} else {
			item.setCantidad(item.getCantidad() + cantidad);
			bandera = true;
		}
		return bandera;
	}

	public boolean sacarDelCarrito(Articulo articulo, int cantidad) {

		boolean bandera = false;
		ItemCarrito item = traerItemCarrito(articulo);
		if (item != null) {
			if (item.getCantidad() - cantidad <= 0) {
				this.lstItemCarrito.remove(item);
			} else {
				item.setCantidad(item.getCantidad() - cantidad);
				bandera = true;
			}

		}
		return bandera;
	}

	public double calcularTotalCarrito() {
		double total = 0;
		for (ItemCarrito p : this.lstItemCarrito) {
			total = total + p.calcularSubTotalItem();
		}
		return total;
	}

	public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuento) {
		double total = 0;
		int cantidad = 0;
		if (this.fecha.getDayOfWeek().getValue() == diaDescuento) {
			for (ItemCarrito p : this.lstItemCarrito) {
				if (p.getCantidad() >= 2) {
					cantidad = p.getCantidad() / 2;
					total = total + cantidad * p.getArticulo().getPrecio() * porcentajeDescuento / 100;
				}
			}
		}

		return total;
	}
	public double totalAPagarCarrito() {
		double total = 0;
		total = calcularTotalCarrito() - this.descuento;

		return total;
	}
	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		double descuento = 0;
		if (this.entrega.efectivo) {
			descuento = calcularTotalCarrito() * porcentajeDescuentoEfectivo / 100;
		}
		return descuento;

	}

	public void calcularDescuentoCarrito(int diaDescuento, double porcentajeDescuento,
			double porcentajeDescuentoEfectivo) {
		double descuento = 0;
		double descuentoEfectivo = calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
		double descuentoDia = calcularDescuentoDia(diaDescuento, porcentajeDescuento);

		if (descuentoEfectivo < descuentoDia) {
			descuento = descuentoDia;

		} else {
			descuento = descuentoEfectivo;
		}
		setDescuento(descuento);

	}

	public double cerrarCarrito(int diaDescuento, double porcentajeDescuento, double porcentajeDescuentoEfectivo) {
		this.setCerrado(true);
		calcularDescuentoCarrito(diaDescuento, porcentajeDescuento, porcentajeDescuentoEfectivo);
		return this.totalAPagarCarrito();

	}

	public void setCosto(double costoFijo, double costoPorKm, Ubicacion ubicacion) {
		double costo = 0;
		double distancia = 0;
		if (this.entrega instanceof Envio) {
			Envio envio = (Envio) entrega;
			distancia = distanciaCoord(envio.getUbicacion().getLatitud(),
					envio.getUbicacion().getLongitud(), ubicacion.getLatitud(),
					ubicacion.getLongitud());
			if (distancia >= 1) {
				costo = (distancia * costoPorKm) + costoFijo;
			} else {
				costo = costoFijo;
			}

			envio.setCosto(costo);
		}
	}

	public List<ItemCarrito> traerItemCarrito() {
		return this.lstItemCarrito;
	}

	public double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
		double radioTierra = 6371; // en kilómetros
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		return radioTierra * va2;
	}

}
