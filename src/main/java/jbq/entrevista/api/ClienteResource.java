package jbq.entrevista.api;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jbq.entrevista.dao.DAOCliente;
import jbq.entrevista.dao.DAOOrdemServico;
import jbq.entrevista.dao.DAOServico;
import jbq.entrevista.entity.Cliente;
import jbq.entrevista.entity.OrdemServico;
import jbq.entrevista.entity.Servico;

@Controller
@RequestMapping("api/cliente")
public class ClienteResource {
	
	@Autowired
	private DAOServico daoServico;
	@Autowired 
	private DAOCliente daoCliente;
	@Autowired
	private DAOOrdemServico daoOrdemServico;

	@RequestMapping(value="/listall",method=RequestMethod.GET,produces="application/json")
	public List<Cliente> listClientes(){
		List<Cliente> retorno = new ArrayList<Cliente>();
		retorno = daoCliente.listAll(); 
		return retorno;		
	}
	
	@RequestMapping(value="/listwith/{nome}",method=RequestMethod.GET,produces="application/json")
	public List<Cliente> ClientePorNome(@PathParam(value="nome") String nome) throws Exception{
		List<Cliente> retorno = new ArrayList<Cliente>();
		retorno = daoCliente.list("nome", nome); 
		return retorno;		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json")
	public String addCliente(jbq.entrevista.dto.Cliente cliente){		
		daoCliente.persistir(cliente.toEntity(cliente)); 
		return "serviço adicionado com sucesso";		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces="application/json")
	public String updateCliente(jbq.entrevista.dto.Cliente cliente){
		daoCliente.persistir(cliente.toEntity(cliente)); 
		return "serviço atualizado com sucesso";		
	}
			
	@RequestMapping(value="/delete/{id}")
	public String deleteCliente(@PathVariable("id") Long id){
		Cliente cliente = daoCliente.get(id);
		daoCliente.excluir(cliente);
		return "Cliente excluido com sucesso";
	}
	
	@RequestMapping(value="/item/{id}")
	public Cliente Item(@PathVariable("id") Long id){
		Cliente cliente = daoCliente.get(id);		
		return cliente;
	}
	
}
