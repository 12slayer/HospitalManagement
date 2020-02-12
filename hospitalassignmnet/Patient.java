package hospitalassignmnet;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.lang.Exception;
import java.io.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;




public class Patient extends JFrame implements ActionListener 
{

	public JTextField PID=new JTextField(5);
	public JTextField name = new JTextField(10);
	public JTextField address = new JTextField(10);
	public JTextField phone = new JTextField(10);
	public JTextField email = new JTextField(10);
	public JTextField dob=new JTextField(10);
	public JTextField doctor =new JTextField(10);
	public JTextField date =new JTextField(10);
	
	
	

	public JButton buttonAdding = new JButton("Add");
	public JButton buttonClear = new JButton("Clear");
	public JButton buttonSave = new JButton("Save");
	public JButton buttonExit = new JButton("Exit");


	public DefaultTableModel tableModel;
	JTable patientTable = new JTable();
	boolean button=true;

	


	int d = 0;


	public Patient() 
	{
		super("adding patient");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		JPanel insidePanel = new JPanel();
		JLabel didLabel =new JLabel("patientid");
		JLabel pname=new JLabel("name");
		JLabel regDate = new JLabel("address");
		JLabel qualificatonDate = new JLabel("phone");
		JLabel dgender =new JLabel("email");
		JLabel dName =new JLabel("dob");
		JLabel treatmentdate =new JLabel("date of treatment");
		JLabel userLabel = new JLabel ("medicalstaff");
		
	

		

		insidePanel.add(didLabel);
		insidePanel.add(PID);
		

		insidePanel.add(pname);
		insidePanel.add(name);
		

		

		insidePanel.add(regDate);
		insidePanel.add(address);
		
		insidePanel.add(qualificatonDate);
		insidePanel.add(phone);
		
		insidePanel.add(dgender);
		insidePanel.add(email);
		
		insidePanel.add(dName);
		insidePanel.add(dob);

		
		insidePanel.add(treatmentdate);
		insidePanel.add(date);
		

		insidePanel.add(userLabel);
		insidePanel.add(doctor);

		

		


		//place for buttons 
		JPanel buttonPanel = new JPanel();


		buttonAdding.addActionListener(this);
		buttonClear.addActionListener(this);
		buttonExit.addActionListener(this);
		buttonSave.addActionListener(this);

		buttonPanel.add(buttonAdding);
		buttonPanel.add(buttonClear);
		buttonPanel.add(buttonSave);
		buttonPanel.add(buttonExit);



		Container tableButtonContainer = getContentPane();
		tableButtonContainer.setLayout(new BorderLayout());
		tableButtonContainer.setLayout(new BoxLayout(tableButtonContainer, BoxLayout.Y_AXIS));
		tableButtonContainer.add(insidePanel, BorderLayout.WEST);


		tableModel = new DefaultTableModel(0,9);

		// Name columns
		String column[] =  {  "name","dob","medicalstaff","patient id","email","address","phone","dateof treatment"};
		tableModel.setColumnIdentifiers(column);
		patientTable.setModel(tableModel);


		JScrollPane tableScroller =
				new JScrollPane(patientTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		tableScroller.setViewportView(patientTable);
		tableButtonContainer.add(patientTable, BorderLayout.CENTER);
		tableButtonContainer.add(buttonPanel, BorderLayout.SOUTH);
		tableButtonContainer.add(tableScroller);
		tableScroller.setViewportView(patientTable);
		pack();








	}












	public void actionPerformed(ActionEvent event)
	{

		JButton source = (JButton) event.getSource();
		if (source == buttonAdding) 
		{
			AddContact();//-----------------------------------------------
		} 
		else if (source == buttonClear) 
		{
			buttonClear.setFocusable(false);

			clearValues();
		} 
		else if (source == buttonSave)
		{
			saveAction();
		}    
		else if (source == buttonExit) 
		{
			quit();
		}




	}





	void AddContact() 
	{


		
		String contact = name.getText();
		if (contact == null || contact.equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		

		String g = PID.getText();
		if (g == null || g.equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Please enter a id", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}


		String password = address.getText();
		if (password == null || password.equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid address", "Errors", JOptionPane.ERROR_MESSAGE);
			return;
		}

		

		String username = email.getText();

		if (username == null || username.equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}






		

		String reg = dob.getText();
		if ( reg == null || reg.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter a valid  dateofbirth", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		

		String quali = doctor.getText();
		if ( quali == null || quali.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter a valid  qualificationdate", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		

		String p = phone.getText();
		if ( p == null || p.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter a valid  qualificationdate", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		

		String da = date.getText();
		if ( da == null || da.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter a valid  treatmentdate", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		

		
		
	









		//determine row count and add values from text fields
		tableModel.setRowCount(d + 1);
		tableModel.setValueAt(contact, d, 0);
		tableModel.setValueAt(reg, d, 1);
		tableModel.setValueAt(quali, d, 2);
		tableModel.setValueAt(g, d, 3);
		tableModel.setValueAt(username, d, 4);
		tableModel.setValueAt(password, d, 5);
		tableModel.setValueAt(p, d, 6);
		tableModel.setValueAt(da, d, 7);
		
		d++;

	}



	//Clear values 
	void clearValues() 


	{         
		PID.setText(null);
		name.setText(null); 
		address.setText(null); 
		dob.setText(null);  
		email.setText(null); 
		doctor.setText(null);
		phone.setText(null);
		date.setText(null);








	}










	//exit application 
	void quit() 


	{


		dispose();
	}
	  public static void main(String args[]) 
	    {
	        java.awt.EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                new Patient().setVisible(true);
	            }
	        });
	    }

	

	public void saveAction(){

		File data = new File("patient.txt");

		try{

			FileWriter data1 = new FileWriter(data,true);

			
		


			for(int i=0; i< tableModel.getRowCount(); i++) {
				for(int j=0; j<tableModel.getColumnCount(); j++) {

					if(j==7) {
						data1.write(tableModel.getValueAt(i,j).toString());
					}

					else {
						data1.write(tableModel.getValueAt(i,j).toString()+",");
					}

				}

				

				data1.write("\r\n");
				
			}


			data1.close();
			

			




		}
		
		catch(IOException e){ System.out.println(e); }
		
		
		try {
		int p=0;
		while(p<=tableModel.getRowCount()) {
			tableModel.removeRow(p);
			
			d++;

		}
		
		}
		
		catch(Exception e) {
			
			System.out.println(e);
			
		}
	}
	
	
	
	
	
	
	
	
	
}