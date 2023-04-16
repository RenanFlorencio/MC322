import java.util.Date;

class Sinistro{

    private final int ID;
    private Date data;
    private String endereco;
    private Veiculo veiculo;
    private Seguradora seguradora;
    private Cliente cliente;
    private static int cont_ID = 0;

    public Sinistro(){
        this.ID = gerarID();
    }

    public Sinistro (Date data, String endereco, Veiculo veiculo, Seguradora seguradora, Cliente cliente){

        this.ID = gerarID();
        this.data = data;
        this.endereco = endereco;
        this.veiculo = veiculo;
        this.seguradora = seguradora;
        this.cliente = cliente;
    }

    public String toString(){
        return "ID:" + this.ID + "\nData:" + this.data + "\nEndereco:" + this.endereco +"\n";
    }

    public int gerarID(){
        int ID = cont_ID;
        cont_ID++;
        return ID;
    }

    public int getID(){
        return this.ID;
    }

    public Date getData(){
        return this.data;
    }

    public void setData(Date data){
        this.data = data;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}