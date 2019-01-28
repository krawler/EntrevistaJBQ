package jbq.entrevista.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ebdes.desafiolecom.dao.DAOServico;
import br.com.ebdes.desafiolecom.entidades.Cliente;
import br.com.ebdes.desafiolecom.entidades.Servico;

@RequestMapping("/servico")
@Controller
public class ServicoController {
	
	@Autowired
	private DAOServico daoServico;

	@RequestMapping("/listar")
	public ModelAndView listar(){
		return new ModelAndView("servico/listar")
				.addObject("servicos", daoServico.list(0, 20))
				.addObject("servico", new Servico());		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/incluir")
	public String incluir(@Valid Servico servico){
		daoServico.persistir(servico);
		return "redirect:listar";
	}
	
	@RequestMapping(value="/excluir/{id}")
	public String excluir(@PathVariable("id") Long id){
		Servico servico = daoServico.get(id);
		daoServico.excluir(servico);
		return "redirect:listar";
	}
}
