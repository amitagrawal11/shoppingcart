package Exceptions;

public class MyException extends Exception{
	

	private static final long serialVersionUID = 1L;
	
	public MyException(Exception e) {
		super(e);
	}

	
}
