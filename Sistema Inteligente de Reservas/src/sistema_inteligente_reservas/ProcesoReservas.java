package sistema_inteligente_reservas;
/**
 * @version 1.0
 * @author RawVR
 */

import java.util.Scanner;

/** Clase hija que hará la función del sistema de reserva de coches */
public class ProcesoReservas {

	static Scanner inputT = new Scanner(System.in);
	
	/**
	 * El método main se encargará de hacer las preguntas
	 * @param args Argumento del main
	 * */
	public static void main(String[] args) {

		// Declaración de variables
		String sino = ""; // Guarda si o no.
		String sPuertas = ""; // Guarda el nº de puertas.
		String sModelo = ""; // Guarda el modelo del coche a reservar.
		String sCiudad = ""; // Guarda la ciudad donde se va a reservar el coche.
		String sFecha = ""; // Guarda la fecha de la reserva.
		String sDias = ""; // Guarda el nº de dias a reservar el coche.
		int nPuertas = 0; // Lo mismo que sPuertas pero en entero.
		boolean next = true; // Guarda si debe seguir el bucle while o no.

		System.out.println("--- Sistema de reservas de coches ---");

		// Preguntas de la reserva

		do { // Pregunta 0
			System.out.print("¿Desea reservar un coche?: ");
			sino = inputT.next();

			if (!sino.equalsIgnoreCase("SI") && !sino.equalsIgnoreCase("NO")) // Solo sigue el programa si dice si o no.
				System.out.println("No le entiendo, introduzca si o no.");
			if (sino.equalsIgnoreCase("NO")) { // En caso de decir no, se cerrará el programa.
				System.out.println("Cerrando sistema de reservas de coches...");
				System.exit(0);
			}
		} while (!sino.equalsIgnoreCase("SI"));
		System.out.println("------------------------------");

		do { // Pregunta 1
			System.out.print("¿De cuantas puertas (2-5)?: ");
			sPuertas = inputT.next();
			if (sPuertas.equals("2") || sPuertas.equals("3") || sPuertas.equals("4") || sPuertas.equals("5")) {
				nPuertas = Integer.parseInt(sPuertas);
				next = false;
			} else
				System.out.println("No le entiendo, introduzca un nº de puertas entre 2 y 5 (inclusives).");
		} while (next);
		next = true;
		System.out.println("-----");

		System.out.println("¿Que modelo de coche desea?: "); // Pregunta 2
		switch (nPuertas) {
		case 2: // Si el usuario desea un coche de 2 puertas...
			do {
				System.out.println("Coches disponibles:");
				System.out.println("Fiat-500 | VW-Polo | VW-Up");

				sModelo = inputT.next();
				if (sModelo.equals("Fiat-500") || sModelo.equals("VW-Polo") || sModelo.equals("VW-Up")) {
					next = false;
				} else {
					System.out.println("No le entiendo, introduzca un modelo disponible.");
				}
			} while (next);
			break;
		case 3: // Si el usuario desea un coche de 3 puertas...
			do {
				System.out.println("Coches disponibles:");
				System.out.println("Opel-Corsa | Peugeot-208 | SEAT-Leon-SC");
				sModelo = inputT.next();
				if (sModelo.equals("Opel-Corsa") || sModelo.equals("Peugeot-208") || sModelo.equals("SEAT-Leon-SC"))
					next = false;
				else
					System.out.println("No le entiendo, introduzca un modelo disponible.");
			} while (next);
			break;
		case 4: // Si el usuario desea un coche de 4 puertas...
			do {
				System.out.println("Coches disponibles:");
				System.out.println("Ford-Fiesta | Ford-Focus | Nissan-Micra");
				sModelo = inputT.next();
				if (sModelo.equals("Ford-Fiesta") || sModelo.equals("Ford-Focus") || sModelo.equals("Nissan-Micra"))
					next = false;
				else
					System.out.println("No le entiendo, introduzca un modelo disponible.");
			} while (next);
			break;
		case 5: // Si el usuario desea un coche de 5 puertas...
			do {
				System.out.println("Coches disponibles:");
				System.out.println("Skoda-Fabia-Combi | Kia-Ceed-Tourer | Peugeot-308 SW");
				sModelo = inputT.next();
				if (sModelo.equals("Skoda-Fabia-Combi") || sModelo.equals("Kia-Ceed-Tourer")
						|| sModelo.equals("Peugeot-308-SW"))
					next = false;
				else
					System.out.println("No le entiendo, introduzca un modelo disponible.");
			} while (next);
			break;
		default:
			break;
		}
		next = true;
		System.out.println("-----");

		do { // Pregunta 3
			System.out.print("¿En que ciudad?: ");
			sCiudad = inputT.next();
			if (sCiudad.equals("Barcelona") || sCiudad.equals("Galicia") || sCiudad.equals("Madrid")
					|| sCiudad.equals("Sevilla") || sCiudad.equals("Valencia")) {
				next = false;
			} else {
				System.out.println("No le entiendo, introduzca una de las siguientes:");
				System.out.println("Barcelona | Galicia | Madrid | Sevilla | Valencia");
			}
		} while (next);
		next = true;
		System.out.println("-----");

		System.out.print("¿Cuando desea alquilarlo?: "); // Pregunta 4
		sFecha = inputT.next();
		System.out.println("-----");

		do { // Pregunta 5
			try {
				System.out.print("¿Cuantos días?: ");
				sDias = inputT.next();
				next = false;
			} catch (Exception e) {
				System.out.println("No le entiendo, introduzca un número de días valido.");
			}
		} while (next);
		System.out.println("------------------------------");

		muestraReserva(sModelo, sPuertas, sCiudad, sFecha, sDias);
	}

	/**
	 * Funcion que muestra la reserva completa
	 * 
	 * @param sModelo Modelo del coche reservado
	 * @param sPuertas Nº de puertas del coche reservado
	 * @param sCiudad Ciudad donde se reserva el coche
	 * @param sFecha Fecha de la reserva
	 * @param sDias Duración en dias de la reserva
	 * */
	public static void muestraReserva(String sModelo, String sPuertas, String sCiudad, String sFecha,
			String sDias) {
		int nReserva = 0; // Numero de la reserva (id).
		
		System.out.println("¡Ha completado su reserva correctamente!");
		nReserva = (int) (Math.random() * (99999 - 10000 + 1)) + 10000;
		System.out.println("Datos:");
		System.out.println("Nº de reserva: " + nReserva);
		System.out.println("Modelo: " + sModelo + " (" + sPuertas + " puertas)");
		System.out.println("Ciudad: " + sCiudad);
		System.out.println("Inicio de reserva: " + sFecha);
		System.out.println("Nº de dias disponible: " + sDias);
	}
}