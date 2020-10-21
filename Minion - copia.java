import java.util.Random;
class Minion {
    Random rand=new Random();
    private int ataque;
    private int salud;
    private boolean vivo=true;
    private int poder;

    public Minion(){
        poder=rand.nextInt(3)
    }

    public int atacar(){
        return ataque;
    }

    public int recibir(int a){
        int dano=a;
        salud=salud-dano;
        return dano;
    }

    public int getPoder(){
        return poder;
    }
}
