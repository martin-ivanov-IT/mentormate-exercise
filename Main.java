import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        Cell[][] matrix = new Cell[x][y];
        int N = Integer.parseInt(scanner.nextLine());

        matrix = readMatrix(scanner, x, y);


        int x1 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        int cnt = 0;

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                int value = matrix[i][j].value;
//                System.out.print(value + " ");
//            }
//            System.out.println();
//
//        }
        determinateSurrounders(matrix);
        if (isGreen(matrix[y2][x1])){
            cnt++;
        }
        for (int c = 0; c <N ; c++) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int value = matrix[i][j].value;
                    int red = matrix[i][j].redSurrounders;
                    int green = matrix[i][j].greenSurrounders;
                    System.out.print(value + " ");
                }
                System.out.println();

            }
            generate(matrix);
            determinateSurrounders(matrix);

            if (isGreen(matrix[y2][x1])){
                cnt++;
            }
        }

        System.out.println(cnt);




    }

    private static Cell[][] readMatrix(Scanner scanner, int rows, int colls) {


        Cell[][] firstMatrix = new Cell[rows][colls];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                Cell currCell = new Cell();
                currCell.x = i;
                currCell.y = j;
                currCell.value = scanner.nextInt();
                firstMatrix[i][j] = currCell;
            }


        }
        scanner.nextLine();
        return firstMatrix;
    }

    public static boolean isRed(Cell cell) {
        if (cell.value == 1) {
            return false;
        }
        return true;
    }

    public static boolean isGreen(Cell cell) {
        if (cell.value == 0) {
            return false;
        }
        return true;
    }

    public static void determinateSurrounders(Cell[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j].value;
                matrix[i][j].greenSurrounders=0;
                matrix[i][j].redSurrounders=0;


                //right j+1

                if ((j + 1) < matrix[i].length) {

                    if (isGreen(matrix[i][j + 1])) {
                        matrix[i][j].greenSurrounders++;
                    } else {
                        matrix[i][j].redSurrounders++;
                    }

                }


                //right-over j+1 i-1
                if ((j + 1) < matrix[i].length && (i - 1) >= 0) {

                    if (isGreen(matrix[i - 1][j + 1])) {
                        matrix[i][j].greenSurrounders++;
                    } else {
                        matrix[i][j].redSurrounders++;
                    }

                }

                //right-under j+1 i+1
                if ((j + 1) < matrix[i].length && (i + 1) < matrix.length) {

                    if (isGreen(matrix[i + 1][j + 1])) {
                        matrix[i][j].greenSurrounders++;
                    } else {
                        matrix[i][j].redSurrounders++;
                    }

                }

                //left j-1
                if ((j - 1) >= 0) {

                    if (isGreen(matrix[i][j - 1])) {
                        matrix[i][j].greenSurrounders++;
                    } else {
                        matrix[i][j].redSurrounders++;
                    }

                }

                //left-over j-1 i-1
                if ((j - 1) >= 0 && (i - 1) >= 0) {
                    if (isGreen(matrix[i - 1][j - 1])) {
                        matrix[i][j].greenSurrounders++;
                    } else {
                        matrix[i][j].redSurrounders++;
                    }
                }


                //left-under j-1 i+1
                if ((j - 1) >= 0 && (i + 1) < matrix.length) {
                    if (isGreen(matrix[i + 1][j - 1])) {
                        matrix[i][j].greenSurrounders++;
                    } else {
                        matrix[i][j].redSurrounders++;
                    }
                }


                //over i-1
                if ((i - 1) >= 0) {

                    if (isGreen(matrix[i - 1][j])) {
                        matrix[i][j].greenSurrounders++;
                    } else {
                        matrix[i][j].redSurrounders++;
                    }

                }

                //under i+1

                if ((i + 1) < matrix.length) {

                    if (isGreen(matrix[i + 1][j])) {
                        matrix[i][j].greenSurrounders++;
                    } else {
                        matrix[i][j].redSurrounders++;
                    }

                }


            }


        }
    }

    public static void generate (Cell[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j].value;
                int red = matrix[i][j].redSurrounders;
                int green = matrix[i][j].greenSurrounders;

                if (isRed(matrix[i][j])){
                    if (green==6||green==3){
                        matrix[i][j].value = 1;
                    }
                }

                if (isGreen(matrix[i][j])){
                    if (green!=2&&green!=3&&green!=6){
                        matrix[i][j].value = 0;
                    }
                }


            }


        }

    }

}






