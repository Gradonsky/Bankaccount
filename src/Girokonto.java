
/**
 * @author Gradonski Janusz
 * @version 2013.3.6
 */
public class Girokonto extends Konto{
	/**
	 * Ist der Überziehungsrahmen für das jeweilige Girokonto
	 */
	private int ueberziehungsrahmen;
	/**
	 * Erzeugt ein Girokonto Objekt, das Saldo darf den Überziehungsrahmen nicht unterschreiten
	 * @param nummer gibt die Girokontonummer an
	 * @param uezr gibt an wie hoch der Überziehungsrahmen ist
	 * @version 2013.3.6
	 */
	public Girokonto(long nummer, int uezr) {
		super(nummer);
		this.ueberziehungsrahmen = uezr;
	}
	/** (non-Javadoc)
	 * @see polydor.Konto#abheben(double)
	 * @throws NotEnoughMoneyException wenn das Saldo beim abheben unter 0€ sinken würde
	 * @version 2013.3.6
	 */
	public void abheben(double betrag) throws NotEnoughMoneyException	{
		if(this.getSaldo() - betrag >= this.ueberziehungsrahmen)	{
			super.abheben(betrag);
		} else {
			throw new NotEnoughMoneyException();
		}
	}
	/**
	 * @param betrag ist der Betrag der auf ein Girokonto überwiesen werden soll
	 * @param zielkonto gibt das Zielgirokonto an
	 * @throws NotEnoughMoneyException wenn auf dem Girokonto aufdem abgebucht werden soll nicht genug Geld vorhanden ist
	 * @version 2013.3.6
	 */
	public void ueberweisen(double betrag, Girokonto zielkonto) throws NotEnoughMoneyException	{
		if(this.getSaldo() - betrag >= this.ueberziehungsrahmen)		{
			this.abheben(betrag);
			zielkonto.einzahlen(betrag);
		} else {
			throw new NotEnoughMoneyException();
		}
	}
}