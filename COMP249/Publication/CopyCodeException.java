package A2;

@SuppressWarnings("serial")
public class CopyCodeException extends Exception
{
	public CopyCodeException(String msg)
	{
		super(msg);
	}
	
	public CopyCodeException(String msg, Throwable cause)
	{
		super(msg, cause);
	}
}
