
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Janusz Gradonski
 * @version 2013.3.9
 */
public class WindowListener1 extends WindowAdapter {
	public void WindowClosing(WindowEvent e)	{
		Fenster g = (Fenster) e.getSource();
		g.dispose();
		System.exit(0);
	}
}