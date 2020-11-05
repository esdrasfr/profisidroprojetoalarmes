package br.com.isidrocorp.dashboard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.dashboard.dao.UsuarioDAO;
import br.com.isidrocorp.dashboard.model.Usuario;

@CrossOrigin("*")
@RestController
public class UsuarioController {

	/* A anotação Autowired indica a injeção da dependência da interface UsuarioDAO no meu Controller
	 * O que significa isso? Que nós programadores não precisamos nos preocupar com 2 coisas
	 * 	 - quem vai instanciar o objeto que implementa esta interface
	 *   - se este objeto não existir, a Máquina Vitural cria uma implementação em tempo de execução
	 *     para suprir essa necessidade
	 */
	@Autowired
	private UsuarioDAO dao; // este é o objeto que irá manipular o Banco de Dados
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> recuperaTodoMundo(){
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
	}
	
	/*
	 * este método logaUsuário recebe um objeto do tipo Usuario apenas com racf e senha preenchidos
	 * A partir daí, podemos recuperar do banco com esses dados e retornar o objeto correspondente
	 * 
	 * só que para isso, nosso endpoint tem que ser do tipo @PostMapping
	 */
	@PostMapping("/login")
	public ResponseEntity<Usuario> logarUsuario(@RequestBody Usuario dadosLogin) {
		Usuario resultado = dao.findByRacfOrEmail(dadosLogin.getRacf(), dadosLogin.getEmail());
		if (resultado != null) { // o usuario existe!!
			if (resultado.getSenha().equals(dadosLogin.getSenha())) {  // senha confere
				return ResponseEntity.ok(resultado); // retorno 200 ok e o objeto no corpo da resposta
			}
			else {
				return ResponseEntity.status(401).build();
			}
		}
		else {  // usuario não foi encontrado no banco
			return ResponseEntity.notFound().build(); // equivale ao status(404).build()
		}
	}
}







