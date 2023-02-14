package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import tablas.Producto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.util.ArrayList;

public class VerProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField referencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerProducto frame = new VerProducto();
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
	public VerProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Volver al Menú principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(6, 237, 175, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver a Productos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productos.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(299, 237, 145, 29);
		contentPane.add(btnNewButton_1);
		
		//TABLA
		table = new JTable();
		Object[] columnas = {"Referencia","Nombre","Descripción","Formato","Tipo de formato","Precio","Precio con IVA","Fabricante"};
		DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columnas);
		table.setModel(model);
		
		table.setBounds(6, 72, 583, 152);
		table.setBackground(Color.LIGHT_GRAY);
		
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Ver Producto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 6, 103, 16);
		contentPane.add(lblNewLabel);
		
		referencia = new JTextField();
		referencia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Producto producto = bbdd.Productos.visualizarProducto(referencia.getText());
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					model.setRowCount(0);
					
					Object[] fila = new Object[8];
					
					fila[0] = producto.getReferencia();
					fila[1] = producto.getNombre();
					fila[2] = producto.getDescripcion();
					fila[3] = producto.getFormato();
					fila[4] = producto.getTipo_formato();
					fila[5] = producto.getPrecio();
					fila[6] = producto.getPrecio_IVA();
					fila[7] = producto.getFabricante();
					model.addRow(fila);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		referencia.setBounds(80, 34, 130, 26);
		contentPane.add(referencia);
		referencia.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Referencia:");
		lblNewLabel_1.setBounds(6, 39, 74, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Anterior");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String anterior = bbdd.Productos.anteriorProducto(referencia.getText());			
					
					Producto producto = bbdd.Productos.visualizarProducto(anterior);
					
					referencia.setText(anterior);
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					model.setRowCount(0);
					
					Object[] fila = new Object[8];
					
					fila[0] = producto.getReferencia();
					fila[1] = producto.getNombre();
					fila[2] = producto.getDescripcion();
					fila[3] = producto.getFormato();
					fila[4] = producto.getTipo_formato();
					fila[5] = producto.getPrecio();
					fila[6] = producto.getPrecio_IVA();
					fila[7] = producto.getFabricante();
					model.addRow(fila);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton_2.setBounds(234, 31, 95, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Siguiente");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String siguiente = bbdd.Productos.siguienteProducto(referencia.getText());			
					
					Producto producto = bbdd.Productos.visualizarProducto(siguiente);
					
					referencia.setText(siguiente);
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					model.setRowCount(0);
					
					Object[] fila = new Object[8];
					
					fila[0] = producto.getReferencia();
					fila[1] = producto.getNombre();
					fila[2] = producto.getDescripcion();
					fila[3] = producto.getFormato();
					fila[4] = producto.getTipo_formato();
					fila[5] = producto.getPrecio();
					fila[6] = producto.getPrecio_IVA();
					fila[7] = producto.getFabricante();
					model.addRow(fila);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton_3.setBounds(330, 31, 103, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ver todos");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ArrayList<Producto> productos = bbdd.Productos.listaProductos();
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setColumnIdentifiers(columnas);
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
		btnNewButton_4.setBounds(181, 237, 117, 29);
		contentPane.add(btnNewButton_4);
		

		

	}
}
