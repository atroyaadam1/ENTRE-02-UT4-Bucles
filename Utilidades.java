import java.util.Scanner;
/**
 *   Clase de utilidades
 *   Incluye métodos estáticos
 *   
 *   @author - Anthonny Troya 
 */
public class Utilidades
{

    /**
     * Dado un número n (asumimos positivo)
     * devueve true si está en octal false en otro caso
     * Un nº está en octal si cada una de sus cifras
     * es un valor entre 0 y 7
     * 
     * (usa bucles while)
     */
    public static boolean estaEnOctal(int n) {
        boolean numeracion = true;

        int num= n /10;
        int ctr = n % 10;

        while (num != 0){

            if (ctr >= 8){
                numeracion = false;
            }

            if (ctr <= 8) {
                ctr = num % 10;
                num /=  10; 
            }
        } return numeracion;
    }

    /**
     * Dado un número n (asumimos positivo)
     * devuelve la cantidad de cifras que tiene
     * 
     * (usa bucles while)
     */
    public static int contarCifras(int n) {
        int cifras = 1;
        while(n != 0){
            cifras++;
            n = n / 10;

            if ( n == 0) {
                cifras--;
            }
        }
        return cifras;
    }
}
