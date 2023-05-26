import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws ParseException {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<>();
        Date date = new GregorianCalendar(2003, Calendar.JUNE, 18).getTime();

        Seguradora seg = new Seguradora("Seguradora", "90919019", "seg@email.com", "rua dos bobos");
        Cliente_PF cliente_PF = new Cliente_PF("sadasd", "dsada", "dsadsada", "dsadadwad", "45959165821", date);
        Veiculo veic1 = new Veiculo("placa", "Corsa", "Rebaixado", 2012);
        cliente_PF.cadastrarVeiculo(veic1);
        listaSeguradoras.add(seg);

        seg.cadastrarCliente(cliente_PF);
        seg.gerarSeguro(cliente_PF);

        
        Veiculo veic2 = new Veiculo("VAICORIN", "Saveiro", "Cromada", 2015);
        date = new GregorianCalendar(2003, Calendar.JUNE, 18).getTime();

        Cliente_PF clPF;
        date = new GregorianCalendar(1910, Calendar.SEPTEMBER, 1).getTime();
        Cliente_PJ clPJ;



        date = new GregorianCalendar(2020, Calendar.SEPTEMBER, 1).getTime();

        date = new GregorianCalendar(2020, Calendar.SEPTEMBER, 1).getTime();

        MenuOperacoes[] menuOperacoes = MenuOperacoes.values();

        System.out.println(MenuOperacoes.exibirMenu());
        int operacao = scanner.nextInt();
        MenuOperacoes escolhaMenu;
        SubMenu subop;
        
        while(operacao != 0){

            escolhaMenu = menuOperacoes[operacao - 1];
            switch(escolhaMenu){
            
                case CADASTRAR:
                    System.out.println(MenuOperacoes.exibirSubMenu(escolhaMenu));
                    subop = MenuOperacoes.CADASTRAR.getSubMenu()[scanner.nextInt() - 1];
                    if(!realizarOperacao(subop, listaSeguradoras)){
                        System.out.println("Houve um erro durante a execução, verifique a existencia do cliente ou seguradora");
                    };
                    break;
                
                case LISTAR:
                    System.out.println(MenuOperacoes.exibirSubMenu(escolhaMenu));
                    subop = MenuOperacoes.LISTAR.getSubMenu()[scanner.nextInt() - 1];
                    if(!realizarOperacao(subop, listaSeguradoras)){
                        System.out.println("Nao ha itens a serem mostrados");
                    }
                    break;
    
                case EXCLUIR:
                    System.out.println(MenuOperacoes.exibirSubMenu(escolhaMenu));
                    subop = MenuOperacoes.EXCLUIR.getSubMenu()[scanner.nextInt() - 1];
                    if(!realizarOperacao(subop, listaSeguradoras)){
                        System.out.println("Erro ao excluir. O item pode nao existir.");
                    }
                    break;
    
                case GERAR_SINISTRO:
                    String entrada;
                    Seguradora seguradora = null;
                    System.out.print("Informe a seguradora: ");
                    entrada = scanner.next();
                    
                    for(Seguradora seg1 : listaSeguradoras){
                        if (seg1.getNome().equals(entrada)){
                            seguradora = seg1;
                            break;
                        }
                    }

                    System.out.print("Informe o nome cliente: ");
                    entrada = scanner.next();
                    Cliente cliente = null;
                    
                    for (Cliente cl : seguradora.getListaClientes()){
                        if(cl.getNome().equals(entrada)){
                            cliente = cl;
                            break;
                        }
                    }

                    // System.out.print("Informe a placa do veiculo: ");
                    // Veiculo veiculo = null;
                    // for (Veiculo veic : cliente.getListaVeiculos()){
                    //     if (veic.getPlaca().equals(scanner.next())){
                    //         veiculo = veic;
                    //     }
                    // }
                    // if (veiculo == null || cliente == null || seguradora == null){
                    //     System.out.println("Seguradora, cliente ou veiculo nao encontrados. Verfique as entradas.");
                    // }
                    // else{
                    //     seguradora.adicionarSinistro(Entradas.lerSinistro(veiculo, cliente, seguradora));
                    // }
                    // break;

                case TRANFERIR_SEGURO:

                    seguradora = null;
                    Cliente recipiente = null;
                    Cliente transferidor = null;

                    System.out.print("Informe o nome da seguradora: ");
                    String seguradoraStr = scanner.next();  
                    
                    for(Seguradora seg1 : listaSeguradoras){
                        if (seg1.getNome().equals(seguradoraStr)){
                            seguradora = seg1;
                        }
                    }

                    System.out.print("Informe o nome do cliente que irá transferir seu seguro: ");
                    String transferidorStr = scanner.next();

                    System.out.print("Informe o nome do cliente que irá receber os seguros: ");
                    String recipienteStr = scanner.next();

                    for(Cliente cl : seguradora.getListaClientes()){
                        if (cl.getNome().equals(transferidorStr)){
                            transferidor = cl;
                        }
                        else if (cl.getNome().equals(recipienteStr)){
                            recipiente = cl;
                        }
                        else if (transferidor != null || recipiente != null){
                            break;
                        }
                    }

                //     for(Veiculo veic : transferidor.getListaVeiculos()){
                //         recipiente.adicionarVeiculo(veic);
                //     }
                //     transferidor.getListaVeiculos().clear();
                //     seguradora.calcularPrecoSeguroCliente(transferidor);
                //     seguradora.calcularPrecoSeguroCliente(recipiente);
                //     break;

                // case CALCULA_RECEITA:
                //     double receita = 0;

                //     for(Seguradora seg1 : listaSeguradoras){
                //         receita = seg1.calculaReceita();
                //         System.out.println("O valor da receita de " + seg.getNome() + " é: " + receita);
                //     }
                //     break;
            }

            System.out.println("Operação finalizada!");
            System.out.println(MenuOperacoes.exibirMenu());
            operacao = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Programa finalizado...");
    }


    public static boolean realizarOperacao(SubMenu operacao, ArrayList<Seguradora> listaSeguradoras) throws ParseException{
    
        // Função suporte para realizar as operações desejadas no menu

        Scanner scanner = new Scanner(System.in);
        Seguradora seg = null;
        Cliente cliente = null;
        //Sinistro sinistro = null;
        Veiculo veiculo = null;
        int contador = 0;
        String nome;
        
        switch (operacao){

            case CADASTRAR_CLIENTE:
                // É necessário informar uma seguradora pois não há outra forma de acessar um cliente
                if (listaSeguradoras.size() != 0){

                    System.out.print("\nInforme o nome da seguradora: ");
                    String nomeSeg = scanner.next();

                    for (Seguradora seguradora : listaSeguradoras) {
                        if (nomeSeg.equals(seguradora.getNome())){
                            seg = seguradora;
                            break;
                        }
                    }

                    if(seg == null){
                        scanner.close();
                        return false;
                    }

                    System.out.print("\nInforme o tipo de cliente (PF ou PJ): ");
                    String tipo = scanner.next();
                    scanner.close();

                    if(tipo.equals("PF")){
                    //     Cliente_PF clientePF = Entradas.lerClientePF();
                    //     if(clientePF == null){
                    //         System.out.println("CPF inválido!");
                    //         return false;
                    //     }
                    //     seg.cadastrarCliente(clientePF);
                    // }
                    // else if (tipo.equals("PJ")){
                    //     Cliente_PJ clientePJ = Entradas.lerClientePJ();
                    //     if (clientePJ == null){
                    //         System.out.println("CNPJ inválido!");
                    //         return false;
                    //     }
                    //     seg.cadastrarCliente(clientePJ);
                    }
                    return true;
                }
                else{
                    System.out.println("Crie uma seguradora.");
                    scanner.close();
                    return false;
                }

            case CADASTRAR_SEGURADORA:
                
                scanner.close();
                seg = Entradas.lerSeguradora();
                listaSeguradoras.add(seg);
                return true;
            
            case CADASTRAR_VEICULO:

                veiculo = null;
                cliente = null;
                System.out.print("Informe o nome do cliente: ");
                String clientestr = scanner.next();
                scanner.close();

                for(Seguradora seg1: listaSeguradoras){
                    for(Cliente cl: seg1.getListaClientes()){
                        if (clientestr.equals(cl.getNome())){
                            cliente = cl;
                        }
                    }
                }

                if (cliente == null){
                    return false;
                }

                veiculo = Entradas.lerVeiculo();

                // return cliente.adicionarVeiculo(veiculo);
    
            case EXCLUIR_CLIENTE:

                System.out.print("Informe o nome do cliente a ser excluido: ");
                nome = scanner.next();
                seg = null;
                cliente = null;
                scanner.close();

                for(Seguradora seg1: listaSeguradoras){
                    for(Cliente cl: seg1.getListaClientes()){
                        if (nome.equals(cl.getNome())){
                            cliente = cl;
                            seg = seg1;
                        }
                    }
                }
                if (seg == null){
                    return false;
                }


            case EXCLUIR_SINISTRO:

                System.out.print("Informe o ID do sinistro a ser removido: ");
                int id = scanner.nextInt();
                // sinistro = null;
                // seg = null;
                // scanner.close();

                // for(Seguradora seg1: listaSeguradoras){
                //     for(Sinistro sin: seg1.getListaSinistros()){
                //         if (id == sin.getID()){
                //             sinistro = sin;
                //             seg = seg1;
                //         }
                //     }
                // }
                // if (seg == null){
                //     return false;
                // }

                // return seg.removerSinistro(sinistro);

            case EXCLUIR_VEICULO:

                System.out.print("Informe a placa do carro a ser removido: ");
                nome = scanner.next();
                veiculo = null;
                cliente = null;
                scanner.close();

                // for(Seguradora seg1: listaSeguradoras){
                //     for(Cliente cl: seg1.getListaClientes()){
                //         for(Veiculo veic : cl.getListaVeiculos()){
                //             if(nome.equals(veic.getPlaca())){
                //                 cliente = cl;
                //                 veiculo = veic;
                //             }
                //         }
                //     }
                // }
                if (veiculo == null){
                    return false;
                }

                // return cliente.removerVeiculo(veiculo);

            case LISTAR_CLIENTES:

                System.out.println("Informe o tipo de cliente (PF ou PJ): ");
                nome = scanner.next();
                scanner.close();

                if (nome.equals("PJ")){
                    nome = "Cliente_PJ";
                }
                else if (nome.equals("PF")){
                    nome = "Cliente_PF";
                }
                else{
                    return false;
                }
                
                String saida = "";
                // contador = 1;
                // for(Seguradora seg1: listaSeguradoras){
                //     saida += seg1.getNome().toUpperCase() + "-----------------------\n";
                //     saida += seg1.listarClientes(nome);
                // }
                // if (saida.equals("")){
                //     return false;
                // }

                System.out.println(saida);
                return true;

            case LISTAR_SINISTRO_C:
                // contador = 1;
                // saida = "";
                // scanner.close();
                // for (Seguradora seg1 : listaSeguradoras){
                //     ArrayList<Sinistro> lista = seg1.getListaSinistros();

                //     for (Cliente cl : seg1.getListaClientes()){
                //         saida += cl.getNome() + "------------------\n";

                //         for(Sinistro sin : lista){

                //             if (cl == sin.getCliente()){
                //                 saida += contador + "- " + sin + "\n"; 
                //                 contador++;
                //             }
                //         }
                //         saida += "----";

                //     }
                //     saida += "------------------------";
                // }

                // if (saida.equals("")){
                //     return false;
                // }
                // System.out.println(saida);
                // return true;
                    
            case LISTAR_SINISTRO_S:
                contador = 1;
                saida = "";
                
                // for (Seguradora seg1 : listaSeguradoras){
                //     saida += seg1.getNome().toUpperCase() + "---------------------\n";

                //     for (Sinistro sin : seg1.getListaSinistros()) {
                //         saida += contador + "- " + sin + "-------------------------------\n";
                //         contador ++;
                //     }
                // }
                scanner.close();

                if (saida.equals("")){
                    return false;
                }
                System.out.println(saida);
                return true;

            case LISTAR_VEICULO_C:

                seg = null;
                cliente = null;
                System.out.print("Informe o nome do cliente: ");
                nome = scanner.next();
                scanner.close();

                for(Seguradora seg1 : listaSeguradoras){
                    for (Cliente cl : seg1.getListaClientes()){
                        if (cl.getNome().equals(nome)){
                            cliente = cl;
                        }
                    }
                }
                
                // if (cliente.getListaVeiculos().size() == 0 || cliente == null){
                //     return false;
                // }
                // System.out.println("Veiculos registrados de " + cliente.getNome());
                // contador = 1;
                // for (Veiculo veic : cliente.getListaVeiculos()){
                //     System.out.println(veic + "---------------");
                //     contador ++;
                // }
                return true;

            case LISTAR_VEICULO_S:

                saida = "";
                System.out.print("Informe a seguradora: ");
                nome = scanner.next();
                
                // for(Seguradora seg1 : listaSeguradoras){

                //     if (seg1.getNome().equals(nome)){
                //         for(Cliente cl : seg1.getListaClientes()){
                //             for(Veiculo veic : cl.getListaVeiculos()){
                //                 saida += cl.getNome().toUpperCase() + "\n" + veic;
                //                 saida += "----------\n";
                //             }
                //         }
                //         break;
                //     }
                // }
                

                // if(saida == ""){
                //     return false;
                // }

                // System.out.println(saida);
                scanner.close();
                return true;
                
            case VOLTAR:
                scanner.close();
                return true;
            default:
                scanner.close();
                return true;
                
        }
    }

}