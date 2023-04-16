import java.util.Date;
import java.util.Scanner;


public class Main{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Date data = new Date(); // Data e horário atual

        // Cadastradno clientes
        System.out.println("Informe o tipo de cliente: PF ou PJ");
        String tipo = scanner.nextLine();

        Seguradora seg = new Seguradora("seguradora", "telefone", "email", "endereco");

        String nome, endereco;
        if (tipo == "PJ"){
            Cliente_PJ cliente;
            System.out.print("Informe o CNPJ do cliente: ");
            String cnpj = scanner.nextLine();

            if (!Cliente_PJ.validarCNPJ(cnpj)){
                System.out.println("CNPJ inválido");
                cnpj = null;
            }

            System.out.print("Informe o nome do cliente: ");
            nome = scanner.nextLine();
            System.out.print("Informe o endereco do cliente: ");
            endereco = scanner.nextLine();
            cliente = new Cliente_PJ(nome, endereco, cnpj, data);
            seg.cadastrarCliente(cliente);
        }
        else if (tipo == "PF"){
            Cliente_PF cliente;
            System.out.print("Informe o CPF do cliente: ");
            String cpf = scanner.nextLine();

            if (!Cliente_PF.validarCPF(cpf)){
                System.out.println("CPF inválido");
                cpf = null;
            }

            System.out.print("Informe o nome do cliente: ");
            nome = scanner.nextLine();
            System.out.print("Informe o endereco do cliente: ");
            endereco = scanner.nextLine();
            System.out.print("Informe a educacao do cliente: ");
            String educacao = scanner.nextLine();
            System.out.print("Informe o genero do cliente: ");
            String genero = scanner.nextLine();
            System.out.print("Informe a classe economica do cliente: ");
            String classe = scanner.nextLine();

            cliente = new Cliente_PF(nome, data, endereco, educacao, genero, classe, cpf, data);
            seg.cadastrarCliente(cliente);
        }


        scanner.close();
        System.out.println("Informe o CNPJ: ");
  
        seg.gerarSinistro();
        System.out.println(seg.listarClientes("Cliente_PJ"));

    }

}