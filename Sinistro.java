class Sinistro{

    private int id;
    private String data;
    private String endereco;

    public Sinistro (String data, String endereco){

        this.data = data;
        this.endereco = endereco;
    }

    public long gerarID(){
        /* Retorna um ID criado randomicamente (ainda não tem um modo de armazenar o valor) */
        double id = Math.random() * 10000;
        return Math.round(id);
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