import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMuerte extends JPanel{
	 public PanelMuerte(VentanaMapa ven1, VentanaInicio ven2) {
	        setLayout(new BorderLayout());

	        JLabel etiquetaMuerte = new JLabel("Has muerto @" + ven1.getVeninicio().nombreUsuario);
	        etiquetaMuerte.setFont(new Font("Arial", Font.BOLD, 50));
	        etiquetaMuerte.setForeground(Color.RED);
	        etiquetaMuerte.setHorizontalAlignment(JLabel.CENTER);
	        add(etiquetaMuerte, BorderLayout.CENTER);

	        JButton boton = new JButton("MENÚ INICIO");
	        boton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                ven1.setVisible(false);
	                ven2.setVisible(true);

	            }
	        });
	        add(boton, BorderLayout.SOUTH);
	        boton.setVisible(true);
	    }
}
