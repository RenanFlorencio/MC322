class Veiculo{

    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    // Construtor
    public Veiculo(String placa, String modelo, String marca, int anoFabricacao){
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
    }

    public String toString(){
        return "Placa:" + this.placa + "\nModelo:" + this.modelo + "\nMarca:" + this.marca + "\nAno Fabricacao:" + this.anoFabricacao +"\n";
    }

    // Getters e Setters
    public String getPlaca(){
        return this.placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    } 

    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

}