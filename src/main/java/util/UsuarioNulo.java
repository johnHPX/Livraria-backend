package util;

public class UsuarioNulo extends Exception{
    public UsuarioNulo(){
      super("O objeto Usuario não pode ser nulo: ");
    }
}
