package jbq.entrevista.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import jbq.entrevista.dao.DAOCliente;
import jbq.entrevista.dao.DAOOrdemServico;
import jbq.entrevista.dao.DAOServico;
import jbq.entrevista.entity.Cliente;
import jbq.entrevista.entity.OrdemServico;
import jbq.entrevista.entity.Servico;

@Controller
public class OrdemServicoController {
	
	@Autowired
	private DAOCliente daoCliente;
	@Autowired
	private DAOServico daoServico;
	@Autowired
	private DAOOrdemServico daoOrdemServico;
	
	private List<Servico> servicos;
	  
	
	@RequestMapping("ordem/listar")
	public String listar(Map<String, Object> model){
		model.put("ordens", daoOrdemServico.list(0, 20));
		return "ordem/listar";
	}
	
	@RequestMapping("ordem/ordens-cliente/{id}")
	public String listarPorCliente(Map<String, Object> model, @PathVariable("id") Long id){
		Cliente cliente = daoCliente.get(id);
		model.put("ordens", daoOrdemServico.getOrdensByCliente(cliente));
		return "ordem/listar";
	}
	
	@RequestMapping("ordem/cadastro")
	public String cadastro(Map<String, Object> model){

		if(model.get("ordemServico") == null){
		   OrdemServico os = new OrdemServico();		   
		   model.put("ordemServico", os);
		}
		model.put("clientes", daoCliente.list(0, 500));
		model.put("servicos", daoServico.list(0, 500));

		return "ordem/cadastro";
	}
	
	@RequestMapping("ordem/visualizar/{id}")
	public String visualizar(@PathVariable("id") Long id, Map<String, Object> model){
		
		model.put("ordemServico", daoOrdemServico.get(id));
		
		return "ordem/visualizar";
	}
	
	@RequestMapping(value="ordem/incluir",method=RequestMethod.POST)
	public String incluir(@Valid OrdemServico ordemServico, BindingResult result, HttpSession sessao){
		System.out.println(ordemServico.getServico());
		daoOrdemServico.persistir(ordemServico);
		return "redirect:listar";
	}
	
	@RequestMapping(value="ordem/finalizar",method=RequestMethod.POST)
	public String finalizar(@Valid OrdemServico ordemServico, BindingResult result, HttpSession sessao){		
		daoOrdemServico.persistir(ordemServico);
		return "redirect:listar";
	}
	
	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}


}
