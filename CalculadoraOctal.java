
/**
 *  Representa a una calcualdora que hace sumas octales
 * 
 * @author - Anthonny Troya
 * 
 */
public class CalculadoraOctal
{

    /**
     * sumar dos nºs supuestos en base 8 y con el mismo
     * nº de cifras
     * Asumimos positivos
     */
    public int sumarEnOctal(int n1, int n2) {
        int suma = 0;
        int numg = 0;
        int potencia = 1;

        for (int num = 1; num < Utilidades.contarCifras(n1) && 
        num < Utilidades.contarCifras(n2); num++){
            int num1 = (n1 % 10)  ;
            int num2 = (n2 % 10) ; 

            numg *= 10;
            suma += ((num1 + num2) + Math.pow(10,num + 1));
        } if (suma > 7) {
            potencia++;
        } else {
            suma = suma * (int) (Math.pow (10,potencia) );
            potencia++;
        }
        suma += potencia * numg;
        return suma;
    }      
}
