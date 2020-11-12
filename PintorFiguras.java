
/**
 *  Clase que dibuja una figura 
 * 
 * @author - 
 *  
 */
public class PintorFiguras
{
    private static final int ANCHO_BLOQUE = 4;
    private static final char ESPACIO = ' ';
    private static final char CAR1 = 'B';
    private static final char CAR2 = '=';

    /**
     * Dibuja una figura (ver enunciado) de altura
     * indicada (se asume la altura un valor correcto)
     * 
     * (usa bucles for)
     */
    public  void dibujarFigura(int altura) {
        int alt = (altura * 2) - 2;

        for (int i = 1; i <= altura; i++){
            escribirEspacios(ESPACIO,alt);

            for (int pt = 1; pt <= i; pt++){
                if (pt % 2 == 0){
                    for (int q = 1; q <= ANCHO_BLOQUE; q++){
                        System.out.print(CAR2);
                    }
                } 
                if (pt % 2 != 0){
                    for(int t = 1; t <= ANCHO_BLOQUE; t++){
                        System.out.print(CAR1);
                    }
                } 

            }
            alt -= 2;
            System.out.println();
        }
    }

    /**
     * Método privado de ayuda que escribe n espacios en la misma línea
     */
    private  void escribirEspacios(char caracter, int n) {
        for (int var = 1; var <= n; var++){
            System.out.print(caracter);
        }
    }
}

