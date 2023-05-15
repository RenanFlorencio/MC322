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

    public void calcularPrecoSeguroCliente(Cliente cliente){
        // Calcula o valor do seguro e o coloca nas propriedades do cliente

        cliente.setValorSeguro(cliente.calculaScore() * (1 + QntdeSinistros(cliente)));
    }

    public int QntdeSinistros(Cliente cliente){

        int cont = 0;
        for (Sinistro sinistro : listaSinistros) {
            
            if (sinistro.getCliente() == cliente){
                cont++;
            }
        }
        return cont;
    }

    public boolean gerarSinistro(Date data, String endereco, Veiculo veiculo, Seguradora seguradora, Cliente cliente){
        /* Gera um sinistro vazio */

        Sinistro novo = new Sinistro(data, endereco, veiculo, seguradora, cliente);
        listaSinistros.add(novo);
        return true;
    }

    public boolean adicionarSinistro(Sinistro sinistro){

        return listaSinistros.add(sinistro);
    }

    public String visualizarSinistro(String cliente){
        /* Retorna uma string com os sinistros relacionados ao cliente fornecido */ 
    
        String str = "Sinistros de " + cliente + "\n";
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

    public String listarSinistros(){
        String saida = "";
        int contador = 1;
        for (Sinistro sinistro : listaSinistros) {
            saida += contador + "-\n" + sinistro;
            contador ++;
        }
        return saida;
    }

    public String listarClientes(String tipo){

        String saida = "";
        int contador = 1;
        for(Cliente cl: this.getListaClientes()){

            if (cl.getClass().getName().equals(tipo)){
                saida += contador + "- " + cl + "----\n";
                contador ++;
            }
        }
        return saida;
    }

    public double calculaReceita(){

        double receita = 0;
        for (Cliente cl : this.getListaClientes()){
            receita += cl.getValorSeguro();
        }
        return receita;
    }

    public boolean cadastrarCliente(Cliente cliente){

        if(!listaClientes.contains(cliente)){
            listaClientes.add(cliente);
            calcularPrecoSeguroCliente(cliente);
            return true;
        }

        return false;
    }

    public boolean removerCliente(Cliente cliente){

        return listaClientes.remove(cliente);
    }

    public boolean removerSinistro(Sinistro sinistro){

        return listaSinistros.remove(sinistro);
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