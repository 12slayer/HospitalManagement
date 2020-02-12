package hospitalassignmnet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Loginhome {

	private JFrame frame;
	private JTextField namefield;
	private JPasswordField passwordfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginhome window = new Loginhome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginhome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBounds(100, 100, 559, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 36, 533, 313);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(218, 11, 82, 14);
		panel.add(lblLogin);
		
		namefield = new JTextField();
		namefield.setForeground(Color.RED);
		namefield.setBackground(Color.GRAY);
		namefield.setBounds(289, 104, 143, 20);
		panel.add(namefield);
		namefield.setColumns(10);
		JRadioButton repradio = new JRadioButton("receptionist");
		repradio.setBackground(Color.MAGENTA);
		repradio.setBounds(96, 149, 109, 23);
		panel.add(repradio);
		
		JRadioButton docradio = new JRadioButton("doctor");
		docradio.setBackground(Color.MAGENTA);
		docradio.setBounds(96, 175, 109, 23);
		panel.add(docradio);
		
		JRadioButton nurseradio = new JRadioButton("nurse");
		nurseradio.setBackground(Color.MAGENTA);
		nurseradio.setBounds(96, 201, 109, 23);
		panel.add(nurseradio);
		
		ButtonGroup select = new ButtonGroup();
		
		select.add(repradio);
		select.add(docradio);
		select.add(nurseradio);
		
		JButton loginbutton = new JButton("LOGIN");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Scanner x;

				try {

					File loginInfo=new File("Logindoctor.txt");

					x = new Scanner(loginInfo);


					x.useDelimiter("[,\n]");

					while(x.hasNext()) {

						String username1=x.next();
						String password1=x.next();



						if(docradio.isSelected() && username1.trim().equals(namefield.getText()) && password1.trim().equals(passwordfield.getText())) {

							


							viewPatient recep=new viewPatient();
							System.out.println("loggedin doctor");
						}


						} if(repradio.isSelected() && namefield.getText().equals("hello")&& passwordfield.getText().equals("world")){
							
							
							
							Reception recep=new Reception();
							
							
							
						
						System.out.println("loggedin reception");
					}
						File loginnurse=new File("Loginnurse.txt");

						x = new Scanner(loginnurse);


						x.useDelimiter("[,\n]");

						while(x.hasNext()) {

							String username1=x.next();
							String password1=x.next();



							if(nurseradio.isSelected() && username1.trim().equals(namefield.getText()) && password1.trim().equals(passwordfield.getText())) {

								


								viewPatient recep=new viewPatient();
								System.out.println("loggedin nurse");
							}
						}

						
				
			
				

			
				
					x.close();

				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}
			}
		}
		);
			
		loginbutton.setBackground(Color.BLACK);
		loginbutton.setForeground(Color.BLUE);
		loginbutton.setBounds(218, 279, 89, 23);
		panel.add(loginbutton);
		
		JLabel namelabel = new JLabel("username");
		namelabel.setBounds(289, 64, 93, 29);
		panel.add(namelabel);
		
		JLabel passwordlabel = new JLabel("password");
		passwordlabel.setBounds(289, 157, 93, 30);
		panel.add(passwordlabel);
		
		passwordfield = new JPasswordField();
		passwordfield.setForeground(Color.RED);
		passwordfield.setBackground(Color.GRAY);
		passwordfield.setBounds(289, 190, 143, 23);
		panel.add(passwordfield);
		
		
		
	
		
		
		
		
		JLabel lblLoginAs = new JLabel("LOGIN AS");
		lblLoginAs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoginAs.setBounds(103, 114, 89, 28);
		panel.add(lblLoginAs);
		
		JLabel lblNorthamtomMedicalClinic = new JLabel("NORTHAMTOM MEDICAL CLINIC");
		lblNorthamtomMedicalClinic.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNorthamtomMedicalClinic.setBounds(129, 11, 306, 14);
		frame.getContentPane().add(lblNorthamtomMedicalClinic);
	}
}
