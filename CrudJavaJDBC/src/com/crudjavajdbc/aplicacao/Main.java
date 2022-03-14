package com.crudjavajdbc.aplicacao;

import java.util.Iterator;

import com.crudjavajdbc.dao.UsuarioDAO;
import com.crudjavajdbc.model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		//CREATE
		Usuario user = new Usuario();
		user.setNome("Joao");
		user.setEmail("joao@joao.com");
		user.setSenha("1234");
		
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.create(user);//
		
		//READ
		for (Usuario u: userDAO.read()) {
			System.out.println("======================");
			System.out.println("Usuario:"+u.getNome());	
		}
		
		//UPDATE 
		
		/**/
		Usuario u1 = new Usuario();
		u1.setNome("Joao");
		u1.setEmail("joao123@joao.com");
		u1.setSenha("jao123");
		u1.setId(2);
		
		UsuarioDAO u1DAO = new UsuarioDAO();
		u1DAO.update(u1);
		
		
		//DELETE
		userDAO.delete(2);
		
	}
}
