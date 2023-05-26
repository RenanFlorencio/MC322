import java.util.Date;

class Sinistro{

    private final int ID;
    private Date data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;
    private static int cont_ID = 0;

    public Sinistro (Date data, String endereco, Condutor condutor, Seguro seguro){

        this.ID = gerarID();
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
    }

    public String toString(){
        String saida = "ID: " + this.ID + "\nData: " + this.data + "\nEndereco: " + this.endereco +"\n" + "\nCondutor: " + condutor
                + "\nSeguro: " + seguro + "\n";
        return saida;
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

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

}