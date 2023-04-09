package Usuario;
import java.util.*;
public class UsuarioRepo {
	private UsuarioDAO usuarios;
	private List<Usuario> listaUsuario;
	
	
	public UsuarioRepo() {
		usuarios = new UsuarioDAO();
		listaUsuario = usuarios.obterTodosUsuarios();
	}
	
	public void addUsuario(Usuario usuario) {
		if( usuarios.emailEmUso(usuario) ) {
			System.out.println("Este email já foi cadastrado!");
		}
		else if (usuarios.criarFuncionario(usuario) == false) {
			System.out.println("Este usuário já existe!");
		}
		else {
			System.out.println("Usuário criado com sucesso!");
		}
	}
	
	public Usuario getUsuarioById(int id) {
		return usuarios.obterUsuario(id);
	}
	
	public Usuario getUsuarioByEmail(String email) {
		return usuarios.obterUsuarioEmail(email);
	}
	
	public void updateUsuario(Usuario updateUsuario) {
		usuarios.updateUsuario(updateUsuario);
	}
	
	public void deleteUsuario(Usuario usuario) {
		if(usuarios.deleteUsuario(usuario)) {
			System.out.println(" Usuário deletado com sucesso!");
		}
		else {
			System.out.println("Não foi possível deletar o usuário!");
		}
		
	}
	
	public void showUsuarios() {
		for( Usuario usuario : listaUsuario) {
			usuario.printUsuario();
		}
	}
}
