import java.awt.Color;
import javax.swing.SwingUtilities;

public class HiloSubidaNivel extends Thread {
    private PanelInfoVentanaMapa veninfo;
    private VentanaMapa ven1;
    private Jugador player;

    public HiloSubidaNivel(PanelInfoVentanaMapa veninfo, VentanaMapa ven1, Jugador player) {
        this.veninfo = veninfo;
        this.ven1 = ven1;
        this.player = player;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            final Color color = (i % 2 == 0) ? Color.YELLOW : Color.ORANGE;

            SwingUtilities.invokeLater(() -> {
                // Actualizar componentes de UI
                veninfo.niveljugador.setText("Nivel: " + player.getNivel() + " ¡NUEVO NIVEL!");
                veninfo.panelnivel.setBackground(color);
                veninfo.panelvida.setBackground(color);
                veninfo.panelstamina.setBackground(color);
                veninfo.panelexperiencia.setBackground(color);
            });

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        SwingUtilities.invokeLater(() -> {
            // Restablecer colores de los paneles
            veninfo.panelnivel.setBackground(Color.WHITE);
            veninfo.panelvida.setBackground(Color.WHITE);
            veninfo.panelstamina.setBackground(Color.WHITE);
            veninfo.panelexperiencia.setBackground(Color.WHITE);
        });

        // Actualizar estado del jugador
        player.setStaminarestante(player.getStaminatotal());
        player.setStaminatotal(player.getStaminatotal() + 5);
        player.setVidatotal(player.getVidatotal() + 5);
        player.setVidarestante(player.getVidatotal());
    }
}