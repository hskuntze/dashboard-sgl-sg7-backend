package br.mil.eb.dashboard_sgl_sg7.services.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 6016576005960652003L;

	public RecursoNaoEncontradoException() {
	}

	public RecursoNaoEncontradoException(String msg) {
		super(msg);
	}

	public RecursoNaoEncontradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
