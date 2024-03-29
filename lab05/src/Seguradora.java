import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

class Seguradora {
    private final String CNPJ;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> listaSeguros; /* Sinistros não deixam de existir, portanto haverá mais buscas que adições */
    private ArrayList<Cliente> listaClientes; /* Quando houver um número grande de clientes, é mais importante buscar rapidamente
    do que adicionar novos clientes rapidamente */
    
    public Seguradora(String cnpj, String nome, String telefone, String email, String endereco){
        this.CNPJ = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = new ArrayList<Cliente>();
        this.listaSeguros = new ArrayList<Seguro>();
    }
    
    public String toString(){
        String str = "Nome:" + this.nome + "\nEmail:" + this.email + "\nTelefone:" + this.telefone + "\nEndereco:" + this.endereco + 
        "\n";
        if (listaClientes.size() != 0){
            str = str + "Lista de Clientes:" + listaClientes + "\n";
        }
        if (listaSeguros.size() != 0){
            str = str + "Lista de Sinistros:" + listaSeguros + "\n";
        }
        return str;
    }

    public boolean cadastrarCliente(Cliente cliente){

        if(!listaClientes.contains(cliente)){
            return listaClientes.add(cliente);
        }
        return false;
    }

    public boolean cadastrarCliente() throws ParseException{

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o tipo do cliente (PF ou PJ): ");
        String tipo = scanner.next();
        scanner.close();

        if (tipo.equals("PF")){
            Cliente_PF cliente = Entradas.lerClientePF();
            
            if (cliente == null){
                return false;
            }
            listaClientes.add(cliente);
            return true;
        }
        else if (tipo.equals("PJ")){
            Cliente_PJ cliente = Entradas.lerClientePJ();
            if(cliente == null){
                return false;
            }
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    public Cliente buscarCliente(String identificacao){
        // Busca cliente a partir de CPF ou CNPJ

        for(Cliente cliente : listaClientes){
            if (cliente.getIdentificacao().equals(identificacao)){
                return cliente;
            }
        }
        return null;
    }

    public Seguro buscarSeguro(int id){

        for (Seguro seguro : listaSeguros){
            if (seguro.getId() == id){
                return seguro;
            }
        }
        return null;
    }
    
    public boolean removerCliente(String identificacao){
        
        Cliente cliente = buscarCliente(identificacao);
        return listaClientes.remove(cliente);
    }

    public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){

        ArrayList<Seguro> seguros = new ArrayList<Seguro>();
        for (Seguro seguro : listaSeguros){
            
            if (seguro.getCliente() == cliente){
                seguros.add(seguro);
            }
        }
        return seguros;
    }

    public ArrayList<Sinistro> getSinistrosCliente(Cliente cliente){

        ArrayList<Sinistro> sinistros = new ArrayList<Sinistro>();

        for (Seguro seguro : listaSeguros){

            if (seguro.getCliente() == cliente){
                sinistros = seguro.getListaSinistros();
            }
        }
        return sinistros;
    }


    public boolean gerarSeguro(Cliente cliente) throws ParseException{

        if (cliente.getClass() == Cliente_PF.class){
            Cliente_PF cliente_PF = (Cliente_PF)cliente;
            Seguro_PF seguro_PF = Entradas.lerSeguro_PF(cliente_PF, this);
            return listaSeguros.add(seguro_PF);

        }
        else if (cliente.getClass() == Cliente_PJ.class){
            Cliente_PJ cliente_PJ = (Cliente_PJ)cliente;
            Seguro_PJ seguro_PJ = Entradas.lerSeguro_PJ(cliente_PJ, this);
            return listaSeguros.add(seguro_PJ);
        }
        return false;
    }

    public boolean gerarSeguro(Seguro seguro) throws ParseException{

        return listaSeguros.add(seguro);
    }

    public boolean cancelarSeguro(int id){

        Seguro remover = null;
        for(Seguro seguro : listaSeguros){

            if (seguro.getId() == id){
                remover = seguro;
                break;
            }
        }
        if (remover == null){
            System.out.println("Seguro não encontrado.");
            return false;
        }
        
        return listaSeguros.remove(remover);
    }

    public boolean transferirSeguro(Cliente transferidor, Cliente recipiente){

        Seguro seguro = buscarSeguroCliente(transferidor.getIdentificacao());
        seguro.setCliente(recipiente);
        return true;

    }

    public String listarClientes(){

        String saida = "";
        int contador = 1;
        for (Cliente cliente : listaClientes){
            saida += contador + "- " + cliente.getNome() + ": " + cliente.getIdentificacao() + " - " + cliente.getClass().getName() + "\n";
            contador++;
        }
        return saida;
    }

    public String listarSeguros(){
        String saida = "";
        int contador = 1;
        for (Seguro seguro : listaSeguros){
            saida += contador + "- " + seguro + "\n";
            contador++;
        }
        return saida;
    }

    public double calcularReceita(){

        double total = 0;
        for (Seguro seguro : listaSeguros){
            total += seguro.getValorMensal();

        }
        return total;
    }

    public Seguro buscarSeguroCliente(String identificacao){

        Cliente cliente = null;
        for (Cliente cl : listaClientes){
            if (cl.getIdentificacao() == identificacao){
                cliente = cl;
                break;
            }
        }
        if (cliente == null){
            System.out.print("Cliente inexistente!");
            return null;
        }

        for (Seguro seguro : listaSeguros){
            if (seguro.getCliente() == cliente){
                return seguro;
            }
        }
        System.out.print("Não há seguros para esse cliente!");
        return null;
    }

    public String getCNPJ() {
        return CNPJ;
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

    public ArrayList<Seguro> getListaSeguros(){
        return this.listaSeguros;
    }
}