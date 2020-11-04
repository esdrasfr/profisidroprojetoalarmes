package br.com.isidrocorp.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.dashboard.model.Usuario;

/* a interface CrudRepository é parametrizada com 2 valores:
 *  1 - A Classe do objeto que irá receber as operações de manipulação do banco
 *  2 - A classe que representa o tipo correspondente à chave primária (neste caso, Integer)
 *  
 *  a interface UsuarioDAO automaticamente herda estas funcionalidades básicas de CRUD da
 *  CrudRepository e nesta declaração apenas criamos coisas específicas (ex: login por racf)
 */
public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

	public Usuario findByRacfAndSenha(String racf, String senha);
	public Usuario findByRacfOrEmail(String racf, String email);
}
