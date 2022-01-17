package org.serratec.backend.apiRestfulG5.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente", schema = "public")

public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cliente;
	
	@Column(name = "nome", length = 60, nullable = false)
	private String nome_cliente;
	
	@Column(name = "usuario", length = 20, nullable = false)
	private String nome_usuario;
	
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "senha", length = 255, nullable = false)
	private String senha;

	@Column(name = "cpf", length = 15, unique = true, nullable = false)
	private String cpf;
	
	@Column(name = "data_nasc", nullable = false)
	private LocalDate dataNasc;
	
	@Column(name = "telefone", length = 11, nullable = false)
	private String telefone;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedido;

	
	//Ta dando ruim aqui
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	
	public Cliente() {
		super();
	}

	

	public Integer getId_cliente() {
		return id_cliente;
	}
	
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, id_cliente, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id_cliente, other.id_cliente)
				&& Objects.equals(telefone, other.telefone);
	}


	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nome_cliente=" + nome_cliente + ", nome_usuario=" + nome_usuario
				+ ", email=" + email + ", senha=" + senha + ", cpf=" + cpf + ", dataNasc=" + dataNasc + ", telefone="
				+ telefone + ", pedido=" + pedido + ", endereco=" + endereco + "]";
	}
	
	

	
	
}

