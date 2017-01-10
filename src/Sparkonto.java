
/**
 * @author Gradonski Janusz
 * @version 2013.3.6
 */
public class Sparkonto extends Konto{
	/**
	 * Ist der Zinssatz für das jeweilige Sparkonto
	 */
	private float zinssatz;
	/**
	 * Das Guthaben des Sparkontos darf 0€ nicht unterschreiten
	 * @param nummer gibt die Nummer des Sparkontos an
	 * @param zinssatz legt den Zinssatz für dieses Sparkonto fest
	 */
	public Sparkonto(long nummer, float zinssatz)	{
		super (nummer);
		this.zinssatz = zinssatz;
	}
	/* (non-Javadoc)
	 * @see polydor.Konto#abheben(double)
	 * Überprüft ob der Saldo des Sparkontos mit dem Betrag zum abziehen unter 0€ sinken würde, wenn ja throws NotEnoughMoneyException
	 * @throws NotEnoughMoneyException Wenn das Saldo des Sparkontos unter 0€ sinken würde
	 * @version 2013.3.6
	 */
	public void abheben(double betrag)	throws NotEnoughMoneyException	{
		if(this.getSaldo() - betrag > 0)	{
			super.abheben(betrag);
		} else {
			throw new NotEnoughMoneyException();
		}
	}
	/**
	 * Addiert zu dem Saldo die Jahreszinsen
	 * @version 2013.3.6
	 */
	public void addiereJahreszinsen()	{
		double zins = this.getSaldo() * this.zinssatz / 100;
		/* Sollte die Zahl auf 2 Kommastellen kürzen aber funktioniert nicht. Warum ???
		String a = "" + zins;
		String b = "";
		for(int x = 0; x < a.length(); x++)		{
			if(a.charAt(x) == '.')	{
				if((x + 2) < a.length())	{
					if(Integer.parseInt(b = "" + a.charAt(x + 3)) > 5)	{
						zins = Double.parseDouble(a.substring(0, (x + 2)));
						zins = zins + 0.01;
					} else	{
						zins = Double.parseDouble(a.substring(0, (x + 2)));
					}
				}
				break;
			}
		}
		*/
		this.einzahlen(zins);
	}
}