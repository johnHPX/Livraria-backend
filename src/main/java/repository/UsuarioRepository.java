package repository;

import model.Usuario;

import java.util.ArrayList;
import java.util.LinkedList;

public class UsuarioRepository {

    public void criarUsuario(Usuario novoUsuario){

    }

    public void criarVariosUsuarios(ArrayList<Usuario> usuarios){
        for (Usuario usuario : usuarios){
            this.criarUsuario(usuario);
        }
    }



}
