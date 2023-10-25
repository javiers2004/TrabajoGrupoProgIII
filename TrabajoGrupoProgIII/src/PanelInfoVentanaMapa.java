import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PanelInfoVentanaMapa extends JPanel{
	protected JPanel panelvida = new JPanel();
	protected JPanel panelstamina = new JPanel();
	protected JPanel panelexperiencia = new JPanel();
	protected JLabel labelvida = new JLabel("Vida");
	protected JLabel labelstamina = new JLabel("Stamina");
	protected JLabel labelexperiencia = new JLabel("Experiencia");
	protected JProgressBar barravida;
	protected JProgressBar barrastamina;
	protected JProgressBar barraexperiencia;
	protected JLabel canvida = new JLabel();
	protected JLabel canstamina = new JLabel();
	protected JLabel canexperiencia = new JLabel();
	
	public PanelInfoVentanaMapa(Jugador player) {
		this.setLayout(new GridLayout(3,1));
		panelvida.setLayout(new BorderLayout());
		panelstamina.setLayout(new BorderLayout());
		panelexperiencia.setLayout(new BorderLayout());
		this.setBackground(Color.GRAY);
		panelvida.add(labelvida, BorderLayout.WEST);
		panelvida.add(canvida, BorderLayout.CENTER);
		panelstamina.add(labelstamina, BorderLayout.WEST);
		panelstamina.add(canstamina, BorderLayout.CENTER);
		panelexperiencia.add(labelexperiencia, BorderLayout.WEST);
		panelexperiencia.add(canexperiencia, BorderLayout.CENTER);
		this.add(panelvida);
		this.add(panelstamina);
		this.add(panelexperiencia);
		this.setSize(300,100);
		barravida = new JProgressBar(0, player.getVidatotal());
		barravida.setForeground(Color.GREEN);
		barrastamina = new JProgressBar(0, (int)player.getStaminatotal());
		barrastamina.setForeground(Color.RED);
		barraexperiencia = new JProgressBar(0, 1000);
		barraexperiencia.setForeground(Color.BLUE);
		panelvida.add(barravida, BorderLayout.EAST);
		panelstamina.add(barrastamina, BorderLayout.EAST);
		panelexperiencia.add(barraexperiencia, BorderLayout.EAST);
	}
	
	public void actualizarPanelInfo(Jugador player) {

		barravida.setValue(player.getVidarestante());
		barrastamina.setValue((int)player.getStaminarestante());
		System.out.println(player.getStaminarestante());
		barraexperiencia.setValue(player.getExperiencia());
		canvida.setText("                                 " + String.valueOf(player.getVidarestante()));
		canstamina.setText("                        " + String.valueOf(player.getStaminarestante()));
		canexperiencia.setText("                    " + String.valueOf(player.getExperiencia()));

		this.repaint();
	}
}
