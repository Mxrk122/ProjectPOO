class Acompañante {
    private int ataque;
    private int salud;
    private boolean vivo=true;

    public int atacar(){
        return ataque;
    }

    public int recibir(int a){
        int dano=a;
        salud=salud-dano;
        return dano;
    }
}
