
import javax.swing.JOptionPane;

/**
 * @author Gradonski Janusz
 * @version 2013.3.6
 */
public class Test {

	/**
	 * Test aller Methoden und Konstruktoren der Klassen: Konto, Sparkonto und Girokonto
	 * @param args
	 */
	public static void main(String[] args) {
		Konto k1 = new Konto(452645);
		k1.einzahlen(5000);
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k1.getSaldo());
		try {
			k1.abheben(8000);
		} catch(NotEnoughMoneyException e)	{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k1.getSaldo());
		Sparkonto k2 = new Sparkonto(67861545, (float) 1.5);
		k2.einzahlen(6000);
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k2.getSaldo());
		try {
			k2.abheben(8000);
		} catch(NotEnoughMoneyException e)		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k2.getSaldo());
		try {
			k2.abheben(4000);
		} catch(NotEnoughMoneyException e)	{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k2.getSaldo());
		k2.addiereJahreszinsen();
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k2.getSaldo());
		Girokonto k3 = new Girokonto(321232, -3600);
		k3.einzahlen(9000);
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k3.getSaldo());
		try {
			k3.abheben(15000);
		} catch(NotEnoughMoneyException e)	{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k3.getSaldo());
		try {
			k3.abheben(10000);
		} catch(NotEnoughMoneyException e)	{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k3.getSaldo());
		Girokonto k4 = new Girokonto(3245615, -6000);
		k4.einzahlen(5000);
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k4.getSaldo());
		try {
			k4.ueberweisen(20000, k3);
		} catch(NotEnoughMoneyException e)	{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k3.getSaldo());
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k4.getSaldo());
		try {
			k4.ueberweisen(4000, k3);
		} catch(NotEnoughMoneyException e)	{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k3.getSaldo());
		JOptionPane.showMessageDialog(null, "Saldo des Kontos: " + k4.getSaldo());
	}
}