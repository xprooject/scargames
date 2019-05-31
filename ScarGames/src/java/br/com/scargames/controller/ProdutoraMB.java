package br.com.scargames.controller;

import br.com.scargames.domain.Produtora;
import br.com.scargames.services.ProdutoraService;
import br.com.scargames.util.UtilMessages;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "produtoraMB")
@SessionScoped
public class ProdutoraMB implements Serializable {

    private Produtora Produtora;
    private List<Produtora> Produtoras;
    
    public ProdutoraMB() {
        this.listar();
    }
 
    
    public void listar(){
        ProdutoraService service = new ProdutoraService();
        Produtoras = service.listar();
    }
    
    public String novo(){
        Produtora = new Produtora();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        ProdutoraService service = new ProdutoraService();
        if (service.inserir(Produtora)){
            UtilMessages.messageInfo("Produtora cadastrada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar a Produtora!");
            return null;
        }
    }
    
    public String alterar(){
        ProdutoraService service = new ProdutoraService();
        if (service.alterar(Produtora)){
            UtilMessages.messageInfo("Produtora alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar a Produtora!");
            return null;
        }
    }
    
    public String carregarDados(Produtora Produtora){
        this.Produtora = Produtora;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Produtora Produtora){
        ProdutoraService service = new ProdutoraService();
        if (service.excluir(Produtora)){
            UtilMessages.messageInfo("Produtora excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir a Produtora!");
            return null;
        }      
    }

    public Produtora getProdutora() {
        return Produtora;
    }

    public void setProdutora(Produtora Produtora) {
        this.Produtora = Produtora;
    }

    public List<Produtora> getProdutoras() {
        return Produtoras;
    }

    public void setProdutoras(List<Produtora> Produtoras) {
        this.Produtoras = Produtoras;
    }
    
    
    
    
   
}
   
