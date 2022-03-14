package com.crudjavajdbc.database;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {
	
	private static String Username = "root";
	private static String senha = "";
	private static String DatabasePATH = "jdbc:mysql://localhost:3306/crudjavajdbc";
	
	public static Connection CreateConnection() throws Exception{
		
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(DatabasePATH, Username, senha);
			System.out.println("Conexão bem sucedida!");
		} catch (Exception e) {
			System.out.println("Erro ao conectar-se ao banco de dados\nCAUSE OF ERROR: "+e);
		}
		return conexao;
		
	}
}
