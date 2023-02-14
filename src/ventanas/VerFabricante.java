package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tablas.Fabricante;
import tablas.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VerFabricante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField nombre_abreviado;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerFabricante frame = new VerFabricante();
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
	public VerFabricante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ver Fabricante");
		lblNewLabel.setBounds(175, 6, 100, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(6, 33, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		nombre = new JTextField();
		nombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Fabricante fabricante = bbdd.Fabricantes.visualizarFabricante(nombre.getText());
					
					nombre_abreviado.setText(fabricante.getNombre_abreviado());
					
					ArrayList<Producto> productos = bbdd.Fabricantes.ProductosFabricantes(fabricante.getNombre());
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					
					Object[] fila = new Object[8];
					
					for (int i = 0; i < productos.size(); i++) {
						
						fila[0] = productos.get(i).getReferencia();
						fila[1] = productos.get(i).getNombre();
						fila[2] = productos.get(i).getDescripcion();
						fila[3] = productos.get(i).getFormato();
						fila[4] = productos.get(i).getTipo_formato();
						fila[5] = productos.get(i).getPrecio();
						fila[6] = productos.get(i).getPrecio_IVA();
						fila[7] = productos.get(i).getFabricante();
						model.addRow(fila);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		nombre.setBounds(66, 28, 130, 26);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Anterior");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String anterior = bbdd.Fabricantes.anteriorFabricante(nombre.getText());
					
					nombre.setText(anterior);
					
					Fabricante fabricante = bbdd.Fabricantes.visualizarFabricante(anterior);
					
					nombre_abreviado.setText(fabricante.getNombre_abreviado());
					
					ArrayList<Producto> productos = bbdd.Fabricantes.ProductosFabricantes(fabricante.getNombre());
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					
					Object[] fila = new Object[8];
					
					for (int i = 0; i < productos.size(); i++) {
						
						fila[0] = productos.get(i).getReferencia();
						fila[1] = productos.get(i).getNombre();
						fila[2] = productos.get(i).getDescripcion();
						fila[3] = productos.get(i).getFormato();
						fila[4] = productos.get(i).getTipo_formato();
						fila[5] = productos.get(i).getPrecio();
						fila[6] = productos.get(i).getPrecio_IVA();
						fila[7] = productos.get(i).getFabricante();
						model.addRow(fila);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton_2.setBounds(208, 28, 95, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Siguiente");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String siguiente = bbdd.Fabricantes.siguienteFabricante(nombre.getText());
					
					nombre.setText(siguiente);
					
					Fabricante fabricante = bbdd.Fabricantes.visualizarFabricante(siguiente);
					
					nombre_abreviado.setText(fabricante.getNombre_abreviado());
					
					ArrayList<Producto> productos = bbdd.Fabricantes.ProductosFabricantes(fabricante.getNombre());
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					
					Object[] fila = new Object[8];
					
					for (int i = 0; i < productos.size(); i++) {
						
						fila[0] = productos.get(i).getReferencia();
						fila[1] = productos.get(i).getNombre();
						fila[2] = productos.get(i).getDescripcion();
						fila[3] = productos.get(i).getFormato();
						fila[4] = productos.get(i).getTipo_formato();
						fila[5] = productos.get(i).getPrecio();
						fila[6] = productos.get(i).getPrecio_IVA();
						fila[7] = productos.get(i).getFabricante();
						model.addRow(fila);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		btnNewButton_3.setBounds(315, 28, 103, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre abreviado:");
		lblNewLabel_2.setBounds(6, 61, 130, 16);
		contentPane.add(lblNewLabel_2);
		
		nombre_abreviado = new JTextField();
		nombre_abreviado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Fabricante fabricante = bbdd.Fabricantes.visualizarFabricanteAbreviado(nombre_abreviado.getText());
					
					nombre.setText(fabricante.getNombre());
					
					ArrayList<Producto> productos = bbdd.Fabricantes.ProductosFabricantes(fabricante.getNombre());
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					
					Object[] fila = new Object[8];
					
					for (int i = 0; i < productos.size(); i++) {
						
						fila[0] = productos.get(i).getReferencia();
						fila[1] = productos.get(i).getNombre();
						fila[2] = productos.get(i).getDescripcion();
						fila[3] = productos.get(i).getFormato();
						fila[4] = productos.get(i).getTipo_formato();
						fila[5] = productos.get(i).getPrecio();
						fila[6] = productos.get(i).getPrecio_IVA();
						fila[7] = productos.get(i).getFabricante();
						model.addRow(fila);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		nombre_abreviado.setBounds(132, 56, 130, 26);
		contentPane.add(nombre_abreviado);
		nombre_abreviado.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Productos:");
		lblNewLabel_3.setBounds(6, 89, 75, 16);
		contentPane.add(lblNewLabel_3);
		
		table = new JTable();
		table.setBounds(6, 114, 438, 118);
		contentPane.add(table);
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columnas = {"Referencia","Nombre","Descripción","Formato","Tipo de formato","Precio","Precio con IVA","Fabricante"};
		
		model.setColumnIdentifiers(columnas);
		table.setModel(model);
		
		model.addRow(columnas);
		
		JButton btnNewButton = new JButton("Volver al Menú principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(6, 237, 175, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver a Fabricantes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fabricantes.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(286, 237, 158, 29);
		contentPane.add(btnNewButton_1);
	}
}
