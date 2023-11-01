import java.awt.Color;

import javax.swing.JFrame;

public class HiloSubidaNivel extends Thread{
	
		public HiloSubidaNivel(PanelInfoVentanaMapa veninfo, VentanaMapa ven1) {

			for (int i = 0; i<10;i++) {	
				veninfo.panelnivel.setBackground(Color.YELLOW);
				veninfo.panelvida.setBackground(Color.YELLOW);
				veninfo.panelstamina.setBackground(Color.YELLOW);
				veninfo.panelexperiencia.setBackground(Color.YELLOW);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				veninfo.panelnivel.setBackground(Color.ORANGE);
				veninfo.panelvida.setBackground(Color.ORANGE);
				veninfo.panelstamina.setBackground(Color.ORANGE);
				veninfo.panelexperiencia.setBackground(Color.ORANGE);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			veninfo.panelnivel.setBackground(Color.WHITE);
			veninfo.panelvida.setBackground(Color.WHITE);
			veninfo.panelstamina.setBackground(Color.WHITE);
			veninfo.panelexperiencia.setBackground(Color.WHITE);
			
			ven1.getPlayer().setStaminarestante(ven1.getPlayer().getStaminatotal());
			ven1.getPlayer().setVidatotal(ven1.getPlayer().getVidatotal() + 5);
			ven1.getPlayer().setVidarestante(ven1.getPlayer().getVidatotal());
		
		}
	}

