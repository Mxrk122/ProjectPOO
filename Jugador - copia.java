import java.util.ArrayList;

abstract class Jugador{
    //Atributos
    private int ataque;
    private int salud;
    private int defensa;
    private boolean vivo=true;
    private String clase;
    private int item;

    //Frases
    private String frasemuerto;
    String fraseatk;

    //Constructor
    public Jugador(int atack, int health, int defense, String nombre, String die, String shout){
        ataque=atack;
        salud=health;
        defensa=defense;
        clase=nombre;
        frasemuerto=die;
        fraseatk=shout;
    }

	//Metodos
    //Metodos basicos para cada jugador, acciones que todos hacen
    public int atacar(){
        return ataque;
    }

    public int recibir(int a){
        int dano=a/defensa;
        salud=salud-dano;
        return dano;
    }

    public int recibirvida(int a){
        int curacion=a;
        salud=salud+curacion;
        return curacion;
    }

    public int recibirdano(int a){
        int dano=a;
        salud=salud-dano;
        return dano;
    }

    public String toString(){
        return "Mi clase es "+clase+", poseo "+salud+" puntos de vida y "+ataque+" puntos de ataque.";
    }

    public boolean vigente(){//Metodo que devuelve si el jugador sigue vivo o esta muerto
        if(salud<=0){
            vivo=false;
        } else{
            vivo=true;
        }
        return vivo;
    }

    //Metodos para el jugador 1
    public abstract int habilidad();
    
    //Metodos para el boss
    public void absorber(int a){
        item=a;
    }

    //Metodos para jefe y cazador

    //Gets & Sets
    public String getFraseatk(){
        return fraseatk;
    }

    public String getFrasedie(){
        return frasemuerto;
    }

    public String getClase(){
        return clase;
    }

    //Metodos para cambiar las propiedades de las demas clases
    public void setAtaque(int a){
        ataque=a;
    }

    public void setSalud(int a){
        salud=a;
    }

    public void setDefensa(int a){
        defensa=a;
    }

    public int getitem(){
        return item;
    }
}