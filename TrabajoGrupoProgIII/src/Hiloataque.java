import javax.swing.JLabel;

public class Hiloataque extends Thread{
	public Hiloataque(JLabel lblplayer, VentanaMapa ven, int posx) {
		
		if(posx > ven.getAnchoventana()/2) {
		lblplayer.setIcon(ven.getPlayer().ataqueespadader.get(0));
		}
		else {
		lblplayer.setIcon(ven.getPlayer().ataqueespadaizq.get(0));
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
		ven.getMap().setVisible(true);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
		ven.getMap().setVisible(true);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
		ven.getMap().setVisible(true);
		if(posx > ven.getAnchoventana()/2) {
		lblplayer.setIcon(ven.getPlayer().ataqueespadader.get(1));
		}
		else {
		lblplayer.setIcon(ven.getPlayer().ataqueespadaizq.get(1));
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
		ven.getMap().setVisible(true);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
		ven.getMap().setVisible(true);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ven.getMap().setLocation(-ven.player.getPosx(), -ven.player.getPosy());
		ven.getMap().setVisible(true);
		ven.arraymovimiento = ven.arraymovimientoanterior;
	}
}
