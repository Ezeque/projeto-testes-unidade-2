package Main;


import java.util.*;

import Usuario.*;

public class Main {
	public static void main(String args[]) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Crie um usuário");
		
		System.out.println("Insira o email: ");
		String email = scanner.nextLine();
		
		System.out.println("Insira sua senha: ");
		String senha = scanner.nextLine();
		
		//criando usuario
		Usuario usuario = new Usuario();
		
		//adiciona o usuario ao banco
		UsuarioController controlador = new UsuarioController();
		controlador.createUser(usuario);
		
		//mostra os usuarios
		System.out.println("Lista de usuários: ");
		controlador.show();
		
		//fecha scanner
		scanner.close();
		
		
		
	}
}
