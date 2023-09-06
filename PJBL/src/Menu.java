import java.util.Scanner;

public class Menu {
    private int[][] matrix = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public boolean runMenu() {
        FloodFill floodFill = new FloodFill(matrix);
        System.out.println("Matriz inicial:");
        floodFill.printMatrix();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor para substituir: ");
        int newValue = scanner.nextInt();

        System.out.print("Escolha o método (1 para pilha, 2 para fila): ");
        int methodChoice = scanner.nextInt();

        System.out.print("Digite a posição inicial (linha e coluna separadas por espaço): ");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();

        boolean useStack = methodChoice == 1;
        floodFill.floodFill(startX, startY, newValue, useStack);

        if (useStack) {
            System.out.println("\nMatriz após FloodFill com pilha:");
        } else {
            System.out.println("\nMatriz após FloodFill com fila:");
        }

        floodFill.printMatrix();

        System.out.print("\nDeseja continuar? (Digite 's' para sim ou 'n' para não): ");
        String response = scanner.next().toLowerCase();
        return response.equals("s");
    }
}