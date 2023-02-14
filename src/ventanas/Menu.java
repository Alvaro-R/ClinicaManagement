package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import bbdd.BBDD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menú Principal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 6, 117, 16);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Crear BBDD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BBDD.crearBBDD();
					BBDD.crearTablaFabricantes();
					BBDD.crearTablaProductos();
					BBDD.crearTablaClientes();
					JOptionPane.showMessageDialog(null,"BBDD CREADA CORRECTAMENTE",
							"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(31, 39, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Productos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productos.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(160, 151, 117, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fabricantes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fabricantes.main(null);
				dispose();
			}
		});
		btnNewButton_2.setBounds(160, 184, 117, 29);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnNewButton_4.setBounds(160, 225, 117, 29);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Eliminar BBDD");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BBDD.eliminarBBDD();
					JOptionPane.showMessageDialog(null,"BBDD ELIMINADA CORRECTAMENTE",
							"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_5.setBounds(160, 39, 117, 29);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Reiniciar BBDD");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BBDD.eliminarBBDD();
					BBDD.crearBBDD();
					BBDD.crearTablaFabricantes();
					BBDD.crearTablaProductos();
					BBDD.crearTablaClientes();
					JOptionPane.showMessageDialog(null,"BBDD REINICIADA CORRECTAMENTE",
							"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage(),
							"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_6.setBounds(297, 39, 117, 29);
		panel.add(btnNewButton_6);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(-137, 304, 237, 96);
		panel.add(fileChooser);
		
		JButton btnNewButton_3 = new JButton("Crear registros");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BBDD.llenarFabricantes();
				BBDD.llenarProductos();
				JOptionPane.showMessageDialog(null,"TODOS LOS REGISTROS CREADOS CORRECTAMENTE",
						"WARNING_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_3.setBounds(160, 95, 117, 29);
		panel.add(btnNewButton_3);
	}
}
