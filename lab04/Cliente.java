import java.util.LinkedList;

abstract class Cliente{ // Não é permitido criar um cliente que não seja PF ou PJ

    private String nome;
    private String endereco;
    private LinkedList<Veiculo> listaVeiculos; /* A lista de veículos não será longa, portanto é mais últil ter uma rápida 
                                                inserção e remoção */ 
    private double valorSeguro;
    private boolean atualizado;

    // Construtor
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.atualizado = false;
        this.listaVeiculos = new LinkedList<Veiculo>(); 
    }

    public String toString() {
        
        String str = "\nNome: " + nome + "\nEndereco: " + endereco + "\nValor seguro: " + this.getValorSeguro() + "\n";
        if (listaVeiculos.size() == 0){
            str += "Não há veículos cadastrados\n";
        }
        else{
            str += "Veículos: " + listaVeiculos + "\n";
        }

        return str;
    }

    // Esse método está sendo sobrescrito em Cliente_PJ e Cliente_PF
    public double calculaScore(){
        return 0;
    }

    public boolean adicionarVeiculo(Veiculo veiculo){

        if (!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            setAtualizado(false);
            return true;
        }
        return false;
    }

    public boolean removerVeiculo(Veiculo veiculo){

        return listaVeiculos.remove(veiculo);
    }

    // Getters e Setters
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public LinkedList<Veiculo> getListaVeiculos(){
        return this.listaVeiculos;
    }

    public boolean getAtualizado(){
        return this.atualizado;
    }

    public void setAtualizado(boolean status){
        atualizado = status;
    }

    public double getValorSeguro() {
        // Verificando se o valor do seguro atual está atualizado
        if (atualizado == false){
            setValorSeguro(calculaScore());
        }
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

}