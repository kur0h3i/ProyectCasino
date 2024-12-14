// Slot.java
package juegos;

import ascii.ASCIIGeneral;
import ascii.ASCIISlot;
import java.util.Random;
import java.util.Scanner;
import excep.ExcepcionJugadorSinFichas;
import personas.Jugador;

public class Slot extends Juego {

    private int apuesta;
    private Jugador jugador;
    private ASCIISlot interfaz;

    public Slot(Jugador jugador) {
        super(jugador);
        this.jugador = jugador;
        this.interfaz = new ASCIISlot(jugador);
    }

    @Override
    public void iniciarPartida() throws ExcepcionJugadorSinFichas {
        Scanner input = new Scanner(System.in);
        
        comprobarfichas();
        
        boolean continuar = true;
        while (continuar) {
            ASCIIGeneral.limpiarPantalla();
            interfaz.titulo();
            interfaz.opcioes();

            try {
                int opcion = input.nextInt();
                input.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        ASCIIGeneral.limpiarPantalla();
                        interfaz.titulo();
                        realizarApuesta(input);
                        ASCIIGeneral.esperarTecla();
                        break;
                    case 2:
                        ASCIIGeneral.limpiarPantalla();
                        interfaz.titulo();
                        interfaz.cheetsheet();
                        ASCIIGeneral.esperarTecla();
                        break;
                    case 3:
                        continuar = false;
                        System.out.println("Gracias por jugar a Slot. ¡Hasta la próxima!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                input.nextLine();
            }
        }
    }

    private void realizarApuesta(Scanner input) {
        System.out.println("¿Cuántas fichas deseas apostar?");
        System.out.println("Tienes " + jugador.getFichas() + " fichas disponibles.");

        try {
            apuesta = input.nextInt();
            input.nextLine(); // Limpiar buffer

            if (apuesta <= 0 || apuesta > jugador.getFichas()) {
                System.out.println("Apuesta no válida. Intenta de nuevo.");
                return;
            }

            jugador.restarFichas(apuesta);
            jugarSlot();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Intenta de nuevo.");
            input.nextLine();
        }
    }

    private void jugarSlot() {
        Random random = new Random();
        String[] simbolos = {"X", "!", "?", "*"};

        String simbolo1 = simbolos[random.nextInt(simbolos.length)];
        String simbolo2 = simbolos[random.nextInt(simbolos.length)];
        String simbolo3 = simbolos[random.nextInt(simbolos.length)];

        interfaz.mostrarResultados(simbolo1, simbolo2, simbolo3);

        if (simbolo1.equals(simbolo2) && simbolo2.equals(simbolo3)) {
            int premio = calcularPremio(simbolo1);
            System.out.println("¡Felicidades! Ganaste " + premio + " fichas.");
            jugador.agregarFichas(premio);
        } else if (simbolo1.equals(simbolo2) || simbolo2.equals(simbolo3) || simbolo1.equals(simbolo3)) {
            System.out.println("¡Has recuperado tu apuesta!");
            jugador.agregarFichas(apuesta);

        } else {
            System.out.println("Lo siento, no ganaste esta vez.");
        }
    }

    private int calcularPremio(String simbolo) {
        switch (simbolo) {
            case "X":
                return apuesta * 10; // Jackpot
            case "!":
                return apuesta * 7; // Mega premio
            case "?":
                return apuesta * 5; // Buen premio
            case "*":
                return apuesta * 3; // Premio base
            default:
                return 0;
        }
    }

}