import java.util.LinkedList;

abstract class Cliente{ // Não é permitido criar um cliente que não seja PF ou PJ

    private String nome;
    private String endereco;
    private LinkedList<Veiculo> listaVeiculos; /* A lista de veículos não será longa, portanto é mais últil ter uma rápida 
                                                inserção e remoção */ 

    // Construtor
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new LinkedList<Veiculo>(); 
    }

    public String toString() {
        String str = "CLIENTE\nNome: " + nome + "\nEndereco: " + endereco + "\n";
        if (listaVeiculos.size() == 0){
            str += "Não há veículos cadastrados\n";
        }
        else{
            str += "Veículos: " + listaVeiculos + "\n";
        }

        return str;
    }

    public boolean adicionarVeiculo(Veiculo veiculo){

        if (!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
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

}