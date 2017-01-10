
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * @author Gradonski Janusz
 *
 */
@SuppressWarnings("serial")
public class Fenster extends JFrame {
	private JFrame j;
	private static JFrame j2;
	/**
	 * Erstellt ein JFrame
	 */
	public Fenster()	{
		j = new JFrame();
		j.setLayout(new GridLayout(2, 1));
		/* für die Standard Aufgabe
		JButton b = new JButton("neues Sparkonto");
		JButton b2 = new JButton("neues Girokonto");
		b.addActionListener(new ActionListener1());
		b2.addActionListener(new ActionListener1());
		j.add(b);
		j.add(b2);
		*/
		JButton b = new JButton("Konto erstellen");
		String[] konten = {"Bitte wählen Sie ein Konto aus welches Sie erstellen möchten", "Sparkonto", "Girokonto"};
		JComboBox cb = new JComboBox(konten);
		cb.addActionListener(new ActionListener4());;
		b.addActionListener(new ActionListener1());
		j.add(b);
		j.add(cb);
		addWindowListener(new WindowListener1());
		j.setSize(800, 600);
		j.setVisible(true);
		j2 = j;
	}
	/**
	 * gibt Zugriff zum JFrame
	 */
	public static JFrame getJFrame()	{
		return j2;
	}
	/**
	 * setzt das JFrame
	 */
	public void setJFrame(JFrame j)		{
		this.j = j;
	}
}
