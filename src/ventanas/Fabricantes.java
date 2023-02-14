package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fabricantes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fabricantes frame = new Fabricantes();
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
	public Fabricantes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fabricantes");
		lblNewLabel.setBounds(186, 6, 78, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver fabricantes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerFabricante.main(null);
			}
		});
		btnNewButton.setBounds(159, 23, 131, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear fabricante");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoFabricante.main(null);
			}
		});
		btnNewButton_1.setBounds(159, 62, 131, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizar fabricante");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarFabricante.main(null);
			}
		});
		btnNewButton_2.setBounds(142, 101, 164, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar fabricante");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarFabricante.main(null);
			}
		});
		btnNewButton_3.setBounds(147, 140, 154, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4_1 = new JButton("Voler al Menú principal");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(null);
				dispose();
			}
		});
		btnNewButton_4_1.setBounds(131, 231, 188, 29);
		contentPane.add(btnNewButton_4_1);
	}

}
