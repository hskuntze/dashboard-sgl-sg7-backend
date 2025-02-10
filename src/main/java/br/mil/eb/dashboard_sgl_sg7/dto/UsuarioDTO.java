package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1646080403048849453L;

	private Long id;
	private String nomecompleto;
	private String username;
	private String tipo;
	private String cpf;
	private String identidade;
	private String nomeguerra;
	private String telefone;
	private String email;
	private String organizacao;

	private PostoDTO posto;
	private OMDTO om;

	private boolean habilitado;
	private boolean registroCompleto;

	private Set<PerfilDTO> perfis = new HashSet<>();

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nomecompleto = usuario.getNomecompleto();
		this.nomeguerra = usuario.getNomeguerra();
		this.cpf = usuario.getCpf();
		this.organizacao = usuario.getOrganizacao();
		this.username = usuario.getUsername();
		this.email = usuario.getEmail();
		this.habilitado = usuario.isHabilitado();
		this.registroCompleto = usuario.isRegistroCompleto();
		this.telefone = usuario.getTelefone();
		this.tipo = usuario.getTipo();
		this.identidade = usuario.getIdentidade();

		if(usuario.getOm() != null) {
			this.om = new OMDTO(usuario.getOm());
		}

		if(usuario.getPosto() != null) {
			this.posto = new PostoDTO(usuario.getPosto());
		}

		this.perfis.clear();
		usuario.getPerfis().forEach(perfil -> this.perfis.add(new PerfilDTO(perfil)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeguerra() {
		return nomeguerra;
	}

	public void setNomeguerra(String nomeguerra) {
		this.nomeguerra = nomeguerra;
	}

	public String getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(String organizacao) {
		this.organizacao = organizacao;
	}

	public String getEmail() {
		return email;
	}

	public void setPerfis(Set<PerfilDTO> perfis) {
		this.perfis = perfis;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public boolean isRegistroCompleto() {
		return registroCompleto;
	}

	public void setRegistroCompleto(boolean registroCompleto) {
		this.registroCompleto = registroCompleto;
	}

	public Set<PerfilDTO> getPerfis() {
		return perfis;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public PostoDTO getPosto() {
		return posto;
	}

	public void setPosto(PostoDTO posto) {
		this.posto = posto;
	}

	public OMDTO getOm() {
		return om;
	}

	public void setOm(OMDTO om) {
		this.om = om;
	}
}
