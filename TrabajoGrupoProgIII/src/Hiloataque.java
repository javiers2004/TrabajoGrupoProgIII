import javax.swing.JLabel;

public class Hiloataque extends Thread{
	public Hiloataque(JLabel lblplayer, VentanaMapa ven, int posx) {
		

		try {
			if(posx > ven.getAnchoventana()/2) {
				lblplayer.setIcon(ven.getPlayer().ataqueespadader.get(0));
			}
			else {
				lblplayer.setIcon(ven.getPlayer().ataqueespadaizq.get(0));
			}
			ven.actualizarVentana(ven.getPlayer(), false);
			ven.setVisible(true);
			lblplayer.setVisible(true);
			Thread.sleep(30);
			ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
			ven.getMap().setVisible(true);
			Thread.sleep(30);
			ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
			ven.getMap().setVisible(true);
			Thread.sleep(30);
			ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
			ven.getMap().setVisible(true);
			if(posx > ven.getAnchoventana()/2) {
				lblplayer.setIcon(ven.getPlayer().ataqueespadader.get(1));
				}
			else {
				lblplayer.setIcon(ven.getPlayer().ataqueespadaizq.get(1));
			}
			Thread.sleep(30);
			ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
			ven.getMap().setVisible(true);
			Thread.sleep(30);
			ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
			ven.getMap().setVisible(true);
			Thread.sleep(30);
			ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
			ven.getMap().setVisible(true);
			ven.arraymovimiento = ven.arraymovimientoanterior;
			ven.click = false;
			ven.setAtaquedisponible(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}
}
