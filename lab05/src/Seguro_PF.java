import java.util.Date;

public class Seguro_PF extends Seguro{

    private Veiculo veiculo;
    private Cliente_PF cliente_PF;

    public Seguro_PF(Seguradora seguradora, Cliente_PF cliente, Veiculo veiculo, Date dataInicio, Date dataFim) {
        super(seguradora, cliente, dataInicio, dataFim);
        this.cliente_PF = cliente;
        this.veiculo = veiculo;
    }

    public String toString(){
        String saida = super.toString();
        saida += veiculo + "\n";
        return saida;
    }

    public double calculaValor(){

        Cliente_PF cliente = (Cliente_PF)getCliente();
        double fator = CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.calcFator(cliente.calculaIdade());
        double valor = fator * (1 + 1 / (cliente.getListaVeiculos().size() + 2)) *
                (2 + getQtdeSinistrosCliente()/10) * (5 + getQtdeSinistrosCondutores()/10);

        return valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
 
    public Cliente_PF getCliente_PF() {
        return cliente_PF;
    }

    public void setCliente_PF(Cliente_PF cliente_PF) {
        this.cliente_PF = cliente_PF;
    }



}
