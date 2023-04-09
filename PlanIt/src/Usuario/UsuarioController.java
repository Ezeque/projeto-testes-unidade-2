package Usuario;

import java.util.List;

public class UsuarioController {
    private UsuarioDAO usuarios;
	private List<Usuario> listaUsuario;

    public UsuarioController() {
    	usuarios = new UsuarioDAO();
		listaUsuario = usuarios.obterTodosUsuarios();
    }

    public void createUser(Usuario usuario) {
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

    public Usuario getUserById(int id) {
    	return usuarios.obterUsuario(id);
    }
    
    public Usuario getUserByEmail(String email) {
    	return usuarios.obterUsuarioEmail(email);
    }

    public void updateUser(Usuario updatedUser) {
    	usuarios.updateUsuario(updatedUser);
    }

    public void deleteUser(Usuario usuario) {
    	if(usuarios.deleteUsuario(usuario)) {
			System.out.println(" Usuário deletado com sucesso!");
		}
		else {
			System.out.println("Não foi possível deletar o usuário!");
		}
    }
    
    public void show() {
    	for( Usuario usuario : listaUsuario) {
			usuario.printUsuario();
		}
    }
    
    
}
