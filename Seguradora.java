import java.util.ArrayList;

class Seguradora {

    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes; // Pensar se usa arraylist ou linkedlist

    public Seguradora(String nome, String telefone, String email, String endereco, ArrayList<Sinistro> listaSinistos, ArrayList<Cliente> listaClientes){
        
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = listaClientes;
        this.listaSinistros = listaSinistos;
    }

    public String toString(){
        return "Nome:" + this.nome + "\nEmail:" + this.email + "\nTelefone:" + this.telefone + "\nEndereco:" + this.endereco + "\n";
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
}