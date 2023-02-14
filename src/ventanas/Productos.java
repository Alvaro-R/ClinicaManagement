package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Productos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
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
	public Productos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(171, 6, 108, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nuevo producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoProducto.main(null);
			}
		});
		btnNewButton.setBounds(152, 72, 145, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver producto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerProducto.main(null);
			}
		});
		btnNewButton_1.setBounds(166, 31, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizar producto");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarProducto.main(null);
			}
		});
		btnNewButton_2.setBounds(140, 113, 168, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar producto");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto.main(null);
			}
		});
		btnNewButton_3.setBounds(146, 154, 156, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Voler al Menú principal");
		btnNewButton_4.setBounds(131, 237, 188, 29);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(null);
				dispose();
			}
		});
		contentPane.add(btnNewButton_4);
	}
}
