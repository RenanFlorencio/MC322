import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Entradas {
    private static final Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");

    public static Frota lerFrota(){

        System.out.print("Informe o código da frota: ");
        String codigo = scanner.next();

        Frota frota = new Frota(codigo);
        return frota;
    }

    public static Condutor lerCondutor() throws ParseException{

        System.out.print("Informe o CPF do condutor: ");
        String cpf = scanner.next();

        if (!Validacao.validaCPF(cpf)){
            return null;
        }

        System.out.print("Informe o nome do condutor: ");
        String nome = scanner.next();

        System.out.print("Informe o telefone do condutor: ");
        String telefone = scanner.next();

        System.out.print("Informe o endereco do condutor: ");
        String endereco = scanner.next();

        System.out.print("Informe o email do condutor: ");
        String email = scanner.next();

        System.out.print("Informe a data de nascimento do condutor no formato dd-MM-yyyy: ");
        Date nasc = formatter.parse(scanner.next());

        Condutor condutor = new Condutor(cpf, nome, telefone, endereco, email, nasc);
        return condutor;

    }

    public static Cliente_PF lerClientePF() throws ParseException{
        Cliente_PF cliente;

        System.out.print("Informe o nome do cliente: ");
        String nome = scanner.next();

        System.out.print("Informe o endereco do cliente: ");
        String endereco = scanner.next();

        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.next();

        if (!Validacao.validaCPF(cpf)){
            return null;
        }

        System.out.print("Informe a educacao do cliente: ");
        String educacao = scanner.next();

        System.out.print("Informe o genero do cliente: ");
        String genero = scanner.next();

        System.out.print("Informe a data de nascimento do cliente no formato dd-MM-yyyy: ");
        Date nasc = formatter.parse(scanner.next());

        cliente = new Cliente_PF(nome, endereco, educacao, genero, cpf, nasc);
        return cliente;
    }

    public static Cliente_PJ lerClientePJ() throws ParseException{
        Cliente_PJ cliente;

        System.out.print("Informe o nome do cliente: ");
        String nome = scanner.next();

        System.out.print("Informe o endereco do cliente: ");
        String endereco = scanner.next();

        System.out.print("Informe o CNPJ do cliente: ");
        String cnpj = scanner.next();

        if(!Validacao.validaCNPJ(cnpj)){
            return null;
        }

        System.out.print("Informe a data de fundacao da empresa no formato dd-MM-yyyy: ");
        Date fundDate = formatter.parse(scanner.next());

        cliente = new Cliente_PJ(nome, endereco, cnpj, fundDate);

        return cliente;
    }

    public static Seguro_PF lerSeguro_PF(Cliente_PF cliente, Seguradora seguradora) throws ParseException{

        Seguro_PF seguro = null;
        System.out.print("Informe a data de inicio (dd-MM-yyyy): ");
        Date dataIn = formatter.parse(scanner.next());

        System.out.print("Informe a data de fim (dd-MM-yyyy): ");
        Date dataFim = formatter.parse(scanner.next());

        System.out.print("Informe a placa do veículo: ");
        String placa = scanner.next();

        for(Veiculo veiculo : cliente.getListaVeiculos()){
            if(veiculo.getPlaca().equals(placa)){
                seguro = new Seguro_PF(seguradora, cliente, veiculo, dataIn, dataFim);
                break;
            }
        }
        return seguro;
    }

    public static Seguro_PJ lerSeguro_PJ(Cliente_PJ cliente, Seguradora seguradora) throws ParseException{

        Seguro_PJ seguro = null;
        System.out.print("Informe a data de inicio (dd-MM-yyyy): ");
        Date dataIn = formatter.parse(scanner.next());

        System.out.print("Informe a data de fim (dd-MM-yyyy): ");
        Date dataFim = formatter.parse(scanner.next());

        System.out.print("Informe o código da frota: ");
        String codigo = scanner.next();

        for(Frota frota : cliente.getListaFrotas()){

            if(frota.getCode().equals(codigo)){
                seguro = new Seguro_PJ(seguradora, cliente, dataIn, dataFim, frota);
                break;
            }
        }
        return seguro;
    }

    public static Seguradora lerSeguradora(){
        Seguradora seg;


        System.out.print("Informe o CNPJ da seguradora: ");
        String cnpj = scanner.next();

        if (!Validacao.validaCNPJ(cnpj)){
            System.out.println("CNPj invalido");
            return null;
        }

        System.out.print("Informe o nome da seguradora: ");
        String nome = scanner.next();

        System.out.print("Informe o telefone da seguradora: ");
        String telefone = scanner.next();

        System.out.print("Informe o email da seguradora: ");
        String email = scanner.next();

        System.out.print("Informe o endereco da seguradora: ");
        String endereco = scanner.next();
    
        seg = new Seguradora(cnpj, nome, telefone, email, endereco);
        return seg;

    }

    public static Veiculo lerVeiculo(){
        Veiculo veic;

        System.out.print("Informe a placa do carro: ");
        String placa = scanner.next();

        System.out.print("Informe a marca do carro: ");
        String marca = scanner.next();

        System.out.print("Informe o modelo do carro: ");
        String modelo = scanner.next();

        System.out.print("Informe o ano de fabricacao do carro: ");
        int anoFabricacao = scanner.nextInt();

        veic = new Veiculo(placa, modelo, marca, anoFabricacao);
        return veic;
    }

    public static Sinistro lerSinistro(Condutor condutor, Seguro seguro) throws ParseException{

        System.out.print("Informe a data do sinistro (dd-MM-yyyy): ");
        Date data = formatter.parse(scanner.next());

        System.out.print("Informe o endereco do sinistro: ");
        String endereco = scanner.next();

        Sinistro sinistro = new Sinistro(data, endereco, condutor, seguro);
        return sinistro;
    }

}
