package jbq.entrevista.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jbq.entrevista.dao.DAOServico;
import jbq.entrevista.entity.Servico;

@Primary
@Component
public class EMServico extends EMDAO<Servico> implements DAOServico {

	@Override
	protected Class getClazz() {
		return Servico.class;
	}

}
