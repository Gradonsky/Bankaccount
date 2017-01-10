
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * @author Gradonski Janusz
 * @version 2013.3.9
 */
@SuppressWarnings("serial")
public class ActionListener1 extends JFrame implements ActionListener {
	private static Sparkonto k;
	private static Girokonto k2;
	private static JTextField ta;
	private static JTextField saldo;
	private boolean spar = false;
	private static JTextPane ta2;
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/* Standard Aufgabe
		JButton b = (JButton) e.getSource();
		String a = b.getText();
		*/
		if(ActionListener4.getGew() != null)	{
			if(ActionListener4.getGew().equals("Bitte wählen Sie ein Konto aus welches Sie erstellen möchten"))	{
			} else {
				JButton b;
				JFrame j = Fenster.getJFrame();
				j.setVisible(false);
				j.getContentPane().removeAll();
				j.setLayout(new BorderLayout());
				b = new JButton("Einzahlen");
				JButton b2 = new JButton("Abheben");
				JButton b3;
				ta = new JTextField(10);
				ta2 = new JTextPane();
				ta2.setText("");
				saldo = new JTextField(10);
				JLabel l;
				JPanel p = new JPanel();
				setContentPane(p);
				b3 = new JButton();
				String konto = ActionListener4.getGew();
		        if(konto.equals("Sparkonto"))	{
		        	k = new Sparkonto(Konto.generateKontonummer(), (float) 1.3);
					b3 = new JButton("addiereJahreszinsen");
					b.addActionListener(new ActionListener3());
					b2.addActionListener(new ActionListener3());
					b3.addActionListener(new ActionListener3());
					l = new JLabel("Saldo ihres Sparkontos: ");
					spar = true;
		        } else {
		        	k2 = new Girokonto(Konto.generateKontonummer(),-3000);
					b.addActionListener(new ActionListener2());
					b2.addActionListener(new ActionListener2());
					l = new JLabel("Saldo ihres Girokontos: ");
		        }
				saldo.setEditable(false);
				ta2.setEditable(false);
				p.add(ta);
				p.add(b);
				p.add(b2);
				p.add(l);
				p.add(saldo);
				if(spar == true)		{
					p.add(b3);
				}
				j.add(p, BorderLayout.SOUTH);
				j.add(ta2, BorderLayout.CENTER);
				j.setSize(800,600);
				j.setVisible(true);
			}
		}
	}
	/**
	 * @param saldo the saldo to set
	 */
	public static void setSaldo(double d) {
		saldo.setText("" + d);
	}
	/**
	 * @return the ta
	 */
	public static JTextField getTa() {
		return ta;
	}
	/**
	 * @param ta the ta to set
	 */
	public static void setTa(String ausg) {
		ta.setText(ausg);
	}
	/**
	 * @return the k
	 */
	public static Sparkonto getK() {
		return k;
	}
	/**
	 * @param kk the kk to set
	 */
	public static void setK(Sparkonto kk) {
		k = kk;
	}
	/**
	 * @return the k2
	 */
	public static Girokonto getK2() {
		return k2;
	}
	/**
	 * @param k2 the k2 to set
	 */
	public void setK2(Girokonto k2k) {
		k2 = k2k;
	}
	/**
	 * @return the ta2
	 */
	public static JTextPane getTa2() {
		return ta2;
	}
}