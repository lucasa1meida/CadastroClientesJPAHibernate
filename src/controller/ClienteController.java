package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entity.Cliente;
import persistence.ClienteDao;

@Controller	
public class ClienteController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("sistema");
		mv.addObject("lista", new ClienteDao().findAll());
		return mv;
	}
	
	@RequestMapping(value="/gravar", method = RequestMethod.POST)
	public ModelAndView gravar(@RequestParam("nomeCliente") String nomeCliente, @RequestParam("dataNascimento") String dataNascimento, 
			@RequestParam("emailCliente") String emailCliente, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("sistema");
		ClienteDao dao = new ClienteDao();
		try {
			Cliente c = new Cliente(null,nomeCliente,dataNascimento,emailCliente);			
			dao.create(c);
			mv.addObject("lista", dao.findAll());
			response.sendRedirect("/prjCadastroClienteMVC/");
		}catch(Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			ex.printStackTrace();			
		}		
		return mv;
	}	
	
	@RequestMapping(value="/excluir/{idCliente}", method = RequestMethod.GET)
	public void excluir(@PathVariable Long idCliente, HttpServletResponse response) {
		ClienteDao dao = new ClienteDao();
		try {		
			Cliente c = dao.findById(idCliente);
			dao.delete(c);
			response.sendRedirect("/prjCadastroClienteMVC/");			
		}catch(Exception ex){
			System.out.println("Erro: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	
}
