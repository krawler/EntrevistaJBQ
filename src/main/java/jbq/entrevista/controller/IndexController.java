package jbq.entrevista.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jbq.entrevista.dao.DAOOrdemServico;

@Controller
public class IndexController {
	
	private static Logger logger = Logger.getLogger("IndexController");
	
	@Autowired
	private DAOOrdemServico daoOrdemServico;
	
	@RequestMapping("/")
	public ModelAndView index(){
		System.out.println("Esse index controller");		
		return new ModelAndView("index")
					.addObject("ordens", daoOrdemServico.list(0,20));
	}
}
