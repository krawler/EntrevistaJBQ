package jbq.entrevista.entity;

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
public class OrdemServico {
	
	@Id @Column @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Servico servico;
	@Temporal(value=TemporalType.DATE)
	private Date dataInicio;
	@Temporal(value=TemporalType.DATE)
	private Date dataFim;
	@Transient
	private Integer diasRestantes;

	public OrdemServico(){
	}

	public OrdemServico(Long id, Cliente cliente, Servico servico,
			Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.servico = servico;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public Integer getDiasRestantes() {
	
		Calendar data1 = Calendar.getInstance(); 
		Calendar data2 = Calendar.getInstance();
		data1.setTime(new Date()); 
		data2.setTime(getDataFim());  
		 
		return data2.get(Calendar.DAY_OF_YEAR) - data1.get(Calendar.DAY_OF_YEAR);
	}
	
	public void setDiasRestantes(Integer diasRestantes){
		this.diasRestantes = diasRestantes;
	}
}
