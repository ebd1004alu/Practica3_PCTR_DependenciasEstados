package src.p03.c01;
/*
 * Andrea Minguez y Estela Victoria Ballester
 */
public class SistemaLanzador {
	public static void main(String[] args) {
		
		int aforo_maximo=50;
		IParque parque = new Parque(aforo_maximo); // TODO
		char letra_puerta = 'A';
		
		System.out.println("�Parque abierto!");
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			
			String puerta = ""+((char) (letra_puerta++));
			
			// Creación de hilos de entrada
			ActividadEntradaPuerta entradas = new ActividadEntradaPuerta(puerta, parque);
			new Thread (entradas).start();
			
			// 
			// TODO
			// Creación de hilos de salida
			ActividadSalidaPuerta salidas = new ActividadSalidaPuerta(puerta, parque);
			new Thread (salidas).start();
			
		}
	}	
}