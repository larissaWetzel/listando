package listaltp;

public class Usuario {
    
    private String nome;
    private Usuario proximo;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getProximo() {
        return proximo;
    }

    public void setProximo(Usuario proximo) {
        this.proximo = proximo;
    }
    
    public Usuario(){
        
    }
    
}
