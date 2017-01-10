
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * @author Gradonski Janusz
 * @version 2013.3.9
 * ActionListener für das Girokonto
 */
@SuppressWarnings("serial")
public class ActionListener2 extends JFrame implements ActionListener {
	Girokonto k2;
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	/**
	 * Einzahlen des Eingegeben Betrages von der Textarea oder Abheben solange alle eingegebenen Zeichen Zahlen sind
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		k2 = ActionListener1.getK2();
		JButton b = (JButton) e.getSource();
		StyledDocument doc;
		StyledDocument doc2;
		GregorianCalendar now = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		try {
			if(ActionListener1.getTa() != null)	{
				if(b.getText().equals("Einzahlen"))	{
					k2.einzahlen(Double.parseDouble(ActionListener1.getTa().getText()));
					doc = ActionListener1.getTa2().getStyledDocument();
					SimpleAttributeSet keyword = new SimpleAttributeSet();
					StyleConstants.setForeground(keyword, Color.BLACK);
					try {
						doc.insertString(doc.getLength(), '\n' + "Einzahlung: " + Double.parseDouble(ActionListener1.getTa().getText()) + "	  Kontostand: " + k2.getSaldo() + "		 Uhrzeit: " + sdf.format(new Date()) + "   " + df.format(now.getTime()) + '\n', keyword);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				} else {
					k2.abheben(Double.parseDouble(ActionListener1.getTa().getText()));
					doc2 = ActionListener1.getTa2().getStyledDocument();
					SimpleAttributeSet keyword = new SimpleAttributeSet();
					StyleConstants.setForeground(keyword, Color.RED);
					try {
						doc2.insertString(doc2.getLength(), '\n' + "Auszahlung: " + Double.parseDouble(ActionListener1.getTa().getText()) + "	  Kontostand: " + k2.getSaldo() + "		 Uhrzeit: " + sdf.format(new Date()) + "   " + df.format(now.getTime()) + '\n', keyword);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					// ausg = ActionListener1.getTa2().getText();
					// ausg = ausg + '\n' + "Auszahlung: " + Double.parseDouble(ActionListener1.getTa().getText()) + "	  Kontostand: " + k2.getSaldo() + "		 Uhrzeit: " + sdf.format(new Date()) + "   " + df.format(now.getTime()) + '\n';
					// ActionListener1.setTa2(ausg);
				}
			}
		} catch(IllegalArgumentException ee)		{
			JOptionPane.showMessageDialog(null, "Sie haben nicht nur Zahlen eingegeben");
		} catch(NotEnoughMoneyException eee)	{
			JOptionPane.showMessageDialog(null, eee.getMessage());
		}
		ActionListener1.setTa("");
		ActionListener1.setSaldo(k2.getSaldo());
	}
}