package classes;

import java.io.Serializable;

public class Usuario implements Serializable{
    public enum Tipo {
        CLIENTE,
        FUNCIONARIO
    }
    
    private int id;
    private String CPF;
    private String nome;
    private String email;
    private String CEP;
    private int numeroCasa;
    private String telefone;
    private String senha;
    private Tipo tipoUsuario;
    
    public Usuario(){
        
    }
    public Usuario(String CPF, String nome, String email, String CEP, int numeroCasa, String telefone, String senha, Tipo tipoUsuario){
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.CEP = CEP;
        this.numeroCasa = numeroCasa;
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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
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
    
    public void setTipoUsuario(Tipo tipo){
        this.tipoUsuario = tipo;
    }
    
    public Tipo getTipoUsuario(){
        return this.tipoUsuario;
    }
    
    public int getIdFuncao() {
        if(this.tipoUsuario == Tipo.CLIENTE) {
            return 1;
        }
        return 2;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
}
