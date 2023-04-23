package Usuario;

import db.DBConnection;
import db.DBDriver;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	 Connection con;

	    public UsuarioDAO() {
	        if (con == null) {
	            con = new DBConnection().getConnection(DBDriver.MYSQL, "planit", "root", "");
	        }
	    }
	    
	    public boolean criarFuncionario(Usuario usuario) {
	        if(existe(usuario)){
	            return false;
	        } else {
	            String nf = "INSERT INTO usuario (nome, email, senha, id) VALUES (?,?,?,?)";
	            PreparedStatement pst;
	            try {
	                pst = con.prepareStatement(nf);
	                pst.setString(1, usuario.getNome());
	                pst.setString(2, usuario.getEmail());
	                pst.setString(3, usuario.getSenha());
	                pst.setInt(4, usuario.getId());
	                int res = pst.executeUpdate();
	                if (res == 1) {
	                    return true;
	                }
	            } catch (SQLException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return false;
	    }
	    
	    public boolean existe(Usuario usuario) {
	        try {
	            String existe = "SELECT id FROM usuario WHERE id = ?";
	            PreparedStatement pst = con.prepareStatement(existe);
	            pst.setInt(1, usuario.getId());
	            ResultSet res = pst.executeQuery();
	            if (res.next()) {
	                if (res.getLong("id") == usuario.getId()) {
	                    return true;
	                }
	            }
	        } catch (SQLException ex) {
	            throw new RuntimeException(ex);
	        }
	        return false;
	    }
	    
	    public boolean emailEmUso(Usuario usuario) {
	        try {
	            String emailEmUso = "SELECT email FROM usuario WHERE email = ?";
	            PreparedStatement pst = con.prepareStatement(emailEmUso);
	            pst.setString(1, usuario.getEmail());
	            ResultSet res = pst.executeQuery();
	            if (res.next()) {
	                if ( res.getString("email").equals(usuario.getEmail()) ) {
	                    return true;
	                }
	            }
	        } catch (SQLException ex) {
	            throw new RuntimeException(ex);
	        }
	        return false;
	    }
	    
	       public ArrayList<Usuario> obterTodosUsuarios() {          
	               String todos = "SELECT * FROM usuario";           
	               PreparedStatement ps;                             
	               ArrayList<Usuario> usuarios = new ArrayList<>();  
	               try {                                             
	                   ps = con.prepareStatement(todos);             
	                   ResultSet rs = ps.executeQuery();             
	                   while (rs.next()) {                           
	                       Usuario a = new Usuario();                
	                       a.setNome(rs.getString("nome"));          
	                       a.setEmail(rs.getString("email"));        
	                       a.setSenha(rs.getString("senha"));        
	                       a.setId(rs.getInt("id"));                 
	                       usuarios.add(a);                          
	                   }                                             
	                                                                 
	               } catch (SQLException ex) {                       
	                   throw new RuntimeException(ex);               
	               }                                                 
	                                                                 
	               return usuarios;                              
	           }        
	       
	       
	       
	      public Usuario obterUsuario(int id) {               
	              String usuario = "SELECT * FROM usuario";        

	              PreparedStatement ps;                                  
	                
	              try {                                                  
	                  ps = con.prepareStatement(usuario);                  
	                  ResultSet rs = ps.executeQuery();    
	                  while (rs.next()) {                                
	                      Usuario a = new Usuario();                     
	                      a.setNome(rs.getString("nome"));               
	                      a.setEmail(rs.getString("email"));             
	                      a.setSenha(rs.getString("senha"));             
	                      a.setId(rs.getInt("id")); 
	                      if(a.getId() == id) {
	                    	  return a;
	                      }
	                     
	                  }                                                  
	                                                                     
	              } catch (SQLException ex) {                            
	                  throw new RuntimeException(ex);                    
	              }                                                      
	                                                                     
	              return null;                                       
	          }   
	      
	      public Usuario obterUsuarioEmail(String email) {   	    	  
	    	  
              String usuario = "SELECT * FROM usuario";        

              PreparedStatement ps;                                  
                
              try {                                                  
                  ps = con.prepareStatement(usuario);                  
                  ResultSet rs = ps.executeQuery();    
                  while (rs.next()) {                                
                      Usuario a = new Usuario();                     
                      a.setNome(rs.getString("nome"));               
                      a.setEmail(rs.getString("email"));             
                      a.setSenha(rs.getString("senha"));             
                      a.setId(rs.getInt("id")); 
                      if(a.getEmail().equals(email)) {
                    	  return a;
                      }
                     
                  }                                                  
                                                                     
              } catch (SQLException ex) {                            
                  throw new RuntimeException(ex);                    
              }                                                      
                                                                    
              return null;                                    
          }  
	       
	       
	      public boolean updateUsuario(Usuario usuario) {
	          String string = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
	          PreparedStatement pst;
	          try {
	              pst = con.prepareStatement(string);
	              pst.setString(1, usuario.getNome());
	              pst.setString(2, usuario.getEmail());
	              pst.setString(3, usuario.getSenha());
	              pst.setInt(4, usuario.getId());
	              int res = pst.executeUpdate();
	              if(res == 1){
	                  return true;
	              }
	          } catch (SQLException e) {
	              throw new RuntimeException(e);
	          }
	          return false;
	      }
	      
	      public boolean deleteUsuario(Usuario usuario) {
	          String string = "DELETE FROM usuario WHERE id = ?";
	          PreparedStatement pst;
	          try {
	              pst = con.prepareStatement(string);
	              pst.setInt(1, usuario.getId());
	              int res = pst.executeUpdate();
	              if(res == 1){
	                  return true;
	              }
	          } catch (SQLException e) {
	              throw new RuntimeException(e);
	          }
	          return false;
	      }
	       
	       
	       
	       
	       

}          
               
        
               
               
               
               
        
        
        
        
        
           
               
               
               
               
               
               
               
        