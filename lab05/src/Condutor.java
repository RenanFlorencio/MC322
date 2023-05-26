import java.util.ArrayList;
import java.util.Date;

public class Condutor{

    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNascimento;
    private ArrayList<Sinistro> listaSinistros;

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNascimento) {

        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = new ArrayList<Sinistro>();
    }

    public String toString(){
        String saida = "";
        saida += "\nCPF: " + cpf + "\nNome: " + nome + "\nTelefone: " + telefone + "\nEmail: " + email +
                "\nData de nascimento: " + dataNascimento + "\n";
        if (listaSinistros != null){
            saida += listaSinistros;
        }
        saida += "\n";
        return saida;
    }

    public boolean adicionarSinistro(Sinistro sinistro){

        if (!listaSinistros.contains(sinistro)){
            return listaSinistros.add(sinistro);
        }
        return false;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Date getDataNascimento() {
        return dataNascimento;
    }


    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }


    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

}