package src.p03.c01;

import java.util.Enumeration;
import java.util.Hashtable;

public class Parque implements IParque{


	// TODO 
	private int contadorPersonasTotales;
	private int maxAforo, minAforo;
	private Hashtable<String, Integer> contadoresPersonasPuerta;
	
	private boolean aforoCompletado;
	
	
	public Parque() {	// TODO
		contadorPersonasTotales = 0;
		contadoresPersonasPuerta = new Hashtable<String, Integer>();
		minAforo = 0;
		maxAforo = 50;
		aforoCompletado = false;
	}


	@Override
	public void entrarAlParque(String puerta){		// TODO
		
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// TODO
		//Comprobar precondicion
		
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)+1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
		
		// TODO
		// Comprobamos invariante
		checkInvariante();
		
		
		// TODO
		if (contadorPersonasTotales == maxAforo) {
			aforoCompletado = true;
			notifyAll();
		}
		
	}
	
	// 
	// TODO Método salirDelParque
	//
	@Override
	public void salirDelParque(String puerta){		// TODO
		
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// TODO
				
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales--;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)-1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Salida");
		
		// TODO
		
		
		
		// TODO
		checkInvariante();
		
	}
	
	
	private void imprimirInfo (String puerta, String movimiento){
		System.out.println(movimiento + " por puerta " + puerta);
		System.out.println("--> Personas en el parque " + contadorPersonasTotales); //+ " tiempo medio de estancia: "  + tmedio);
		
		// Iteramos por todas las puertas e imprimimos sus entradas
		for(String p: contadoresPersonasPuerta.keySet()){
			System.out.println("----> Por puerta " + p + " " + contadoresPersonasPuerta.get(p));
		}
		System.out.println(" ");
	}
	
	private int sumarContadoresPuerta() {
		int sumaContadoresPuerta = 0;
			Enumeration<Integer> iterPuertas = contadoresPersonasPuerta.elements();
			while (iterPuertas.hasMoreElements()) {
				sumaContadoresPuerta += iterPuertas.nextElement();
			}
		return sumaContadoresPuerta;
	}
	
	protected void checkInvariante() {
		assert sumarContadoresPuerta() == contadorPersonasTotales : "INV: La suma de contadores de las puertas debe ser igual al valor del contador del parte";
		assert contadorPersonasTotales <= maxAforo: "INV: El numero de personas total debe ser menor o igual al aforo maximo";
		assert contadorPersonasTotales >= minAforo: "INV: El numero de personas total debe ser mayor o igual al aforo minimo";
		// TODO
		
		
		
	}

	protected void comprobarAntesDeEntrar() throws InterruptedException{	// TODO
		//
		// TODO
		//
		//Si esta lleno, espera a que haya salidas
		while (contadorPersonasTotales ==  maxAforo) {
			wait();		
		}
		//notifica de entrada
		notifyAll();
		
		
	}

	protected void comprobarAntesDeSalir() throws InterruptedException{		// TODO
		//
		// TODO
		//notifica de salida
		notifyAll();
		//para poder salir, tienen que haber personas dentro, espera entradas
		while (contadorPersonasTotales > 0) {
			wait();		
		}
	}


}
