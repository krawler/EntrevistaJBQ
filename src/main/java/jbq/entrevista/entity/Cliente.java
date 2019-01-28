package jbq.entrevista.entity;

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
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class Cliente implements java.io.Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	@Column
	private String endereco;
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	private List<OrdemServico> ordens;
	
	public Cliente(){
		
	}

	public Cliente(Long id, String nome, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
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
