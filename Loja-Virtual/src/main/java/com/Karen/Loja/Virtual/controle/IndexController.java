package com.Karen.Loja.Virtual.controle;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

	@GetMapping("/administrativo")
	public String acessarPrincipal() {
		return "administrativo/home";
	}
}
