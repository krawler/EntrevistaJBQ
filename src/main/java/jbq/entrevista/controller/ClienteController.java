package jbq.entrevista.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbq.entrevista.dao.DAOCliente;
import jbq.entrevista.dto.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private static Logger logger = Logger.getLogger("ClienteController");
	
	@Autowired
	private DAOCliente daoCliente;
	
	@RequestMapping("/listar")
	public ModelAndView listar(){
		return new ModelAndView("cliente/listar")
					.addObject("clientes", daoCliente.list(0, 20));
	}
	
	@RequestMapping("/cadastro")
	public ModelAndView cadastro(){
		ModelAndView mav = new ModelAndView("cliente/cadastro");
		mav.getModel().put("cliente", new jbq.entrevista.entity.Cliente());
		mav.getModel().put("campo", "");
		return mav;
	}
	
	@RequestMapping("/cadastro/{id}")
	public ModelAndView cadastro(@PathVariable("id") Long id){
		ModelAndView mav =  new ModelAndView();
		mav.getModel().put("cliente", daoCliente.get(id));
		mav.setViewName("cliente/cadastro");
		return mav;
	}
	
	@RequestMapping(value="/incluir", method=RequestMethod.POST)
	public String incluir(Cliente cliente, String campo){
		daoCliente.persistir(cliente.toEntity(cliente));
		return "redirect:listar";
	}
	
	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable("id") Long id){
	 	jbq.entrevista.entity.Cliente cliente = daoCliente.get(id);
		daoCliente.excluir(cliente);
		return "redirect:../listar";
	}
	
	
	

}
