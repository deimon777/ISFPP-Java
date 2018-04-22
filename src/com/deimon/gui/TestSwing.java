package com.deimon.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestSwing{
	
	public static void main(String[] args) {
		JFrame ventana = new JFrameVentana();
		JPanel panelInicio = new JPanelInicio(ventana);
//		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    ventana.add(panelInicio);
		ventana.setVisible(true);
	}
	
}
