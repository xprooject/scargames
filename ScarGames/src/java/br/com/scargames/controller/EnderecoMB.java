
package br.com.scargames.cotroller;

import br.com.scargames.domain.Endereco;
import br.com.scargames.services.EnderecoService;
import br.com.scargames.util.UtilMessages;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "enderecoMB")
@SessionScoped
public class EnderecoMB {
    
    private Endereco endereco;
    private List<Endereco> enderecos;
    
    public EnderecoMB() {
       this.listar();
    }

     public void listar() {
        EnderecoService service = new EnderecoService();
        List<Endereco> enderecos = service.listar();
    } 
    
      public String novo(){
        endereco = new Endereco();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String inserir(){
        EnderecoService service = new EnderecoService();
        if(service.inserir(endereco)){
            UtilMessages.messageInfo("Endereço cadastrado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar o endereço!");
            return null;
        }
    }
    public String excluir(Endereco endereco){
      EnderecoService service = new EnderecoService();
        if(service.excluir(endereco)){
             UtilMessages.messageInfo("Endereço excluido com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao excluir o endereço!");
            return null;
        }
    }
    
    
    public String carregarDados(Endereco endereco){
        this.endereco = endereco;
        return"alter.xhtml?faces-redirect=true";
    }
    public String alterar(){
        EnderecoService service = new EnderecoService();
        if(service.alterar(endereco)){
             UtilMessages.messageInfo("Endereco alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao alterar o endereco!");
            return null;
        }
    }
    
   public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
   
}
