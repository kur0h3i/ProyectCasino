package jugadores;

public class Jugador {
    
    // Atributos
    String nombre;
    int edad;
    float dinero;
    int fichas;

    // Constructor
    public Jugador(String nombre, int edad, float dinero){
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    // Metodos


    // Setters
    public void setNombre( String nombre){
        this.nombre = nombre;
    }
    public void setEdad( int edad){
        this.edad = edad;
    }
    public void setDinero( float dinero){
        this.dinero = dinero;
    }
    public void setFichas( int fichas){
        this.fichas = fichas;
    }

    // Getters
    public String getName(){
        return this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }
    public float getDinero(){
        return this.dinero;
    }
    public int getFichas(){
        return this.fichas;
    }

    // to String
    @Override
    public String toString(){
        return "Jugador : " 
                + this.nombre
                + "Edad  : "
                + this.edad
                + "Dinero : "
                + this.dinero
                + "Fichas"
                + this.fichas;
    }
}