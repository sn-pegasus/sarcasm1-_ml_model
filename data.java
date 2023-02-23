import java.io.*;
import java.util.*;

class data {
    public static void main(String[] args) throws IOException {
        String ln;
        String[][] data = new String[150][5];
        final String filename = "D:\\Files\\Sem-4\\Web Technology Lab\\Activity 1\\iris.csv";
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < 150; ++i) {
            ln = br.readLine();
            String[] dl = ln.split(",");
            for (int j = 0; j < 5; ++j) {
                data[i][j] = dl[j];
            }
        }
        String f1[][] = new String[50][5];
        String f2[][] = new String[50][5];
        String f3[][] = new String[50][5];
        for (int i = 0; i < 50; i++)
            for (int j = 0; j < 5; j++) {
                f1[i][j] = data[i][j];
                f2[i][j] = data[i + 50][j];
                f3[i][j] = data[i + 100][j];
            }
        System.out.println("************Setosa :*************");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(f1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("************Virginica :*************");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(f2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("************Versicolor :*************");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(f3[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Enter the Percentage : ");
        int p;
        Scanner in = new Scanner(System.in);
        p = in.nextInt();
        String training[][] = new String[150][5];
        float test_length, training_length;
        training_length = p * 150 / 100;
        test_length = ((100 - (float) p) * 150) / 100;
        System.out.println("P=" + (p * 150) / 100);
        System.out.println("Q=" + test_length);
        String test[][] = new String[150][5];
        for (int i = 0; i < training_length; i++)
            for (int j = 0; j < 5; j++)
                training[i][j] = data[i][j];
        for (int i = (int) training_length; i < 150; i++)
            for (int j = 0; j < 5; j++)
                test[i - (int) (Math.floor(training_length))][j] = data[i][j];
        System.out.println("************Training Set :*************");
        for (int i = 0; i < training_length; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(training[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("************Test Set :*************");
        for (int i = 0; i < 150 - (int) training_length; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
        br.close();
        in.close();
    }
}