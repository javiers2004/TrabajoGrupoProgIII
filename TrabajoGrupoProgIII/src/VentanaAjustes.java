import javax.swing.*;

public class VentanaAjustes {

    private VentanaAudio player;
    private JFrame frame;

    public VentanaAjustes(VentanaAudio player) {
        this.player = player;
        frame = new JFrame("Ventana de Ajustes");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        colocarComponentes(panel);

        frame.setVisible(true);
    }

    private void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel musicLabel = new JLabel("Music");
        musicLabel.setBounds(10, 20, 80, 25);
        panel.add(musicLabel);

        JSlider musicSlider = new JSlider(0, 100, 50);
        musicSlider.setBounds(100, 20, 165, 25);
        musicSlider.addChangeListener(e -> {
            float volume = (float) (musicSlider.getValue() / 100.0);
            player.setVolume(volume);
        });
        panel.add(musicSlider);

        // ... (resto del código para agregar otros componentes)
        frame.setVisible(true);

    }
    public void setVisible(boolean isVisible) {
        frame.setVisible(isVisible);
    }

}
