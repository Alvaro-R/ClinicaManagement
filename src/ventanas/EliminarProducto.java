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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EliminarProducto extends JFrame {

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
					EliminarProducto frame = new EliminarProducto();
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
	public EliminarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar Producto");
		lblNewLabel.setBounds(166, 6, 117, 16);
		contentPane.add(lblNewLabel);
		
		JComboBox<String> fabricantes = new JComboBox<String>();
		fabricantes.setBounds(74, 108, 340, 27);
		contentPane.add(fabricantes);
		ArrayList<String> nombres = Fabricantes.nombreFabricantes();
		for(String n : nombres){
		    fabricantes.addItem(n);        
		}
		
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
		referencia.setBounds(79, 34, 130, 26);
		contentPane.add(referencia);
		referencia.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Referencia:");
		lblNewLabel_1.setBounds(6, 37, 72, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Eliminar");
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
					
					bbdd.Productos.eliminarProducto(producto);
					
					JOptionPane.showMessageDialog(null,"PRODUCTO ELIMINADO CORRECTAMENTE",
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
		btnNewButton.setBounds(6, 237, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productos.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(333, 237, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(6, 61, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Formato:");
		lblNewLabel_3.setBounds(6, 84, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		nombre = new JTextField();
		nombre.setBounds(79, 56, 130, 26);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		formato = new JTextField();
		formato.setBounds(79, 79, 130, 26);
		contentPane.add(formato);
		formato.setColumns(10);
		
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
		btnNewButton_2.setBounds(224, 32, 117, 29);
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
		btnNewButton_3.setBounds(333, 32, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio:");
		lblNewLabel_4.setBounds(263, 61, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(314, 56, 130, 26);
		contentPane.add(precio);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de formato:");
		lblNewLabel_5.setBounds(210, 84, 117, 16);
		contentPane.add(lblNewLabel_5);
		
		tipo_formato = new JTextField();
		tipo_formato.setColumns(10);
		tipo_formato.setBounds(314, 79, 130, 26);
		contentPane.add(tipo_formato);
		
		JLabel lblNewLabel_6 = new JLabel("Fabricante:");
		lblNewLabel_6.setBounds(6, 112, 78, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Descripción:");
		lblNewLabel_7.setBounds(6, 140, 91, 16);
		contentPane.add(lblNewLabel_7);
		
		descripcion = new JTextField();
		descripcion.setColumns(10);
		descripcion.setBounds(6, 159, 438, 69);
		contentPane.add(descripcion);
		
		JButton btnNewButton_4 = new JButton("Borrar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearControls();
			}
		});
		btnNewButton_4.setBounds(166, 237, 117, 29);
		contentPane.add(btnNewButton_4);
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
