import java.util.Date;
import java.util.Scanner;


public class Main{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Date data = new Date(); // Data e horário atual
        Seguradora seg = new Seguradora("seguradora", "telefone", "email", "endereco");
        System.out.println(seg);

        Cliente_PF clientepf = null;
        Cliente_PJ clientepj = null;
        
        // Verificar se tem como implementar um método para criar esses clientes em algum lugar
        String nome, endereco, tipo;
        for (int i = 0; i < 2; i++){
            System.out.println("Informe o tipo de cliente: PF ou PJ");
            tipo = scanner.next();
            if (tipo.equals("PJ")){
                System.out.print("Informe o CNPJ do cliente: ");
                String cnpj = scanner.next();

                if (!Cliente_PJ.validarCNPJ(cnpj)){
                    System.out.println("CNPJ inválido");
                    cnpj = null;
                }

                System.out.print("Informe o nome do cliente: ");
                nome = scanner.next();
                System.out.print("Informe o endereco do cliente: ");
                endereco = scanner.next();
                clientepj = new Cliente_PJ(nome, endereco, cnpj, data);

                if (seg.cadastrarCliente(clientepj)){
                    System.out.println("Cliente cadastrado com sucesso\n\n" + clientepj);
                }
            }
            else if (tipo.equals("PF")){
                System.out.print("Informe o CPF do cliente: ");
                String cpf = scanner.next();

                if (!Cliente_PF.validarCPF(cpf)){
                    System.out.println("CPF inválido");
                    cpf = null;
                }

                System.out.print("Informe o nome do cliente: ");
                nome = scanner.next();
                System.out.print("Informe o endereco do cliente: ");
                endereco = scanner.next();
                System.out.print("Informe a educacao do cliente: ");
                String educacao = scanner.next();
                System.out.print("Informe o genero do cliente: ");
                String genero = scanner.next();
                System.out.print("Informe a classe economica do cliente: ");
                String classe = scanner.next();

                clientepf = new Cliente_PF(nome, data, endereco, educacao, genero, classe, cpf, data);

                if (seg.cadastrarCliente(clientepf)){
                    System.out.println("Cliente cadastrado com sucesso\n\n" + clientepf);
                }
            }
        }

        System.out.println(seg.listarClientes("PJ"));

        System.out.println("Criando um veículo");
        System.out.print("Informe a marca do veículo: ");
        String marca = scanner.next();
        System.out.print("Informe o modelo do veículo: ");
        String modelo = scanner.next();
        System.out.print("Informe o ano de fabricação do veículo: ");
        int fabricacao = scanner.nextInt();
        System.out.print("Informe a placa: ");
        String placa = scanner.next();

        Veiculo veiculo = new Veiculo(placa, modelo, marca, fabricacao);
        System.out.println("\n" + veiculo);

        // Adicionando o veículo
        clientepf.adicionarVeiculo(veiculo);
        System.out.println(clientepf.getListaVeiculos());
        
        System.out.println("Adicionando um sinistro para esse carro");
        System.out.print("Informe o endereço: ");
        endereco = scanner.next();
        
        // Gerando um sinistro
        seg.gerarSinistro(data, endereco, veiculo, seg, clientepf);
        System.out.println("\n" + seg.listarSinistros());

        // Criando outro veículo
        System.out.println("Criando outro veículo");
        System.out.print("Informe a marca do veículo: ");
        marca = scanner.next();
        System.out.print("Informe o modelo do veículo: ");
        modelo = scanner.next();
        System.out.print("Informe o ano de fabricação do veículo: ");
        fabricacao = scanner.nextInt();
        System.out.print("Informe a placa: ");
        placa = scanner.next();

        veiculo = new Veiculo(placa, modelo, marca, fabricacao);
        System.out.println("\n" + veiculo);

        // Adicionando o veículo 
        clientepj.adicionarVeiculo(veiculo);
        System.out.println(clientepj.getListaVeiculos());

        // Visualizando o sinistro
        System.out.print("Nome do cliente do qual se deseja ver o sinistro: ");
        nome = scanner.next();
        System.out.println(seg.visualizarSinistro(nome));

        scanner.close();
  
    }

}