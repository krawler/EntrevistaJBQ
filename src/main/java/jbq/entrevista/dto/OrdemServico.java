package jbq.entrevista.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrdemServico {	
	
	private Long id;
	
	private Cliente cliente;
	
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

	@Override
	public String toString() {
		return "OrdemServico [id=" + id + ", cliente=" + cliente + ", servico=" + servico + "]";
	}
	
	public OrdemServico toDTO(jbq.entrevista.entity.OrdemServico servico) {
		return new OrdemServico(servico.getId(), 
								new Cliente().toDTO(servico.getCliente()), 
								new Servico().toDTO(servico.getServico()));
	}
	
	public jbq.entrevista.entity.OrdemServico toEntity(OrdemServico servico) {
		return new jbq.entrevista.entity.OrdemServico(servico.getId(), 
													  servico.getCliente().toEntity(servico.getCliente()), 
													  servico.getServico().toEntity(servico.getServico()));
	}

}
