public class Validacao {
    
    public static boolean validaCPF(String cpf){
    /* Verifica se o CPF informado é válido */

        // Formatando o CPF
        cpf = cpf.replaceAll("[^\\d]", "");
        int tamanhoCPF = cpf.length();

        // Verificando a quantidade de digitos
        if (tamanhoCPF != 11){
            return false;
        }
        
        // Verificando se todos os digitos são iguais
        int contador_caracteresIguais = 0;
        char num_atual = cpf.charAt(0);
        for (int i = 1; i < tamanhoCPF; i++){

            if (cpf.charAt(i) != num_atual){
                break;
            }

            else {
                contador_caracteresIguais++;
                num_atual = cpf.charAt(i);
            }
        }
        if (contador_caracteresIguais == 10){
            return false;
        }

        // Validando o primeiro digito do CPF
        int soma_digitos = 0;
        for (int i = 0; i < tamanhoCPF - 2; i++){
            
            // Convertendo usando a tabela ASCII
            soma_digitos += (cpf.charAt(i) - '0') * (i + 1);
        }

        int resto_divisao = soma_digitos % 11;
        if (resto_divisao == 10){
            resto_divisao = 0;
        }

        if (resto_divisao != cpf.charAt(9) - '0'){
            return false;
        }

        // Validando o segundo digito do CPF
        soma_digitos = 0;
        for (int i = 0; i < tamanhoCPF - 1; i++){

            // Convertendo usando a tabela ASCII
            soma_digitos += (cpf.charAt(i) - '0') * (i);
            }
        
        resto_divisao = soma_digitos % 11;
        if (resto_divisao == 10){
            resto_divisao = 0;
        }

        if (resto_divisao != cpf.charAt(10) - 48){
            return false;
        }

        return true;
    }

    public static boolean validaCNPJ(String cnpj){

        cnpj = cnpj.replaceAll("[^\\d]", "");
        int tamanhoCNPJ = cnpj.length();

        if (tamanhoCNPJ != 14){
            return false;
        }

        // Verificando se todos os digitos são iguais
        int contador_caracteresIguais = 0;
        char num_atual = cnpj.charAt(0);
        for (int i = 1; i < tamanhoCNPJ; i++){
        
            if (cnpj.charAt(i) != num_atual){
                break;
            }
        
            else {
                contador_caracteresIguais++;
                num_atual = cnpj.charAt(i);
            }
        }
        if (contador_caracteresIguais == 14){
            return false;
        }

        // Validando o primeiro digito verificador
        int soma = 0;
        int multiplicador = 5;
        for(int i = 0; i < tamanhoCNPJ - 2; i++){

            soma += (cnpj.charAt(i) - 48) * multiplicador;
            
            if(multiplicador - 1 < 2){
                multiplicador = 10;
            }
            multiplicador--;
        }

        int resto = soma % 11;
        if (resto < 2){
            resto = 0;
        }
        else{
            resto = 11 - resto;
        }
        if (resto != cnpj.charAt(12) - 48){
            return false;
        }

        // Validando o segundo digito verificador
        multiplicador = 6;
        soma = 0;
        for(int i = 0; i < tamanhoCNPJ - 1; i++){

            soma += (cnpj.charAt(i) - 48) * multiplicador;
            
            if(multiplicador - 1 < 2){
                multiplicador = 10;
            }
            multiplicador--;
        }

        resto = soma % 11;
        if (resto < 2){
            resto = 0;
        }
        else{
            resto = 11 - resto;
        }
        if (resto != cnpj.charAt(13) - 48){
            return false;
        }

        return true;

    }

}
