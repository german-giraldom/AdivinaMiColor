package guessmycolor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Principal extends JFrame {
	
	private int objrojo=0, objazul=0, objverde=0;
	private int rojo=0, azul=0, verde=0;
	
	JFrame ventana = new JFrame();
	
	JPanel panelcentral = new JPanel();
	JPanel panelmuestra = new JPanel();
	JPanel panelobjetivo = new JPanel();
	
	Dimension tamaño = new Dimension(300, 50);
	Random all = new Random();
	
	Font fuente = new Font(Font.SERIF,Font.BOLD,30);
	JLabel etiqueta1 = new JLabel();
	JLabel etiqueta2 = new JLabel();
	
	JButton rojomas = new JButton("+");
	JButton rojomenos = new JButton("-");
	
	JButton azulmas = new JButton("+");
	JButton azulmenos = new JButton("-");
	
	JButton verdemas = new JButton("+");
	JButton verdemenos = new JButton("-");
	
	
	private void Diseño () {
		
		ventana.setTitle("adivina mi color");
		//ventana.setResizable(true);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);;
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.setSize(350, 220);
		
		panelcentral.setBackground(Color.cyan);
		ventana.add(panelcentral);
		
		panelmuestra.setBackground(new Color(rojo, verde, azul));
		panelmuestra.setPreferredSize(tamaño);
		panelcentral.add(panelmuestra, BorderLayout.PAGE_START);
		
		//panelobjetivo.setBackground(Color.cyan);
		panelobjetivo.setPreferredSize(tamaño);
		panelcentral.add(panelobjetivo, BorderLayout.PAGE_END);
		
		etiqueta1.setFont(fuente);
		//etiqueta1.setOpaque(true); // habilitar opacidad
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setText("color cambiante");
		etiqueta1.setForeground(Color.white);// color para el texto
		panelmuestra.add(etiqueta1, BorderLayout.PAGE_START);
		
		etiqueta2.setFont(fuente);
		etiqueta2.setHorizontalAlignment(JLabel.CENTER);
		etiqueta2.setText("color objetivo");
		etiqueta2.setForeground(Color.white);
		panelobjetivo.add(etiqueta2, BorderLayout.CENTER);
		
		////////////////////////////////////////////////////////////////////
		rojomas.setBackground(Color.red);
		rojomas.setFont(fuente);
		rojomas.setBorderPainted(false); // no hace nada al tener el mouse encima del boton
		rojomas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rojo <= 240) {
					rojo+=15;
					ActualizarColor();
					ComparadorColor();
				}
			}
		});
		rojomenos.setBackground(Color.red);
		rojomenos.setFont(fuente);
		rojomenos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rojo >=15) {
					rojo-=15;
					ActualizarColor();
					ComparadorColor();
				}
			}
		});
		panelcentral.add(rojomas);
		panelcentral.add(rojomenos);
		
		////////////////////////////////////////////////////////////////////
		azulmas.setBackground(Color.BLUE);
		azulmas.setFont(fuente);
		azulmas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (azul<=240) {
					azul+=15;
					ActualizarColor();
					ComparadorColor();
				}
			}
		});
		azulmenos.setBackground(Color.blue);
		azulmenos.setFont(fuente);
		azulmenos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (azul >=15) {
					azul-=15;
					ActualizarColor();
					ComparadorColor();
				}
			}
		});
		panelcentral.add(azulmas);
		panelcentral.add(azulmenos);
		
		//////////////////////////////////////////////////////////////////////
		verdemas.setBackground(Color.green);
		verdemas.setFont(fuente);
		verdemas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (verde<=240) {
					verde+=15;
					ActualizarColor();
					ComparadorColor();
				}
			}
		});
		verdemenos.setBackground(Color.GREEN);
		verdemenos.setFont(fuente);
		verdemenos.setBorderPainted(false);
		verdemenos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (verde>=15) {
					verde-=15;
					ActualizarColor();
					ComparadorColor();
				}
			}
		});
		panelcentral.add(verdemas);
		panelcentral.add(verdemenos);
	}
	
	public Principal() {
		Diseño();
		GenerarColor();
	}

	private void GenerarColor() {
		
		objrojo=all.nextInt(17)*15;
		objazul=all.nextInt(17)*15;
		objverde=all.nextInt(17)*15;
		
		Color colorobjetivo = new Color(objrojo,objverde,objazul);
		panelobjetivo.setBackground(colorobjetivo);
	}
	
	private void ActualizarColor () {
		Color colormuestra = new Color(rojo, verde, azul);
		panelmuestra.setBackground(colormuestra);
	}
	
	private void ComparadorColor () {
		if (objrojo==rojo && objverde==verde && objazul==azul) {
			JOptionPane.showMessageDialog(null, "fecilitaciones, has adivinado el color"); 
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		
		try{
			
		}catch (Exception e) {
			
		}
		Principal print = new Principal();
	}
}