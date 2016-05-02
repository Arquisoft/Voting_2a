package es.uniovi.asw.controller.exception;

public class NotValidValueException extends RuntimeException {

	private static final long serialVersionUID = 522078431575805107L;

	public NotValidValueException(String msg) {
		super(msg);
	}

	public NotValidValueException() {
		super();
	}

}
