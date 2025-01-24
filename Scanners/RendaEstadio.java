import java.util.Scanner;

public class RendaEstadio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos bilhetes da Classe A foram vendidos? ");
        int bilheteA = scanner.nextInt();
        
        System.out.print("Quantos bilhetes da Classe B foram vendidos? ");
        int bilheteB = scanner.nextInt();
        
        System.out.print("Quantos bilhetes da Classe C foram vendidos? ");
        int bilheteC = scanner.nextInt();

        int precoA = 50;
        int precoB = 30;
        int precoC = 20;

        int rendaA = bilheteA * precoA;
        int rendaB = bilheteB * precoB;
        int rendaC = bilheteC * precoC;

        int rendaTotal = rendaA + rendaB + rendaC;

        System.out.println("\nRenda gerada pela venda dos ingressos:");
        System.out.println("Classe A: R$" + rendaA);
        System.out.println("Classe B: R$" + rendaB);
        System.out.println("Classe C: R$" + rendaC);
        System.out.println("Renda total: R$" + rendaTotal);

        scanner.close();
    }
}
