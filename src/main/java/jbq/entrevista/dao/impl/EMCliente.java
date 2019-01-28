package jbq.entrevista.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jbq.entrevista.dao.DAOCliente;
import jbq.entrevista.entity.Cliente;

@Primary
@Component
public class EMCliente extends EMDAO<Cliente> implements DAOCliente {

	@Override
	protected Class getClazz() {
		return Cliente.class;
	}	
}
