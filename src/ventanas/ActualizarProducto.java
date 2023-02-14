package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bbdd.Fabricantes;
import tablas.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ActualizarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField referencia;
	private JTextField nombre;
	private JTextField formato;
	private JTextField precio;
	private JTextField tipo_formato;
	private JTextField descripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarProducto frame = new ActualizarProducto();
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
	public ActualizarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> fabricantes = new JComboBox<String>();
		fabricantes.setBounds(74, 108, 340, 27);
		contentPane.add(fabricantes);
		ArrayList<String> nombres = Fabricantes.nombreFabricantes();
		for(String n : nombres){
		    fabricantes.addItem(n);        
		}
		
		JLabel lblNewLabel = new JLabel("Actualizar Producto");
		lblNewLabel.setBounds(176, 6, 130, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Referencia:");
		lblNewLabel_1.setBounds(6, 39, 91, 16);
		contentPane.add(lblNewLabel_1);
		
		referencia = new JTextField();
		referencia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Producto producto = bbdd.Productos.visualizarProducto(referencia.getText());
					
					referencia.setText(producto.getReferencia());
					nombre.setText(producto.getNombre());
					descripcion.setText(producto.getDescripcion());
					formato.setText(Float.toString(producto.getFormato()));
					tipo_formato.setText(producto.getTipo_formato());
					precio.setText(Float.toString(producto.getPrecio()));
					fabricantes.setSelectedItem(producto.getFabricante());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		referencia.setBounds(74, 34, 130, 26);
		contentPane.add(referencia);
		referencia.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(74, 57, 130, 26);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(6, 62, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Producto producto = new Producto();
					
					producto.setReferencia(referencia.getText());
					producto.setNombre(nombre.getText());
					producto.setDescripcion(descripcion.getText());
					producto.setFormato(Float.parseFloat(formato.getText()));
					producto.setTipo_formato(tipo_formato.getText());
					producto.setPrecio(Float.parseFloat(precio.getText()));
					producto.setFabricante(fabricantes.getSelectedItem().toString());
					
					bbdd.Productos.actualizarProducto(producto);
					
					JOptionPane.showMessageDialog(null,"PRODUCTO ACTUALIZADO CORRECTAMENTE",
							"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(6, 237, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productos.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(327, 237, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Anterior");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String anterior = bbdd.Productos.anteriorProducto(referencia.getText());			
					
					Producto producto = bbdd.Productos.visualizarProducto(anterior);
					
					referencia.setText(anterior);
					nombre.setText(producto.getNombre());
					descripcion.setText(producto.getDescripcion());
					formato.setText(Float.toString(producto.getFormato()));
					tipo_formato.setText(producto.getTipo_formato());
					precio.setText(Float.toString(producto.getPrecio()));
					fabricantes.setSelectedItem(producto.getFabricante());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnNewButton_2.setBounds(207, 34, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Siguiente");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String siguiente = bbdd.Productos.siguienteProducto(referencia.getText());			
					
					Producto producto = bbdd.Productos.visualizarProducto(siguiente);
					
					referencia.setText(siguiente);
					nombre.setText(producto.getNombre());
					descripcion.setText(producto.getDescripcion());
					formato.setText(Float.toString(producto.getFormato()));
					tipo_formato.setText(producto.getTipo_formato());
					precio.setText(Float.toString(producto.getPrecio()));
					fabricantes.setSelectedItem(producto.getFabricante());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton_3.setBounds(327, 34, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Borrar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearControls();
			}
		});
		btnNewButton_4.setBounds(166, 237, 117, 29);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("Formato:");
		lblNewLabel_3.setBounds(6, 84, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		formato = new JTextField();
		formato.setBounds(74, 79, 130, 26);
		contentPane.add(formato);
		formato.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Precio:");
		lblNewLabel_4.setBounds(263, 62, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		precio = new JTextField();
		precio.setBounds(314, 57, 130, 26);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de formato:");
		lblNewLabel_5.setBounds(207, 84, 117, 16);
		contentPane.add(lblNewLabel_5);
		
		tipo_formato = new JTextField();
		tipo_formato.setBounds(314, 79, 130, 26);
		contentPane.add(tipo_formato);
		tipo_formato.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fabricante:");
		lblNewLabel_6.setBounds(6, 112, 78, 16);
		contentPane.add(lblNewLabel_6);
	
		
		JLabel lblNewLabel_7 = new JLabel("Descripción:");
		lblNewLabel_7.setBounds(6, 140, 91, 16);
		contentPane.add(lblNewLabel_7);
		
		descripcion = new JTextField();
		descripcion.setBounds(6, 156, 438, 69);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
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
