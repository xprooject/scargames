/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scargames.cotroller;

import br.com.scargames.domain.Biblioteca;
import br.com.scargames.services.BibliotecaService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author aluno1
 */
@ManagedBean(name = "bibliotecaMB")
@SessionScoped
public class BibliotecaMB implements Serializable {

    private Biblioteca biblioteca;
    private List<Biblioteca> bibliotecas;
    
   
    
   
    
    public BibliotecaMB() {
        this.listar();
    }
    
    public void listar(){
        BibliotecaService service = new BibliotecaService();
        bibliotecas = service.listar();
    }
    
    public String novo(){
        biblioteca = new Biblioteca();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        BibliotecaService service = new BibliotecaService();
        if (service.inserir(biblioteca)){
            UtilMessages.messageInfo("Biblioteca cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar biblioteca!");
            return null;
        }
    }
    
    public String alterar(){
        BibliotecaService service = new BibliotecaService();
        if (service.alterar(biblioteca)){
            UtilMessages.messageInfo("Biblioteca alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar biblioteca!");
            return null;
        }
    }
    
    public String carregarDados(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Biblioteca biblioteca){
        BibliotecaService service = new BibliotecaService();
        if (service.excluir(biblioteca)){
            UtilMessages.messageInfo("Biblioteca excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Erro ao excluir Biblioteca!");
            return null;
        }
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    
}
