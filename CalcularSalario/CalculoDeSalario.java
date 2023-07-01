import java.util.Scanner;

public class CalculoDeSalario {

    //Função que calcula o desconto do INSS no salário Bruto
    public static double[] INSS(double[] salariosBrutos) {
        double[] descontoINSS = new double[5];
        for (int i = 0; i < 5; i++) {

            if (salariosBrutos[i] <= 1212.00) {
                descontoINSS[i] = salariosBrutos[i] * 0.075;
            }
            else if (salariosBrutos[i] >= 1212.01 && salariosBrutos[i] <= 2427.35) {
                descontoINSS[i] = salariosBrutos[i] * 0.09;
            }
            else if (salariosBrutos[i] >= 2427.36 && salariosBrutos[i] <= 3641.03) {
                descontoINSS[i] = salariosBrutos[i] * 0.12;
            }
            else if (salariosBrutos[i] >= 3641.04 && salariosBrutos[i] <= 7087.22) {
                descontoINSS[i] = salariosBrutos[i] * 0.14;
            }
            else if(salariosBrutos[i] >= 7087.23){
                descontoINSS[i] = salariosBrutos[i] * 0.14;
            }
        }
        return descontoINSS;
    }

    //Função que calcula o desconto do Imposto de Renda no Saário Bruto
    public static double[] ImpostoDeRenda(double[] salariosBrutos) {
        double[] descontoImpostoDeRenda = new double[5];

        for (int i = 0; i < 5; i++) {
            if (salariosBrutos[i] <= 1903.98) {
                descontoImpostoDeRenda[i] = salariosBrutos[i] * 0;
            }
            else if (salariosBrutos[i] >= 1903.99 && salariosBrutos[i] <= 2826.65) {
                descontoImpostoDeRenda[i] = salariosBrutos[i] * 0.075;
            }
            else if (salariosBrutos[i] >= 2826.66 && salariosBrutos[i] <= 3751.05) {
                descontoImpostoDeRenda[i] = salariosBrutos[i] * 0.15;
            }
            else if (salariosBrutos[i] >= 3751.06 && salariosBrutos[i] <= 4664.68) {
                descontoImpostoDeRenda[i] = salariosBrutos[i] * 0.225;
            }
            else if (salariosBrutos[i] > 4664.68) {
                descontoImpostoDeRenda[i] = salariosBrutos[i] * 0.275;
            }
        }
        return descontoImpostoDeRenda;
    }

    //Função que calcula o salário líquido, subtraindo os descontos do INSS e do Imposto de Renda no salário Bruto
    public static double[] SalarioLiquido(double[] salariosBrutos, double[] descontoINSS, double[] descontoImpostoDeRenda) {
        double[] salarioLiquido = new double[5];

        for (int i = 0; i < 5; i++) {
            salarioLiquido[i] = salariosBrutos[i] - descontoINSS[i] - descontoImpostoDeRenda[i];
        }

        return salarioLiquido;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] salariosBrutos = new double[5];

        System.out.println("Bem vindo ao Cálculo de Salário!!");
        System.out.println();
        System.out.println("Você terá que digitar 5 salários para o calculo dos descontos e dos salários Líquidos!!");
        System.out.println();
        
        // Loop para digitar os 5 salários brutos
        for (int i = 0; i < 5; i++) {
            boolean salarioValido = false;
            do {
                System.out.print("Por favor, digite o salário número " + (i + 1) + ": ");
                double salario = scanner.nextDouble();
                if (salario >= 0) {
                    salariosBrutos[i] = salario;
                    salarioValido = true;
                } else {
                    System.out.println("Valor inválido! O salário deve ser maior ou igual a zero.");
                }
            } while (!salarioValido);
        }


        //Prints para deixarem a saida mais organizada
        System.out.println();
        System.out.println("+-------------------------------+");
        System.out.println("|   Tabela Salário Bruto       |");
        System.out.println("+-------------------------------+");

        //Loop para imprimir os salários brutos
        for (int i = 0; i < 5; i++) {
            System.out.printf("| Salário Bruto %d:     R$ %.2f    |%n", (i + 1), salariosBrutos[i]);
        }
        System.out.println("+-------------------------------+");
        System.out.println();

        double[] descontoINSS = INSS(salariosBrutos);

        //Prints para deixarem a saida mais organizada
        System.out.println("+-------------------------------+");
        System.out.println("|   Tabela Desconto do INSS    |");
        System.out.println("+-------------------------------+");

        //Loop para imprimir os descontos do INSS
        for (int i = 0; i < descontoINSS.length; i++) {
            System.out.printf("| Desconto INSS %d:     R$ %.2f    |%n", (i + 1), descontoINSS[i]);
        }
        System.out.println("+-------------------------------+");
        System.out.println();

        double[] descontoImpostoDeRenda = ImpostoDeRenda(salariosBrutos);

        //Prints para deixarem a saida mais organizada
        System.out.println("+---------------------------------------+");
        System.out.println("| Tabela Desconto do Imposto de Renda   |");
        System.out.println("+---------------------------------------+");

        //Loop para imprimir os descontos do Imposto de Renda
        for (int i = 0; i < descontoImpostoDeRenda.length; i++) {
            System.out.printf("| Desconto Imposto de Renda %d:  R$ %.2f  |%n", (i + 1), descontoImpostoDeRenda[i]);
        }
        System.out.println("+---------------------------------------+");
        System.out.println();

        double[] salarioLiquido = SalarioLiquido(salariosBrutos, descontoINSS, descontoImpostoDeRenda);

        //Prints para deixarem a saida mais organizada
        System.out.println("+-------------------------------+");
        System.out.println("|   Tabela Salário Líquido      |");
        System.out.println("+-------------------------------+");

        //Loop para imprimir os salários Líquidos
        for (int i = 0; i < salarioLiquido.length; i++) {
            System.out.printf("| Salário Líquido %d:   R$ %.2f    |%n", (i + 1), salarioLiquido[i]);
        }
        System.out.println("+-------------------------------+");
    }
}
