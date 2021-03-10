package testeo;

import java.time.LocalDate;
import java.time.LocalTime;

import almacen.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Comercio comercio = new Comercio(0, null);
		System.out.println("se agregan 2 articulos iguales a lista de articulo del comercio");
		try {
			comercio.agregarArticulo("axe", "7287623256321", 45d);
			comercio.agregarArticulo("axe", "7287623256321", 45d);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("  " + e1);
		}
		System.out.println("=========================================================");
		System.out.println("se agrega un producto con el codigo de barras incorrecto");
		try {
			comercio.agregarArticulo("tang", "q", 50);
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			System.out.println("" + e3);
		}
		System.out.println("=========================================================");
		System.out.println("se agrega um cliente con el dni incorrecto");
		try {
			comercio.agregarCliente(null, "diaz", "diego", 1);
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			System.out.println(e3);
		}
		System.out.println("=========================================================");
		System.out.println("se intenta abrir un nuevo carrito para el mismo cliente sin cerrar el primero");

		try {
			comercio.agregarCliente(null, "siles", "leo", 1234567l);
			comercio.agregarCarrito(LocalDate.now(), LocalTime.now(), false, 0.0, comercio.traerCliente(1234567l),
					null);
			comercio.agregarCarrito(LocalDate.now(), LocalTime.now(), false, 0.0, comercio.traerCliente(1234567l),
					null);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("" + e1);
		}
		System.out.println("=========================================================");
		try {

			comercio.agregarArticulo("Leche Serenisima", "7287623294334", 45d);
			comercio.agregarArticulo("Salsa de tomate", "7281938294331", 75d);
			comercio.agregarArticulo("Rollo de cocina", "7928018294333", 30d);
			comercio.agregarArticulo("Azucar", "7281821343332", 40d);
			comercio.agregarArticulo("Mermelada", "7281544562334", 60d);
			comercio.agregarCliente(
					new Contacto("jorgerojas@hotmail.com", "987456321", new Ubicacion(-34.825870, -58.394844)), "rojas",
					"juan", 56789521l);
			comercio.agregarCarrito(LocalDate.now(), LocalTime.of(8, 30), false, 0.0, comercio.traerCliente(56789521l),
					new Envio(1, LocalDate.now(), true, LocalTime.of(9, 30), LocalTime.of(10, 30), 0.0,
							new Ubicacion(-34.825870, -58.394844)));
			Carrito carrito = comercio.traerCarrito(comercio.traerCliente(56789521l), false);
			carrito.agregar(comercio.traerArticulo("7287623294334"), 5);
			carrito.agregar(comercio.traerArticulo("7281938294331"), 4);
			carrito.agregar(comercio.traerArticulo("7928018294333"), 4);
			carrito.agregar(comercio.traerArticulo("7281821343332"), 4);
			carrito.agregar(comercio.traerArticulo("7281544562334"), 4);
			System.out.println("se imprime la lista de item ");
			System.out.println("" + carrito.getLstItemCarrito());
			carrito.agregar(comercio.traerArticulo("7287623294334"), 5);
			carrito.sacarDelCarrito(comercio.traerArticulo("7281938294331"), 8);
			carrito.sacarDelCarrito(comercio.traerArticulo("7281544562334"), 10);
			System.out.println("\n");
			System.out.println(
					"se vuelve a imprimir la lista de item para demostrar que cuando se agrega un mismo producto se incrementa la cantidad del item");
			System.out.println("se elimina 2 item");
			System.out.println("8) + agregar(Articulo articulo, int cantidad):boolean \n Sacar del carrito");
			System.out.println("" + carrito.getLstItemCarrito());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("=========================================================");
		System.out.println(
				"se crea un carrito con algunos articulos para demostros que se calculan los descuentos y se aplica el mayor");
		try {
			Comercio comercio1 = new Comercio(0,
					new Contacto("coto@gmail.com", "12345678", new Ubicacion(-34.781323, -58.405975)), "coto",
					38526642l, 400.00, 100, 1, 25, 50);
			comercio1.agregarCliente(
					new Contacto("jorgerojas@hotmail.com", "987456321", new Ubicacion(-34.825870, -58.394844)), "rojas",
					"juan", 56789521l);
			comercio1.agregarArticulo("Leche Serenisima", "7287623294334", 45d);
			comercio1.agregarArticulo("Salsa de tomate", "7281938294331", 75d);
			comercio1.agregarArticulo("Rollo de cocina", "7928018294333", 30d);
			comercio1.agregarArticulo("Azucar", "7281821343332", 40d);
			comercio1.agregarArticulo("Mermelada", "7281544562334", 60d);
			comercio1.agregarArticulo("porteñitas", "8597546142575", 50d);
			comercio1.agregarArticulo("terrabusi", "2586427895142", 100d);
			comercio1.agregarArticulo("criollitas", "asrj1428are63", 120);

			Cliente cliente = comercio.traerCliente(56789521l);
			comercio1.agregarCarrito(LocalDate.of(2020, 10, 12), LocalTime.of(8, 30), false, 0.0, cliente,
					new Envio(1, LocalDate.now(), true, LocalTime.of(9, 30), LocalTime.of(10, 30), 0.0,
							new Ubicacion(-34.825870, -58.394844)));
			Carrito carrito = comercio1.traerCarrito(cliente, false);
			carrito.agregar(comercio1.traerArticulo("7287623294334"), 5);
			carrito.agregar(comercio1.traerArticulo("7281938294331"), 4);
			carrito.agregar(comercio1.traerArticulo("7928018294333"), 2);
			carrito.agregar(comercio1.traerArticulo("7281821343332"), 6);

			System.out.println("\n");
			System.out.println("" + carrito.getLstItemCarrito());
			System.out.println("\n");
			System.out.println("descuento efectivo "
					+ carrito.calcularDescuentoEfectivo(comercio1.getPorcentajeDecuentoEfectivo()));
			System.out.println("descuento del dia "
					+ carrito.calcularDescuentoDia(comercio1.getDiaDescuento(), comercio1.getPorcentajeDecuentoDia()));
			System.out.println("total carrito " + carrito.calcularTotalCarrito());
			carrito.setCosto(comercio1.getCostoFijo(), comercio1.getCostoPorKm(),
					comercio1.getContacto().getUbicacion());
			System.out.println("total a pagar carrito cerrado " + carrito.cerrarCarrito(comercio1.getDiaDescuento(),
					comercio1.getPorcentajeDecuentoDia(), comercio1.getPorcentajeDecuentoEfectivo()));
			comercio1.agregarCarrito(LocalDate.of(2020, 10, 12), LocalTime.now(), false, 0.0, cliente,
					new RetiroLocal(2, LocalDate.of(2020, 10, 12), false, LocalTime.now()));

			System.out.println("=========================================================");
			System.out.println("segundo carrito");
			Carrito carrito2 = comercio1.traerCarrito(cliente, false);
			carrito2.agregar(comercio1.traerArticulo("8597546142575"), 2);
			carrito2.agregar(comercio1.traerArticulo("2586427895142"), 4);
			carrito2.agregar(comercio1.traerArticulo("asrj1428are63"), 2);

			System.out.println("" + carrito2.traerItemCarrito());
			System.out.println("descuento efectivo "
					+ carrito2.calcularDescuentoEfectivo(comercio1.getPorcentajeDecuentoEfectivo()));
			System.out.println("descuento del dia "
					+ carrito2.calcularDescuentoDia(comercio1.getDiaDescuento(), comercio1.getPorcentajeDecuentoDia()));
			System.out.println("total carrito " + carrito2.calcularTotalCarrito());
			carrito2.setCosto(comercio1.getCostoFijo(), comercio1.getCostoPorKm(),
					comercio1.getContacto().getUbicacion());
			System.out.println("total a pagar carrito cerrado " + carrito2.cerrarCarrito(comercio1.getDiaDescuento(),
					comercio1.getPorcentajeDecuentoDia(), comercio1.getPorcentajeDecuentoEfectivo()));

			System.out.println("=========================================================");
			comercio1.agregarDiaRetiro(3, LocalTime.of(16, 30), LocalTime.of(17, 00), 30);
			comercio1.agregarDiaRetiro(3, LocalTime.of(17, 00), LocalTime.of(17, 30), 30);
			comercio1.agregarDiaRetiro(7, LocalTime.of(12, 30), LocalTime.of(13, 00), 30);
			System.out.println("turnos ocupados");
			System.out.println("" + comercio1.traerTurnosOcupados(LocalDate.of(2020, 10, 14)));
			System.out.println("=========================================================");
			System.out.println("" + comercio1.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
