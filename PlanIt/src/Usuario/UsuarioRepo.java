package Usuario;
import java.util.*;
public class UsuarioRepo {
	private UsuarioDAO usuarios;
	private List<Usuario> listaUsuario = usuarios.obterTodosUsuarios();
	
	
	public UsuarioRepo() {
		usuarios = new UsuarioDAO();
	}
	
	public void addUsuario(Usuario usuario) {
		usuarios.criarFuncionario(usuario);
	}
	
	public Usuario getUsuarioById(int id) {
		return usuarios.obterUsuario(id);
	}
	
	public void updateUsuario(Usuario updateUsuario) {
		for (Usuario usuario : listaUsuario) {
            if (usuario.getId() == updateUsuario.getId()) {
                usuario.setNome(updateUsuario.getNome());
                usuario.setEmail(updateUsuario.getEmail());
                break;
            }
        }
	}
	
	public void deleteUsuario(int id) {
		listaUsuario.removeIf(usuario -> usuario.getId() == id);
	}
	
	public void showUsuarios() {
		for( Usuario usuario : listaUsuario) {
			usuario.printUsuario();
		}
	}
}
