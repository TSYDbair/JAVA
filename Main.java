import java.util.Random;
import java.util.Scanner;
import java.util.Random;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        char[] m={'q','w','e','a','s','d','z','x','c'};
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        Scanner d = new Scanner(System.in);
        Random e=new Random();
        for (;;) {
            char p= d.next().charAt(0);
            int l=0;
            for (int i = 0; i < 9; i++) {
                if (m[i] == p) {
                    l = i;
                    m[i] = 0;
                }
            }
            while(l!=1000){
                int r = e.nextInt(8)+0;
                System.out.println(r);
                if(m[r]!=0 && m[r]!=1){
                    m[r]=1;
                    break;
                }
            }for(int i=0;i<9;i++){
                if(m[i]==0){
                    System.out.print(" O ");
                }else{
                    if(m[i]==1){
                        System.out.print(" X ");
                    }else{
                        System.out.print(" "+(m[i])+" ");
                    }
                }
                if(i==2 || i==5 || i==8){
                    System.out.println("");
                }
            }

        }
    }
}