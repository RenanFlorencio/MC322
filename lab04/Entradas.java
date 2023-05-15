import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Entradas {
    private static final Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
    
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

        System.out.print("Informe a classe economica do cliente: ");
        String classe = scanner.next();

        System.out.print("Informe a data de nascimento do cliente no formato dd-MM-yyyy: ");
        Date nasc = formatter.parse(scanner.next());

        System.out.print("Informe a data de licenca do cliente no formato dd-MM-yyyy: ");
        Date lic = formatter.parse(scanner.next());

        cliente = new Cliente_PF(nome, lic, endereco, educacao, genero, classe, cpf, nasc);
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

        System.out.print("Informe a quantidade de funcionarios da empresa: ");
        int qtdeFuncionarios = scanner.nextInt();

        cliente = new Cliente_PJ(nome, endereco, cnpj, fundDate, qtdeFuncionarios);

        return cliente;
    }

    public static Seguradora lerSeguradora(){
        Seguradora seg;

        System.out.print("Informe o nome da seguradora: ");
        String nome = scanner.next();

        System.out.print("Informe o telefone da seguradora: ");
        String telefone = scanner.next();

        System.out.print("Informe o email da seguradora: ");
        String email = scanner.next();

        System.out.print("Informe o endereco da seguradora: ");
        String endereco = scanner.next();
    
        seg = new Seguradora(nome, telefone, email, endereco);
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

    public static Sinistro lerSinistro(Veiculo veiculo, Cliente cliente, Seguradora seguradora) throws ParseException{

        System.out.print("Informe a data do sinistro (dd-MM-yyyy): ");
        Date data = formatter.parse(scanner.next());

        System.out.print("Informe o endereco do sinistro: ");
        String endereco = scanner.next();

        Sinistro sinistro = new Sinistro(data, endereco, veiculo, seguradora, cliente);
        return sinistro;
    }

}
