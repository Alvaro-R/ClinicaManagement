package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tablas.Fabricante;

public class ActualizarFabricante extends JFrame {

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
					ActualizarFabricante frame = new ActualizarFabricante();
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
	public ActualizarFabricante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actualizar Fabricante");
		lblNewLabel.setBounds(154, 6, 141, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(6, 38, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre abreviado:");
		lblNewLabel_2.setBounds(6, 66, 133, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnActualizarFabricante = new JButton("Actualizar fabricante");
		btnActualizarFabricante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Fabricante fabricante = new Fabricante(nombre.getText(),nombre_abreviado.getText());
					
					bbdd.Fabricantes.actualizarFabricante(fabricante);
					
					JOptionPane.showMessageDialog(null,"FABRICANTE ACTUALIZADO CORRECTAMENTE",
							"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnActualizarFabricante.setBounds(6, 108, 159, 29);
		contentPane.add(btnActualizarFabricante);
		
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
		
		nombre = new JTextField();
		nombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Fabricante fabricante = bbdd.Fabricantes.visualizarFabricante(nombre.getText());
					
					nombre_abreviado.setText(fabricante.getNombre_abreviado());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		nombre.setColumns(10);
		nombre.setBounds(65, 34, 169, 26);
		contentPane.add(nombre);
		
		nombre_abreviado = new JTextField();
		nombre_abreviado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Fabricante fabricante = bbdd.Fabricantes.visualizarFabricanteAbreviado(nombre_abreviado.getText());
					
					nombre.setText(fabricante.getNombre());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		nombre_abreviado.setColumns(10);
		nombre_abreviado.setBounds(131, 61, 313, 26);
		contentPane.add(nombre_abreviado);
		
		JButton btnNewButton_2_1 = new JButton("Anterior");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String anterior = bbdd.Fabricantes.anteriorFabricante(nombre.getText());
					
					nombre.setText(anterior);
					
					Fabricante fabricante = bbdd.Fabricantes.visualizarFabricante(anterior);
					
					nombre_abreviado.setText(fabricante.getNombre_abreviado());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton_2_1.setBounds(234, 34, 95, 29);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Siguiente");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String siguiente = bbdd.Fabricantes.siguienteFabricante(nombre.getText());
					
					nombre.setText(siguiente);
					
					Fabricante fabricante = bbdd.Fabricantes.visualizarFabricante(siguiente);
					
					nombre_abreviado.setText(fabricante.getNombre_abreviado());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton_3.setBounds(341, 33, 103, 29);
		contentPane.add(btnNewButton_3);
	}
	
	
	//MÉTODOS
	public void clearControls() {
		
		String empty = "";
		
		nombre.setText(empty);
		nombre_abreviado.setText(empty);
		
	}

}
