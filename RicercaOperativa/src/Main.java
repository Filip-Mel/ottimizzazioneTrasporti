import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nInserisci il numero di unità produttive seguito da quello di distributori:");
        System.out.print("\nNumero di U.P. : ");
        int s = scanner.nextInt();
        System.out.print("Numero di D : ");
        int r = scanner.nextInt();
        double x;
        Problemalivello1 test = new Problemalivello1(s, r);

        System.out.println("\nInserisci i totali delle produzioni delle singole U.P.:");
        for (int i = 0; i < test.stockSize; i++){
            System.out.print(i+1 + ":");
            x = scanner.nextDouble();
            test.setStock(x, i);
        }

        System.out.println("\nInserisci le richieste delle singole D:");
        for (int i = 0; i < test.requiredSize; i++){
            System.out.print(i+1 + ":");
            x = scanner.nextDouble();
            test.setRequired(x, i);
        }

        System.out.println("\nInserisci i costi di trasporto:");
        for (int i = 0; i < test.stockSize; i++){
            System.out.println("\nU.P." + (i+1) + ")");
            for (int j = 0; j < test.requiredSize; j++) {
                System.out.print("D" + (j+1) + ":");
                x = scanner.nextDouble();
                test.setCost(x, i, j);
            }}

        test.northWestCorner();
        for(Transportation t: test.solution){
            System.out.println(t);
        }

        System.out.println("\nCosto totale: " + test.getSolution());

    }
}
