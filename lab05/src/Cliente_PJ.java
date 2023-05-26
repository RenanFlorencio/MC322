import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.ZoneId;

public class Cliente_PJ extends Cliente {
    
    private final String CNPJ;
    private Date dataFundacao;
    private int qtdeFuncionarios;
    private ArrayList<Frota> listaFrotas;

    public Cliente_PJ(String nome, String endereco, String CNPJ, Date dataFundacao){

        super(nome, endereco, CNPJ);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.listaFrotas = new ArrayList<Frota>();
    }

    @Override
    public String toString() {
        String saida = super.toString() + "CNPJ: " + CNPJ + "\ndataFundacao: " + dataFundacao + "\n" + 
                "\nNumero de funcionarios: " + qtdeFuncionarios + "\n";
        if (listaFrotas != null){
            saida += listaFrotas;
        }
        saida += "\n";
        return saida;
    }

    public boolean cadastrarFrota(){

        Frota frota = Entradas.lerFrota();
        return listaFrotas.add(frota);
    }

    public boolean atualizarFrota(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a operação desejada\n1- Adicionar veículos\n2- Remover veículos\n3- Remover frota\n4- Cancelar");
        int operacao = scanner.nextInt();
        
        if (operacao == 4){
            scanner.close();
            return false;
        }
        System.out.println("Informe o código da frota: ");
        String codigo = scanner.next();
        
        Veiculo veiculo = null;
        Frota frota = null;
        for (Frota fr : listaFrotas){
            if (fr.getCode().equals(codigo)){
                frota = fr;
            }
        }
        if (frota == null){
            System.out.print("Frota não encontrada.");
            scanner.close();
            return false;
        }
        switch(operacao){

            case 1:
                veiculo = Entradas.lerVeiculo();
                scanner.close();

                if (frota.getListaVeiculos().contains(veiculo)){
                    System.out.println("Veiculo adicionado com sucesso!");
                    return frota.addVeiculo(veiculo);
                }
                System.out.println("Veiculo já cadastrado!");
                return false;

            case 2:
                System.out.print("Informe a placa do veiculo: ");
                String placa = scanner.next();
                scanner.close();
                
                for(Veiculo veic : frota.getListaVeiculos()){
                    if (veic.getPlaca().equals(placa)){
                        veiculo = veic;
                    }
                }
                if (veiculo == null){
                    System.out.println("Veículo não encontrado.");
                    return false;
                }
                if(frota.getListaVeiculos().remove(veiculo)){
                    System.out.println("Veiculo removido com sucesso!");
                    return true;
                }
                else{
                    System.out.println("Veiculo não faz parte da frota!");
                    return false;
                }
            
            case 3:
                scanner.close();
                if (listaFrotas.remove(frota)){
                    System.out.println("Frota removida com sucesso!");
                    return true;
                }
                else{
                    return false;
                }
            
            default:
                scanner.close();
                System.out.println("Comando inválido!");
                return false;
        }
    }

    public int calculaIdade(){
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.ofInstant(dataFundacao.toInstant(), ZoneId.systemDefault());

        return Period.between(date, now).getYears();
    }

    public int getQtdeVeiculos(){

        int total = 0;
        for(Frota frota : listaFrotas){
            total += frota.getListaVeiculos().size();
        }
        return total;
    }


    public ArrayList<Frota> getListaFrotas() {
        return listaFrotas;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getCNPJ(){
        return this.CNPJ;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

}
