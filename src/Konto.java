
/**
 * @author Gradonski Janusz
 * @version 2013.3.6
 */
public class Konto {
	/**
	 * Ist die Kontonummer für das jeweilige Konto
	 */
	private long nummer;
	/**
	 * Ist das Saldo für das jeweilige Konto
	 */
	private double saldo;
	
	/**
	 * Erzeugt ein Konto Objekt mit der Kontonummer
	 * @param nummer gibt an welche Kontonummer das Konto bekommt
	 */
	public Konto(long nummer)	{
		this.nummer = nummer;
		this.saldo = 0;
	}
	/**
	 * Zahlt einen Betrag auf ein Konto ein
	 * @param betrag gibt an wieviel auf das Konto eingezahlt werden soll
	 * @version 2013.3.6
	 */
	public void einzahlen(double betrag)	{
		this.saldo = this.saldo + betrag;
	}
	/**
	 * Liest das vorhanden Saldo aus und gibt es zurück
	 * @return gibt das vorhandene Saldo zurück
	 * @version 2013.3.6
	 */
	public double getSaldo()	{
		return this.saldo;
	}
	/**
	 * Zieht einen Betrag von einem Konto ab 
	 * @param betrag
	 * @throws NotEnoughMoneyException
	 * @version 2013.3.6
	 */
	public void abheben(double betrag) throws NotEnoughMoneyException {
		this.saldo = this.saldo - betrag;
	}
	/**
	 * @return the Kontonummer
	 */
	public long getNummer() {
		return nummer;
	}
	/**
	 * Generiert eine Kontonummer für ein neues Konto
	 */
	public static long generateKontonummer()	{
		String numm = "";
		int zahl;
		for(int x = 0; x < 8; x++) {
            zahl = (int) (Math.random()*(10-1)+1);
            numm = numm + zahl;
        }
		zahl = Integer.parseInt(numm);
		return (long) zahl;
	}
}