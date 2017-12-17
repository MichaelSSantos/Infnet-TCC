package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Professor;
import infnet.sisam.model.Turma;
import infnet.sisam.service.ProfessorService;
import infnet.sisam.service.TurmaService;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		List<Turma> turmas = turmaService.listar();
		List<Professor> professores = professorService.listar();
		ModelAndView modelAndView = new ModelAndView("turmas/novo");
		modelAndView.addObject("turmas",turmas);
		modelAndView.addObject("professores",professores);
		return modelAndView;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView gravar(Turma turma, RedirectAttributes redirectAttributes) {
		turmaService.salvar(turma);
		redirectAttributes.addFlashAttribute("sucesso", "Novo turma incluída.");
		return new ModelAndView("redirect:/turmas");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Turma> turmas = turmaService.listar();
		ModelAndView modelAndView = new ModelAndView("turmas/lista");
		modelAndView.addObject("turmas", turmas);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Turma turma, RedirectAttributes redirectAttributes) {
		turmaService.atualizar(turma);
		redirectAttributes.addFlashAttribute("sucesso", "Atualização bem sucedida");
		return new ModelAndView("redirect:/turmas");
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("turmas/detalhe");
		Turma turma = turmaService.buscar(id);
		List<Professor> professores = professorService.listar();
		modelAndView.addObject("turma", turma);
		modelAndView.addObject("professores",professores);
		return modelAndView;
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		turmaService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Remoção bem sucedida.");
		return new ModelAndView("redirect:/turmas");
	}
	
}