package hospitalassignmnet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Reception {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reception window = new Reception();
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
	public Reception() {
		System.out.println("logged");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 520, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(0, 55, 494, 295);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton adddoctor = new JButton("Add docter");
		adddoctor.setBackground(Color.RED);
		adddoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Docter Doc=new Docter();
			}
		});
		adddoctor.setBounds(20, 27, 109, 40);
		panel.add(adddoctor);
		
		JButton editdoctor = new JButton("edit docter");
		editdoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editDocter Doc=new editDocter();
			}
		});
		editdoctor.setBackground(Color.RED);
		editdoctor.setBounds(20, 78, 109, 35);
		panel.add(editdoctor);
		
		JButton addnurse = new JButton("addnurse");
		addnurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nurse nur=new Nurse();
				
			}
		});
		addnurse.setBackground(Color.RED);
		addnurse.setBounds(183, 27, 101, 40);
		panel.add(addnurse);
		
		JButton editnurse = new JButton("edit nurse");
		editnurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editNurse nur=new editNurse();
			}
		});
		editnurse.setBackground(Color.RED);
		editnurse.setBounds(183, 84, 101, 29);
		panel.add(editnurse);
		
		JButton addpatient = new JButton("addpatient");
		addpatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Patient p=new Patient();
			}
		});
		addpatient.setBackground(Color.RED);
		addpatient.setBounds(343, 31, 101, 32);
		panel.add(addpatient);
		
		JButton editpatient = new JButton("editpatient");
		editpatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editPatient nur=new editPatient();
			}
		});
		editpatient.setBackground(Color.RED);
		editpatient.setBounds(343, 81, 101, 29);
		panel.add(editpatient);
		
		JButton logout = new JButton("logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		logout.setBounds(195, 198, 89, 23);
		panel.add(logout);
		
		JLabel toplabel = new JLabel("NORTHAMTON MEDICAL CLINIC");
		toplabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toplabel.setBounds(86, 30, 240, 14);
		frame.getContentPane().add(toplabel);
	}
}
