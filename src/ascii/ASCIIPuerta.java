package ascii;

import personas.Jugador;

public class ASCIIPuerta {
    
    // Atributos
    Jugador jugador;
    
    public ASCIIPuerta(Jugador jugador){
        this.jugador = jugador;
    }

    public void titulo(){
        System.out.println(" ____                  _          ____        _ _     _       ");
        System.out.println("|  _ \\ _   _  ___ _ __| |_ __ _  / ___|  __ _| (_) __| | __ _ ");
        System.out.println("| |_) | | | |/ _ \\ '__| __/ _` | \\___ \\ / _` | | |/ _` |/ _` |");
        System.out.println("|  __/| |_| |  __/ |  | || (_| |  ___) | (_| | | | (_| | (_| |");
        System.out.println("|_|    \\__,_|\\___|_|   \\__\\__,_| |____/ \\__,_|_|_|\\__,_|\\__,_|");
    }

    public void opcioes(){
        System.out.println("------------------------------");
        System.out.println(jugador);
        System.out.println("\n-----------------------------");
        System.out.println("1. Guardar Partida");
        System.out.println("2. Cargar Partida");
        System.out.println("3. Salir del Casino");
        System.out.println("3. Salir opciones");
    }
}
