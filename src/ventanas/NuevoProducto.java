package ventanas;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.Fabricantes;
import bbdd.Productos;
import tablas.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField referencia;
	private JTextField nombre;
	private JTextField descripcion;
	private JTextField formato;
	private JTextField tipo_formato;
	private JTextField precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoProducto frame = new NuevoProducto();
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
	public NuevoProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Producto");
		lblNewLabel.setBounds(178, 6, 112, 16);
		contentPane.add(lblNewLabel);
		

		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanas.Productos.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(302, 237, 117, 29);
		contentPane.add(btnNewButton_1);
		
		referencia = new JTextField();
		referencia.setBounds(79, 24, 130, 26);
		contentPane.add(referencia);
		referencia.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Referencia:");
		lblNewLabel_1.setBounds(6, 29, 73, 16);
		contentPane.add(lblNewLabel_1);
		
		nombre = new JTextField();
		nombre.setBounds(79, 52, 130, 26);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(6, 57, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		descripcion = new JTextField();
		descripcion.setBounds(6, 158, 438, 67);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descripción:");
		lblNewLabel_3.setBounds(6, 144, 86, 16);
		contentPane.add(lblNewLabel_3);
		
		formato = new JTextField();
		formato.setBounds(79, 81, 130, 26);
		contentPane.add(formato);
		formato.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Formato:");
		lblNewLabel_4.setBounds(6, 86, 73, 16);
		contentPane.add(lblNewLabel_4);
		
		tipo_formato = new JTextField();
		tipo_formato.setBounds(332, 52, 112, 26);
		contentPane.add(tipo_formato);
		tipo_formato.setColumns(10);

		
		JLabel lblNewLabel_5 = new JLabel("Tipo de formato:");
		lblNewLabel_5.setBounds(221, 57, 112, 16);
		contentPane.add(lblNewLabel_5);
		
		precio = new JTextField();
		precio.setBounds(332, 24, 112, 26);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Precio:");
		lblNewLabel_6.setBounds(281, 29, 52, 16);
		contentPane.add(lblNewLabel_6);
		
		JComboBox<String> fabricantes = new JComboBox<String>();
		fabricantes.setBounds(79, 114, 340, 27);
		contentPane.add(fabricantes);
		ArrayList<String> nombres = Fabricantes.nombreFabricantes();
		for(String n : nombres){
		    fabricantes.addItem(n);        
		}
		
		JButton btnNewButton = new JButton("Crear producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				try {
					Producto producto = new Producto(referencia.getText(),nombre.getText(),descripcion.getText(),
							Float.parseFloat(formato.getText()),tipo_formato.getText(),Float.parseFloat(precio.getText()),
							fabricantes.getSelectedItem().toString());
					
					Productos.crearProducto(producto);
					
					JOptionPane.showMessageDialog(null,"PRODUCTO CREADO CORRECTAMENTE",
							"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				} finally {
					clearControls();
				}
			}
		});
		
		
		btnNewButton.setBounds(23, 237, 130, 29);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_7 = new JLabel("Fabricante:");
		lblNewLabel_7.setBounds(6, 119, 80, 16);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("Borrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearControls();
			}
		});
		
		btnNewButton_2.setBounds(173, 237, 117, 29);
		contentPane.add(btnNewButton_2);
	}
	
	
	//MÉTODOS
	public void clearControls() {
		
		String empty = "";
		
		referencia.setText(empty);
		nombre.setText(empty);
		formato.setText(empty);
		tipo_formato.setText(empty);
		precio.setText(empty);
		descripcion.setText(empty);
		
	}
	
	
	
}
