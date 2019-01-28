package jbq.entrevista.dao;

import java.util.List;

import jbq.entrevista.entity.Cliente;
import jbq.entrevista.entity.OrdemServico;


public interface DAOOrdemServico extends DAOBase<OrdemServico> {

	List<OrdemServico> getOrdensByCliente(Cliente cliente);

	List<OrdemServico> getOrdensNaoFinalizadas();
	
}
