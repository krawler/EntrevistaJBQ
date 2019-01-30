package jbq.entrevista.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import jbq.entrevista.entity.OrdemServico;
import jbq.entrevista.enuns.Sexo;

@XmlRootElement
public class Cliente {
		
	private Long id;
	
	private String nome;
	
	private String endereco;
	
	private Date dataNasc;
	
	private List<OrdemServico> ordens;
	
	private Sexo sexo;
	
	private String telefone;	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long id, String nome, String endereco, Date dataNasc, List<OrdemServico> ordens, Sexo sexo,
			String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.dataNasc = dataNasc;
		this.ordens = ordens;
		this.sexo = sexo;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public List<OrdemServico> getOrdens() {
		return ordens;
	}

	public void setOrdens(List<OrdemServico> ordens) {
		this.ordens = ordens;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", dataNasc=" + dataNasc
				+ ", ordens=" + ordens + ", sexo=" + sexo + ", telefone=" + telefone + "]";
	}
	
	public Cliente toDTO(jbq.entrevista.entity.Cliente cliente) {
		return new Cliente(cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getDataNasc(), 
							cliente.getOrdens(), cliente.getSexo(), cliente.getTelefone());
	}
	
	public jbq.entrevista.entity.Cliente toEntity(Cliente cliente){
		return new jbq.entrevista.entity.Cliente(cliente.getId(), cliente.getNome(), cliente.getEndereco(), cliente.getDataNasc(), 
												 cliente.getOrdens(), cliente.getSexo(), cliente.getTelefone());
	}
			
}
