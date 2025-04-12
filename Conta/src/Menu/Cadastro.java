package Menu;

public class Cadastro {
    private String usuario;
    private String senha;
    private Boolean verificado;

    public Cadastro() {
        this.usuario = usuario;
        this.senha = senha;
        this.verificado = verificado;
    }

    public Cadastro(String usuario, String senha, boolean verificado) {
        this.usuario = usuario;
        this.senha = senha;
         this.verificado = verificado;
    }

    @Override
    public String toString() {
        String informacao = "==============================================\n";
        informacao += String.format("Seja Bem-Vindo: %s", this.usuario + "!\n");
        return informacao;
    }

    // getters e setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

}
