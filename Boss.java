import java.util.ArrayList;

class Boss extends Jugador{
    public Boss(){
        super(150, 300, 5, "RAID BOSS", "MORI ESTA VEZ, PERO EN LA SIGUIENTE PARTIDA ACABARE CONTIGO", "GOLPE DE KARATE");
    }
    //Echizos o poderes

    //Metodos
    public int habilidad(){
        return 5;
    }

}