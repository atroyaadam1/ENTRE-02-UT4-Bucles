import java.util.Scanner;
/**
 * Modela el interfaz para interactuar con el usuario
 * @author - ANTHONNY TROYA
 */
public class IUTexto
{
    private Scanner teclado;
    private CalculadoraOctal calculadora;
    private PintorFiguras pintor;

    /**
     * Constructor  
     */
    public IUTexto(CalculadoraOctal calculadora, PintorFiguras pintor)
    {
        this.teclado = new Scanner(System.in);
        this.calculadora = calculadora;
        this.pintor = pintor;
    }

    /**
     * Controla la lógica de la aplicación
     */
    public void iniciar()
    {
        hacerSumasOctales();
        dibujarFiguras();

    }

    /**
     *  - borrar la pantalla
     *  - pedir al usuario un par de números
     *  - si los números no están en octal mostrar un mensaje
     *  - si los números no tienen el mismo número de cifras mostrar un mensaje
     *  - si son correctos calcular su suma octal y mostrar el resultado en pantalla
     *  - los pasos anteriores se repiten mientras el usuario quiera (pulsa 'S' o 's')
     *  
     */
    private void hacerSumasOctales()
    {

        char opcion = 'S' ;

        while(opcion == 'S' || opcion == 's') {
            System.out.println("Teclee el primer numero : ");
            int primerNumero = teclado.nextInt();

            System.out.println("Teclee el segundo numero : ");
            int segundoNumero = teclado.nextInt();

            if (Utilidades.estaEnOctal(primerNumero) &&
            Utilidades.estaEnOctal(segundoNumero)){
                System.out.println("---------------------------------------------------");
               System.out.printf("%30d\n%30d\n%21s%9d\n",primerNumero,segundoNumero,"suma en octal",
                        calculadora.sumarEnOctal(primerNumero,segundoNumero));
            }   
            else{
                System.out.println("Alguno de los dos números no esta en octal");
            } if(Utilidades.contarCifras(primerNumero) != Utilidades.contarCifras(segundoNumero)) {
                System.out.println("No tienen el mismo nº de cifras");
            }
            System.out.println("\n\nQuiere hacer otra suma en octal? (S/s)");
            String cadena = this.teclado.next();
            opcion = cadena.charAt(0);
            System.out.print('\u000C');
        } 

    }

    /**
     *  Pide al usuario un valor de altura, 
     *  valida que sea correcto (un valor entre 1 y 10)
     *  y muestra la figura en pantalla
     */

    private void dibujarFiguras()
    {
        Pantalla.borrarPantalla();
        System.out.println("Dibuje una figura\n Añada la Altura de la figura? (1-10) ");
        int altura = teclado.nextInt();
        while(altura <1|| altura >10){
            System.out.println("Error, Altura de la figura? (1-10) ");
            altura = teclado.nextInt();
        }
        pintor.dibujarFigura(altura); 
    }

}
