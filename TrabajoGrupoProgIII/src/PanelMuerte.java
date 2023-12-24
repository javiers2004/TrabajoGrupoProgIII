import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMuerte extends JPanel{
	 public PanelMuerte(VentanaMapa ven1, VentanaInicio ven2, String nombreUsuario) {
	        setLayout(new BorderLayout());
	        JLabel etiquetaMuerte = new JLabel("Has muerto @" + ven1.getVeninicio().nombreUsuario);
	        etiquetaMuerte.setFont(new Font("Arial", Font.BOLD, 50));
	        etiquetaMuerte.setForeground(Color.RED);
	        etiquetaMuerte.setHorizontalAlignment(JLabel.CENTER);
	        etiquetaMuerte.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
	        add(etiquetaMuerte);
	        JPanel panelcentral = new JPanel();
	        panelcentral.setLayout(new BorderLayout());
	        panelcentral.add(etiquetaMuerte, BorderLayout.CENTER);
	        add(panelcentral, BorderLayout.CENTER);
	        JButton boton = new JButton("MENÚ INICIO");
	        boton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                ven1.setVisible(false);
	                ven2.setVisible(true);

	            }
	        });
	        JButton botonest = new JButton("ESTADÍSTICAS DE LA PARTIDA");
	        botonest.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
					try {
						VentanaEstadisticas venest = new VentanaEstadisticas(nombreUsuario);
						venest.setVisible(true);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
	            }
	        });
	        JPanel panelbotones = new JPanel();
	        panelbotones.setLayout(new FlowLayout());
	        panelbotones.add(boton);
	        panelbotones.add(botonest);
	        add(panelbotones, BorderLayout.SOUTH);
	        botonest.setVisible(true);
	    }
}
