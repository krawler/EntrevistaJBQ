package jbq.entrevista.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import jbq.entrevista.dao.DAOOrdemServico;
import jbq.entrevista.entity.Cliente;
import jbq.entrevista.entity.OrdemServico;

@Primary
@Repository
public class EMOrdemServico extends EMDAO<OrdemServico> implements DAOOrdemServico {

	@Override
	protected Class getClazz() {
		return OrdemServico.class;
	}
	
	@Override
	public OrdemServico get(Long id){
		OrdemServico os = super.get(id);
		os.getCliente().getNome();
		return os;
	}
	
	public List<OrdemServico> getOrdensNaoFinalizadas() {
		return getEntityManager()
				.createQuery("from OrdemServico where dataFinal is null")
				.getResultList();
	}

	public List<OrdemServico> getOrdensByCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
