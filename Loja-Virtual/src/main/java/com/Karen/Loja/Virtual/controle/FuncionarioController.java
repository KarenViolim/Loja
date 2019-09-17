package com.Karen.Loja.Virtual.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Karen.Loja.Virtual.modelos.Funcionario;
import com.Karen.Loja.Virtual.repositorios.CidadeRepository;
import com.Karen.Loja.Virtual.repositorios.FuncionarioRepository;

@Controller
public class FuncionarioController {
	@Autowired
	private FuncionarioRepository repositoryFuncionario;
	
	@Autowired
	public CidadeRepository repositoryCidade;
	
	@GetMapping("/administrativo/funcionarios/cadastrar")
	public ModelAndView add(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("/adiministrativo/funcionarios/cadastro");
		mv.addObject("funcionario", funcionario);
		mv.addObject("cidades", repositoryCidade.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/funcionarios/listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/funcionarios/lista");
		mv.addObject("funcionario", repositoryFuncionario.findAll());
		return mv;
	}
	
	@GetMapping("/adminsitrativo/funcionarios/editarFuncionario/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Funcionario> op = repositoryFuncionario.findById(id);
		Funcionario func = op.get();
		return add(func);
	}
	
	@GetMapping("/administrativo/funcionarios/removerFuncionario/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Funcionario> op = repositoryFuncionario.findById(id);
		Funcionario func = op.get();
		repositoryFuncionario.delete(func);
		return listar();
	}
	
	@PostMapping("/administrativo/funcionarios/salvarFuncionario")
	public ModelAndView salvar(Funcionario funcionario) {
		repositoryFuncionario.save(funcionario);
		return listar();
	}

}

