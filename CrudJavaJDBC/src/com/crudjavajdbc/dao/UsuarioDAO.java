package com.crudjavajdbc.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjavajdbc.database.ConnectionDatabase;
import com.crudjavajdbc.model.Usuario;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDAO {
	
	//Adiciona um usuario ao banco
	public void create(Usuario user){
		//Query que será executada 
		String sql = "INSERT INTO usuario (NOME,EMAIL,SENHA) VALUES (?, ? ,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			//Cria conexão
			conn = ConnectionDatabase.CreateConnection();
			
			//Prepara a query
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			
			//Atribui os valores para cada '?'
			psmt.setString(1, user.getNome());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getSenha());
			
			//Executar query
			psmt.execute();
			System.out.println("Usuario inserido com sucesso!");
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Lista todos os usuarios presentes no banco
	public List<Usuario> read(){
		//Query que será executada 
		String sql = "SELECT * FROM usuario";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		
		//Cria uma lista de usuarios
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			//Cria conexão
			conn = ConnectionDatabase.CreateConnection();
			
			//Prepara a query
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			
			//Executar query
			res = psmt.executeQuery();
			
			//Vai passando de linha em linha
			while(res.next()) {
				//Cria um objeto usuário
				Usuario usuario = new Usuario();
				
				//Pega os valores de cada coluna do banco e atribui para o usuário
				usuario.setId(res.getInt("ID"));
				usuario.setNome(res.getString("NOME"));
				usuario.setEmail(res.getString("EMAIL"));
				usuario.setSenha(res.getString("SENHA"));
				
				//Adiciona usuario atual na lista de Usuarios
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	//Atualiza dados do usuários
	public void update(Usuario user) {

		String sql = "UPDATE `usuario` SET NOME=?,EMAIL=?,SENHA=? WHERE ID=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		
		try {
			//Cria conexão
			conn = ConnectionDatabase.CreateConnection();
			
			//Prepara a query
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			
			//Atribui os valores para cada '?'
			psmt.setString(1, user.getNome());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getSenha());
			psmt.setInt(4, user.getId());
			
			//Executar query
			psmt.execute();
			System.out.println("Usuario atualizado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	//Deletar um usuario
	public void delete(int id) {
		String sql = "DELETE FROM `usuario` WHERE ID=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			//Cria conexão
			conn = ConnectionDatabase.CreateConnection();
			
			//Prepara a query
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			
			//Atribui os valores para cada '?'
			psmt.setInt(1, id);
			
			//Executar query
			psmt.execute();
			System.out.println("Usuario excluido com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
