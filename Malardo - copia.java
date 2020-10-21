import java.util.ArrayList;

class Malardo extends Jugador{
    int item=1;//Define su item y se usa varias veces
    public Malardo(){
        super(150, 300, 5, "El Dr Racso", "NOOO ME MORI XDXDXDXD", "Ve a fastidiar a otro lado");
    }

    //Metodos
    public int habilidad(){
        int efecto=0;
        efecto=item;
        return efecto;
    }
}