package br.mil.eb.dashboard_sgl_sg7.services.exceptions;

public class ErroProcessoException extends RuntimeException {
	private static final long serialVersionUID = -3426719776500235089L;

	public ErroProcessoException() {
	}

	public ErroProcessoException(String msg) {
		super(msg);
	}

	public ErroProcessoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
