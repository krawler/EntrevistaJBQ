package jbq.entrevista.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.SessionAttributes;

@XmlRootElement
@Entity
public class OrdemServico implements Serializable {
	
	private static final long serialVersionUID = 7166566746379362785L;
	
	@Id @Column @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Servico servico;
	
	public OrdemServico(){
	}

	public OrdemServico(Long id, Cliente cliente, Servico servico) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.servico = servico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServicos(Servico servico) {
		this.servico = servico;
	}
	

}
