class Mascota {
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

    public boolean vigente(){//Metodo que devuelve si la mascota sigue vivo o esta muerto
        if(salud<=0){
            vivo=false;
        } else{
            vivo=true;
        }
        return vivo;
    }
}
