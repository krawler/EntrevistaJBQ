package jbq.entrevista.dto;

import java.util.List;

import jbq.entrevista.entity.OrdemServico;

public class Servico {
	
	private Long id;
	
	private String descricao;
	
	private List<OrdemServico> ordens;	
	
	public Servico() {
		super();		
	}

	public Servico(Long id, String descricao, List<OrdemServico> ordens) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ordens = ordens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<OrdemServico> getOrdens() {
		return ordens;
	}

	public void setOrdens(List<OrdemServico> ordens) {
		this.ordens = ordens;
	}

	@Override
	public String toString() {
		return "Servico [id=" + id + ", descricao=" + descricao + ", ordens=" + ordens + "]";
	}		
	
	public Servico toDTO(jbq.entrevista.entity.Servico servico) {
		return new Servico(servico.getId(), servico.getDescricao(), servico.getOrdens());
	}
	
	public jbq.entrevista.entity.Servico toEntity(Servico servico){
		return new jbq.entrevista.entity.Servico(servico.getId(), servico.getDescricao());
	}
	
}
