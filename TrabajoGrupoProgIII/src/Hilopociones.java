public class Hilopociones extends Thread{

    public Hilopociones(int vida,  Jugador player) {
        if(vida > 0) {
            player.setVidarestante(player.getVidarestante() + 10);
            if(player.getVidarestante() > player.getVidatotal()) {
                player.setVidarestante(player.getVidatotal());
            }
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Hilopociones h = new Hilopociones(vida-10, player);
            h.start();
        }



    }
}