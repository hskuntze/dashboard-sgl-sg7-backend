package br.mil.eb.dashboard_sgl_sg7.entities.sg7.ids;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class QcpOMId implements Serializable {
	private static final long serialVersionUID = -5024945575824781643L;

	@Column(name = "QTD_MIL_PREV")
	private Integer qtdMilPrev;

	@Column(name = "QTD_MIL_EFETIVO")
	private Integer qtdMilEfetivo;
	
	private String posto;
	private String longi;
	
	public QcpOMId() {}

	public QcpOMId(Integer qtdMilPrev, Integer qtdMilEfetivo, String posto, String longi) {
		this.qtdMilPrev = qtdMilPrev;
		this.qtdMilEfetivo = qtdMilEfetivo;
		this.posto = posto;
		this.longi = longi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(longi, posto, qtdMilEfetivo, qtdMilPrev);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QcpOMId other = (QcpOMId) obj;
		return Objects.equals(longi, other.longi) && Objects.equals(posto, other.posto)
				&& Objects.equals(qtdMilEfetivo, other.qtdMilEfetivo) && Objects.equals(qtdMilPrev, other.qtdMilPrev);
	}
}
