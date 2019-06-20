package br.com.scargames.controller;

import br.com.scargames.domain.Usuario;
import br.com.scargames.services.UsuarioService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public final class UsuarioMB implements Serializable{
    
    private Usuario usuario;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String senha;
    private List<Usuario> usuarios;
    
    public UsuarioMB() {
        this.listar();
    }

    public void listar() {
        UsuarioService service = new UsuarioService();
        usuarios = service.listar();
    } 
    public String novo(){
        usuario = new Usuario();
        return "new.xhtml?faces-redirect=true";
    }
    
    public void inicializarHibernate(){
        UsuarioService service = new UsuarioService();
        service.inicializarHibernate();
    }
    
    public String autenticar(){
        UsuarioService service = new UsuarioService();
        usuario = new Usuario(email, senha);
        if(service.autenticar(usuario)){
            return "/private/index.xhtmll?faces-redirect=true";
        }else{
            UtilMessages.messageError("Dados inválidos!");
            return null; 
        }
    }
    
    public String alterar(){
        UsuarioService service = new UsuarioService();
        if (service.alterar(usuario)){
            UtilMessages.messageInfo("Usuario alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar usuario!");
            return null;
        }
    }
    
    public String excluir(Usuario usuario){
        UsuarioService service = new UsuarioService();
        if (service.excluir(usuario)){
            UtilMessages.messageInfo("Usuario excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Erro ao excluir Usuario!");
            return null;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
      
    
}
