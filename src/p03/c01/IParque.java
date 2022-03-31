package src.p03.c01;
/*
 * Andrea Minguez y Estela Victoria Ballester
 */
public interface IParque {
	
	public abstract void entrarAlParque(String puerta) throws InterruptedException;

	// TODO
	public abstract void salirDelParque(String puerta) throws InterruptedException;
}
