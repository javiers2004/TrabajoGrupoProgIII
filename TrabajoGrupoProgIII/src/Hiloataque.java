import javax.swing.JLabel;

public class Hiloataque extends Thread{
	public Hiloataque(JLabel lblplayer, VentanaMapa ven, int posx, int n) {
		
		ven.setContinuar(false);
		
			if(posx > ven.getAnchoventana()/2) {
				lblplayer.setIcon(ven.getPlayer().ataqueespadader.get(n));
			}
			else {
				lblplayer.setIcon(ven.getPlayer().ataqueespadaizq.get(n));
			}
			lblplayer.setVisible(true);
			ven.setVisible(true);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (n==1) {
				ven.click = false;
				ven.setAtaquedisponible(true);
				ven.setContinuar(true);
			}	
	}
}
