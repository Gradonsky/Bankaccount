
/**
 * @author Gradonski Janusz
 * @version 2013.3.6
 */
@SuppressWarnings("serial")
public class NotEnoughMoneyException extends Exception {
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 * @version 2013.3.6
	 */
	@Override
	public String getMessage()	{
		return "Es ist nicht genug Geld vorhanden!";
	}	
}