package com.deimon.isfpp.junit;

import mdlaf.*;
import java.awt.*;
import javax.swing.*;

public class TestSwing extends JFrame{
	
	public void prueba() {
		JButton boton = new JButton("a onda");
		getContentPane().add(boton, BorderLayout.CENTER);
	}


	public static void main(String[] args) {
		TestSwing ts = new TestSwing();
		ts.prueba();	
		ts.setVisible(true); // hacemos visible la ventana creada
	}
}
