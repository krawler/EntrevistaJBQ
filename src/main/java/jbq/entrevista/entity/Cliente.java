package jbq.entrevista.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import jbq.entrevista.enuns.Sexo;


@XmlRootElement
@Entity
public class Cliente implements java.io.Serializable{
	
	private static final long serialVersionUID = 802306592684710650L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column @NotNull
	private String nome;
	@Column
	private String endereco;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dataNasc;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	private List<OrdemServico> ordens;
	@Column
	private Sexo sexo;
	@Column
	private String telefone;
	
	public Cliente(){
		
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
	
	public List<OrdemServico> getOrdens() {
		return ordens;
	}

	public void setOrdens(List<OrdemServico> ordens) {
		this.ordens = ordens;
	}


}
