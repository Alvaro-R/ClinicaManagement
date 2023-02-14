package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tablas.Fabricante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoFabricante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField nombre_abreviado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoFabricante frame = new NuevoFabricante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NuevoFabricante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Fabricante");
		lblNewLabel.setBounds(167, 6, 119, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(6, 38, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre abreviado:");
		lblNewLabel_2.setBounds(6, 66, 133, 16);
		contentPane.add(lblNewLabel_2);
		
		nombre = new JTextField();
		nombre.setBounds(65, 33, 379, 26);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		nombre_abreviado = new JTextField();
		nombre_abreviado.setBounds(131, 61, 313, 26);
		contentPane.add(nombre_abreviado);
		nombre_abreviado.setColumns(10);
		
		JButton btnCrearFabricante = new JButton("Crear fabricante");
		btnCrearFabricante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Fabricante fabricante = new Fabricante(nombre.getText(),nombre_abreviado.getText());
					
					bbdd.Fabricantes.crearFabricante(fabricante);
					
					JOptionPane.showMessageDialog(null,"FABRICANTE CREADO CORRECTAMENTE",
							"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				} finally {
					clearControls();
				}
				
			}
		});
		btnCrearFabricante.setBounds(6, 108, 130, 29);
		contentPane.add(btnCrearFabricante);
		
		JButton btnNewButton_2 = new JButton("Borrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearControls();
			}
		});
		btnNewButton_2.setBounds(166, 108, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fabricantes.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(327, 108, 117, 29);
		contentPane.add(btnNewButton_1);
	}
	
	
	//MÉTODOS
	public void clearControls() {
		
		String empty = "";
		
		nombre.setText(empty);
		nombre_abreviado.setText(empty);
		
	}
	

}
