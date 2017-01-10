

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * @author Gradonski Janusz
 *
 */
@SuppressWarnings("serial")
public class ActionListener4 extends JFrame implements ActionListener {
	private static String gew;
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)	e.getSource();
		gew = cb.getSelectedItem().toString();
	}
	/**
	 * @return the gew
	 */
	public static String getGew() {
		return gew;
	}
}
