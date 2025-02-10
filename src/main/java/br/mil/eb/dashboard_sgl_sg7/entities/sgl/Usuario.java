package br.mil.eb.dashboard_sgl_sg7.entities.sgl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Usuário do sistema; técnico que usa o sistema; administrador.
 * <p>
 * Este usuário pode ser um militar ou um civil. Os dados básicos e comuns entre
 * os tipos são todos com exceção de "nomeGuerra", "brigada", "om" e "posto". O
 * militar não possui a informação "instituicao".
 */
@Entity
@Table(name = "sad2_usuarios")
public class Usuario implements Serializable, UserDetails {
	private static final long serialVersionUID = -6920465369405277436L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomecompleto;
	private String username;
	private String password;
	//Militar ou Civil
	private String tipo;
	private String cpf;
	private String identidade;
	private String nomeguerra;
	private String telefone;
	private String email;
	private String organizacao;

	private boolean habilitado;

	@Column(name = "registro_completo")
	private boolean registroCompleto;

	// Apenas para militares
	@ManyToOne
	@JoinColumn(name = "postograduacao")
	private Posto posto;

	// Apenas para militares
	@ManyToOne
	@JoinColumn(name = "id_om")
	private OM om;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "sad2_tb_perfil_usuario", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
	private Set<Perfil> perfis = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
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

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	public OM getOm() {
		return om;
	}

	public void setOm(OM om) {
		this.om = om;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return perfis.stream().map(perfil -> new SimpleGrantedAuthority(perfil.getAutorizacao()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public boolean isRegistroCompleto() {
		return registroCompleto;
	}

	public void setRegistroCompleto(boolean registroCompleto) {
		this.registroCompleto = registroCompleto;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return habilitado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
}