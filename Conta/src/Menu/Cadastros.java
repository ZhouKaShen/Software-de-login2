package Menu;

import java.util.ArrayList;

public class Cadastros {
    private ArrayList<Cadastro> cadastros;

    public Cadastros() {
        cadastros = new ArrayList<>();
    }

    public void adicionar(Cadastro novoCadastro) {
        cadastros.add(novoCadastro);
    }

    public String logar(String usuario, String senha) {
        for (Cadastro registro : cadastros) {
            if (registro.getUsuario().equals(usuario) && registro.getSenha().equals(senha)) {
                String informacao = registro.toString();
                return informacao;
            }
        }
        String erro = "==============================================\n";
        return erro + "Login ou senha incorreto.\nTente novamente mais tarde.";
    }
}
