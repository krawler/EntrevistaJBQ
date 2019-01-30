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
@RequestMapping("api/servico")
public class ServicoResource {
	
	@Autowired
	private DAOServico daoServico;
	@Autowired 
	private DAOCliente daoCliente;
	@Autowired
	private DAOOrdemServico daoOrdemServico;

	@RequestMapping(value="/listall",method=RequestMethod.GET,produces="application/json")
	public List<Servico> servicos(){
		List<Servico> retorno = new ArrayList<Servico>();
		retorno = daoServico.listAll(); 
		return retorno;		
	}
	
	@RequestMapping(value="/listwith/{nome}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody List<Servico> listarPorNome(@PathParam(value="nome") String nome) throws Exception{
		List<Servico> retorno = new ArrayList<Servico>();
		retorno = daoServico.list("descricao", nome); 
		return retorno;		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json")
	public String addServico(jbq.entrevista.dto.Servico servico){		
		daoServico.persistir(servico.toEntity(servico)); 
		return "serviço adicionado com sucesso";		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET,produces="application/json")
	public String updateServico(jbq.entrevista.dto.Servico servico){
		daoServico.persistir(servico.toEntity(servico)); 
		return "serviço atualizado com sucesso";		
	}
		
	
	@RequestMapping(value="/delete/{id}")
	public String deleteServico(@PathVariable("id") Long id){
		Servico servico = daoServico.get(id);
		daoServico.excluir(servico);
		return "serviço excluido com sucesso";
	}
	
}
