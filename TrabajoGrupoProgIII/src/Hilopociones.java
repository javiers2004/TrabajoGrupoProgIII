public class Hilopociones extends Thread {

    private int vida;
    private Jugador player;

    public Hilopociones(int vida, Jugador player) {
        this.vida = vida;
        this.player = player;
    }

    @Override
    public void run() {
        while (vida > 0) {
            synchronized (player) {
                player.setVidarestante(player.getVidarestante() + 10);
                if (player.getVidarestante() > player.getVidatotal()) {
                    player.setVidarestante(player.getVidatotal());
                }
            }
            vida -= 10;
            try {
                Thread.sleep(1000); // Consider using a more meaningful sleep duration
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}