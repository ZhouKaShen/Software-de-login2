package Menu;

public class Cadastro {
    private String usuario;
    private String senha;
    private Boolean leitura;
    private Boolean exclusao;
    private Boolean execucao;

    public Cadastro() {
        this.usuario = usuario;
        this.senha = senha;
        this.leitura = false;
        this.exclusao = false;
        this.execucao = false;
    }

    public Cadastro(String usuario, String senha, boolean leitura, boolean exclusao, boolean execucao) {
        this.usuario = usuario;
        this.senha = senha;
         this.leitura = leitura;
        this.exclusao = exclusao;
        this.execucao = execucao;
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

    public Boolean isLeitura() {
        return leitura;
    }

    public void setLeitura(boolean leitura) {
        this.leitura = leitura;
    }

    public Boolean isExclusao() {
        return exclusao;
    }

    public void setExclusao(boolean exclusao) {
        this.exclusao = exclusao;
    }

    public Boolean isExecucao() {
        return execucao;
    }

    public void setExecucao(boolean Execucao) {
        this.execucao = execucao;
    }
}
