
public class Hiloveneno extends Thread{
    private int contador;
    private Jugador player;
    
    public Hiloveneno(int contador, Jugador player) {
        this.contador = contador;
        this.player = player;
    }
    
    @Override
    public void run() {
    	if(contador >= 0) {
            player.setVidarestante(player.getVidarestante() -1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Hiloveneno h = new Hiloveneno(contador-1, player);
            h.start();
        }
    }
    
    
    
    
    
}
