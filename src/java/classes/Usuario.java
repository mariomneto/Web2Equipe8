package classes;

import java.io.Serializable;

public class Usuario implements Serializable{
    public enum Tipo {
        CLIENTE,
        FUNCIONARIO
    }
    
    private String CPF;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;
    private String senha;
    private Tipo tipoUsuario;
    
    public Usuario(){
        
    }
    public Usuario(String CPF, String nome, String email, String endereco, String telefone, String senha, Tipo tipoUsuario){
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Tipo getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Tipo tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
