public class Hilopociones extends Thread {

    private int vida;
    private Jugador player;

    public Hilopociones(int vida, Jugador player) {
        this.vida = vida;
        this.player = player;
    }

    @Override
    public void run() {
    	if(vida > 0) {
            player.setVidarestante(player.getVidarestante() + 10);
            if(player.getVidarestante() > player.getVidatotal()) {
                player.setVidarestante(player.getVidatotal());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Hilopociones h = new Hilopociones(vida-10, player);
            h.start();
        }
    }
}