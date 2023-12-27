import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Hiloataque extends Thread {
    private JLabel lblplayer;
    private VentanaMapa ven;
    private int posx;
    private int n;

    public Hiloataque(JLabel lblplayer, VentanaMapa ven, int posx, int n) {
        this.lblplayer = lblplayer;
        this.ven = ven;
        this.posx = posx;
        this.n = n;
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (posx > ven.getAnchoventana() / 2) {
                    lblplayer.setIcon(ven.getPlayer().ataqueespadader.get(n));
                } else {
                    lblplayer.setIcon(ven.getPlayer().ataqueespadaizq.get(n));
                }
                lblplayer.setVisible(true);
                ven.setVisible(true);
            }
        });

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();  // Consider a better error handling approach
        }

        if (n == 1) {
            ven.click = false;
            ven.setAtaquedisponible(true);
            // ven.setContinuar(true);
        }
    }
}