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

        char opcion = 'S';
        while(opcion == 'S' || opcion == 's') {
            Pantalla.borrarPantalla();
        }
        System.out.println("Teclee el primer numero : ");
        int primerNumero = teclado.nextInt();
        System.out.println("Teclee el segundo numero : ");
        int segundoNumero = teclado.nextInt();
        System.out.println("Desea hacer otra suma en octal ? (S/s) ");
        opcion = teclado.next().charAt(0);

    }

    /** Método privado para comprobar si el numero de la clase es octal o no
     */
    private void compNumero (int numero1,int numero2){
        if (!Utilidades.estaEnOctal(numero1)){
            System.out.println("Alguno de los dos números no esta en octal");
        } else if (!Utilidades.estaEnOctal(numero2)){
            System.out.println("Alguno de los dos números no esta en octal");
        } else {
            if(Utilidades.estaEnOctal(numero1) && Utilidades.estaEnOctal(numero2)){
                cifrasContadas(numero1,numero2);
            }
        }
    }

    /**
     * 
     */
    public void cifrasContadas(int numero1,int numero2) {
        if(Utilidades.contarCifras(numero1) != Utilidades.contarCifras(numero2)) {
            System.out.println("NO TIENEN EL MISMO NUMERO DE CIFRAS");
        } else {
            if(Utilidades.contarCifras(numero1) == Utilidades.contarCifras(numero2)){
                int sumatoriaTotal = calculadora.sumarEnOctal(numero1,numero2);
                System.out.println("==================================================");
                String str = String.format("%30d\n%30d\n%21s%9d",numero1,numero2,
                        "suma en octal",sumatoriaTotal);
                System.out.println("==================================================");

            }
        }
    }

    /**
     *  Pide al usuario un valor de altura, 
     *  valida que sea correcto (un valor entre 1 y 10)
     *  y muestra la figura en pantalla
     */

    private void dibujarFiguras()
    {
        System.out.println("Dibuje una figura\n Altura de la figura? (1-10) ");
        int altura = teclado.nextInt();
        while(altura > 10 || altura < 1){
            System.out.println("Error, Altura de la figura? (1-10) ");
            altura = teclado.nextInt();
        }
        pintor.dibujarFigura(altura); 
    }

}
