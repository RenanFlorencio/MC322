import java.util.Date;
import java.util.ArrayList;

class Seguradora {

    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros; /* Sinistros não deixam de existir, portanto haverá mais buscas que adições */
    private ArrayList<Cliente> listaClientes; /* Quando houver um número grande de clientes, é mais importante buscar rapidamente
                                                do que adicionar novos clientes rapidamente */

    public Seguradora(String nome, String telefone, String email, String endereco){
        
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = new ArrayList<Cliente>();
        this.listaSinistros = new ArrayList<Sinistro>();
    }

    public String visualizarSinistro(String cliente){
    /* Retorna uma string com os sinistros relacionados ao cliente fornecido */ 

        String str = "SINISTROS DE " + cliente;
        int cont = 0;
        for (Sinistro sinistro : listaSinistros) {

            if (cliente.equals(sinistro.getCliente().getNome())) {      
                str += sinistro.toString();
                cont += 1;
            }
        }

        if (cont == 0){
            return str = "Sinistro não encontrado";
        }
        return str;
    }

    public boolean gerarSinistro(Date data, String endereco, Veiculo veiculo, Seguradora seguradora, Cliente cliente){
        /* Gera um sinistro vazio */

        Sinistro novo = new Sinistro(data, endereco, veiculo, seguradora, cliente);
        listaSinistros.add(novo);
        return true;
    }

    public String listarSinistros(){
        int contador = 1;
        String str = "";
        for (Sinistro sinistro : this.getListaSinistros()) {
            str += contador + ":\n" + sinistro;
        }
        return str;
    }

    public String listarClientes(String tipoCliente){
        /* Lista todos os clientes do tipo passado como parâmetro */

        if (tipoCliente.equals("PJ")){
            tipoCliente = "Cliente_PJ";
        }
        else if (tipoCliente.equals("PF")){
            tipoCliente = "Cliente_PF";
        }

        String str = "";
        for (Cliente cliente : listaClientes) {

            if (cliente.getClass().getName() == tipoCliente){
                str += cliente.toString();
            } 
        }
        return str;
    }

    public boolean cadastrarCliente(Cliente cliente){

        if(!listaClientes.contains(cliente)){
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean removerCliente(Cliente cliente){

        boolean rmv = listaClientes.remove(cliente);
        return rmv;
    }


    public String toString(){
        String str = "Nome:" + this.nome + "\nEmail:" + this.email + "\nTelefone:" + this.telefone + "\nEndereco:" + this.endereco + 
        "\n";
        if (listaClientes.size() != 0){
            str = str + "Lista de Clientes:" + listaClientes + "\n";
        }
        if (listaSinistros.size() != 0){
            str = str + "Lista de Sinistros:" + listaSinistros + "\n";
        }
        return str;
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

    public ArrayList<Cliente> getListaClientes(){
        return this.listaClientes;
    }

    public ArrayList<Sinistro> getListaSinistros(){
        return this.listaSinistros;
    }
}