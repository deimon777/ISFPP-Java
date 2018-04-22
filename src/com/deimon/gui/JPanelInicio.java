package com.deimon.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JPanelInicio extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldNombre;
	private JTextField textFieldCajasRapidas;
	private JTextField textFieldCajasComunes;
	private JButton buttonAceptar;
	
	public JPanelInicio(JFrame ventana)
	{
		setBorder(new TitledBorder("Inicializacion:"));
		setForeground(Color.LIGHT_GRAY);
//		initialize(ventana);
	}
	
	private void initialize(final JFrame ventana)
	{
		setLayout(null);
//
//		JLabel lblCajasRapidas = new JLabel("Cajas Rápidas");
//		lblCajasRapidas.setBounds(223, 145, 100, 15);
//		add(lblCajasRapidas);
//
//		textFieldCajasRapidas = new JTextField();
//		textFieldCajasRapidas.setBounds(455, 143, 114, 19);
//		add(textFieldCajasRapidas);
//		textFieldCajasRapidas.setColumns(10);
//		textFieldCajasRapidas.setText("caja1");
//
//		JLabel lblCajasComunes = new JLabel("Cajas Comúnes");
//		lblCajasComunes.setBounds(223, 191, 108, 15);
//		add(lblCajasComunes);
//
//		textFieldCajasComunes = new JTextField();
//		textFieldCajasComunes.setBounds(455, 189, 114, 19);
//		add(textFieldCajasComunes);
//		textFieldCajasComunes.setColumns(10);
//		textFieldCajasComunes.setText("comun");
//
//		JLabel lblNombre = new JLabel("Nombre");
//		lblNombre.setBounds(223, 94, 55, 15);
//		add(lblNombre);
//
//		textFieldNombre = new JTextField();
//		textFieldNombre.setBounds(455, 92, 114, 19);
//		add(textFieldNombre);
//		textFieldNombre.setColumns(10);
//
//		JLabel lblMaxDeGentes = new JLabel("Maximo para nueva caja");
//		lblMaxDeGentes.setBounds(223, 237, 200, 15);
//		add(lblMaxDeGentes);

		buttonAceptar.setBounds(556, 387, 89, 25);
		add(buttonAceptar);

	}
}
