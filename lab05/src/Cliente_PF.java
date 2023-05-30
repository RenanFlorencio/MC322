import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Cliente_PF extends Cliente {
    
    private final String CPF;
    private Date dataNascimento;
    private String educacao;
    private String genero;
    private ArrayList<Veiculo> listaVeiculos;

    public Cliente_PF(String nome, String endereco, String educacao, String genero, String CPF, Date dataNascimento){

        super(nome, endereco, CPF);
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.educacao = educacao;
        this.genero = genero;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    @Override
    public String toString() {
        return super.toString() + "CPF: " + CPF + "\nData de Nascimento: " + dataNascimento + "\nEducacao: " + educacao + "\nGenero: " + genero + "\n";

    }

    public boolean cadastrarVeiculo(Veiculo veiculo){

        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            setAtualizado(false);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removerVeiculo(Veiculo veiculo){
        setAtualizado(false);
        return listaVeiculos.remove(veiculo);
    }

    public Veiculo buscarVeiculo(String placa){

        for (Veiculo veiculo : listaVeiculos){
            if (veiculo.getPlaca().equals(placa)){
                return veiculo;
            }
        }
        return null;
    }

    public String listarVeiculos(){
        String saida = "";
        int contador = 1;
        for (Veiculo veiculo : listaVeiculos){
            saida += contador + "- " + veiculo.getModelo() + ": " + veiculo.getPlaca() + "\n";
            saida += "-------------\n";
        }
        return saida;
    }

    public int calculaIdade(){
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.ofInstant(dataNascimento.toInstant(), ZoneId.systemDefault());

        return Period.between(date, now).getYears();
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCPF(){
        return this.CPF;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

}
