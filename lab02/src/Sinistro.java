class Sinistro{

    private int id;
    private String data;
    private String endereco;
    private static int cont_id = 0;

    public Sinistro (String data, String endereco){

        this.id = gerarID();
        this.data = data;
        this.endereco = endereco;
    }

    public String toString(){
        return "ID:" + this.id + "\nData:" + this.data + "\nEndereco:" + this.endereco +"\n";
    }

    public int gerarID(){
        int id = cont_id;
        cont_id++;
        return id;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getData(){
        return this.data;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
}