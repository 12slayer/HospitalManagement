package hospitalassignmnet;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.lang.Exception;
import java.io.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;




public class Docter extends JFrame implements ActionListener 
{

	public JTextField DID=new JTextField(5);
	public JTextField gender = new JTextField(10);
	public JTextField docName = new JTextField(10);
	public JTextField userName = new JTextField(10);
	public JPasswordField passWord = new JPasswordField(10);
	public JTextField registartionDate=new JTextField(10);
	public JTextField qualificatianDate =new JTextField(10);
	
	
	

	public JButton buttonAdding = new JButton("Add");
	public JButton buttonClear = new JButton("Clear");
	public JButton buttonSave = new JButton("Save");
	public JButton buttonExit = new JButton("Exit");


	public DefaultTableModel tableModel;
	JTable contactTable = new JTable();
	boolean button=true;

	DateFormat dateFormate=new SimpleDateFormat("yyyy-mm-dd");



	int d = 0;


	public Docter() 
	{
		super("adding Docter");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		JPanel insidePanel = new JPanel();
		JLabel didLabel =new JLabel("DoctorId");
		JLabel regDate = new JLabel("regDate");
		JLabel qualificatonDate = new JLabel("QualificationDate");
		JLabel dgender =new JLabel("gender");
		JLabel dName =new JLabel("name");
		JLabel userLabel = new JLabel ("Username");
		JLabel passwordLabel = new JLabel ("Password");

		

		insidePanel.add(didLabel);
		insidePanel.add(DID);

		insidePanel.add(regDate);
		insidePanel.add(registartionDate);
		
		insidePanel.add(qualificatonDate);
		insidePanel.add(qualificatianDate);
		
		insidePanel.add(dName);
		insidePanel.add(docName);
		
		insidePanel.add(dgender);
		insidePanel.add(gender);

		
		

		insidePanel.add(userLabel);
		insidePanel.add(userName);

		insidePanel.add(passwordLabel);
		insidePanel.add(passWord);

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


		// table layout
		Container tableButtonContainer = getContentPane();
		tableButtonContainer.setLayout(new BorderLayout());
		tableButtonContainer.setLayout(new BoxLayout(tableButtonContainer, BoxLayout.Y_AXIS));
		tableButtonContainer.add(insidePanel, BorderLayout.WEST);

		// table with 6 columns
		tableModel = new DefaultTableModel(0,9);

		// Name columns
		String column[] =  {  "docID", "name","regdate","qualidate","gender","UserName","PassWord"};
		tableModel.setColumnIdentifiers(column);
		contactTable.setModel(tableModel);


		// create pane for table
		JScrollPane tableScroller =
				new JScrollPane(contactTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		tableScroller.setViewportView(contactTable);
		tableButtonContainer.add(contactTable, BorderLayout.CENTER);
		tableButtonContainer.add(buttonPanel, BorderLayout.SOUTH);
		tableButtonContainer.add(tableScroller);
		tableScroller.setViewportView(contactTable);
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


		
		String contact = docName.getText();
		if (contact == null || contact.equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		

		String g = gender.getText();
		if (g == null || g.equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}


		String password = passWord.getText();
		if (password == null || password.equals("") || password.length()<10) 
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid 10 digit password", "Errors", JOptionPane.ERROR_MESSAGE);
			return;
		}

		

		String username = userName.getText();

		if (username == null || username.equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid username", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}






		

		String reg = registartionDate.getText();
		if ( reg == null || reg.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter a valid  registaration", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		

		String quali = qualificatianDate.getText();
		if ( quali == null || quali.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter a valid  qualificationdate", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}


		

		
		
		String did = DID.getText();
		try
		{
			Integer.parseInt(did);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Please enter a valid Doctor ID", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Please enter a valid DoctorId");

			return;
		}











		//determine row count and add values from text fields
		tableModel.setRowCount(d + 1);
		tableModel.setValueAt(did, d, 0);
		tableModel.setValueAt(contact, d, 1);
		tableModel.setValueAt(reg, d, 2);
		tableModel.setValueAt(quali, d, 3);
		tableModel.setValueAt(g, d, 4);
		tableModel.setValueAt(username, d, 5);
		tableModel.setValueAt(password, d, 6);
		
		d++;

	}



	//Clear values 
	void clearValues() 


	{         
		DID.setText(null);
		docName.setText(null); 
		gender.setText(null); 
		registartionDate.setText(null);  
		qualificatianDate.setText(null); 
		userName.setText(null);
		passWord.setText(null);








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
	                new Docter().setVisible(true);
	            }
	        });
	    }

	

	public void saveAction(){

		File data = new File("doctor.txt");
		File user = new File("Logindoctor.txt");

		try{

			FileWriter data1 = new FileWriter(data,true);

			FileWriter Login1 = new FileWriter(user,true);

		


			for(int i=0; i< tableModel.getRowCount(); i++) {
				for(int j=0; j<tableModel.getColumnCount(); j++) {

					if(j==6) {
						data1.write(tableModel.getValueAt(i,j).toString());
					}

					else {
						data1.write(tableModel.getValueAt(i,j).toString()+",");
					}

				}

				Login1.write(tableModel.getValueAt(i,5).toString()+","+"\t");
				Login1.write(tableModel.getValueAt(i,6).toString()+"\t");

				data1.write("\r\n");
				Login1.write("\r\n");
			}


			data1.close();
			Login1.close();

			




		}
		
		catch(IOException e){ System.out.println(e); }
		
		
		try {
		int v=0;
		while(v<=tableModel.getRowCount()) {
			//tableModel.setRowCount(c + 1);
			tableModel.removeRow(v);
			
			d++;

		}
		
		}
		
		catch(Exception e) {
			
			System.out.println(e);
			
		}
	}
	
	
	
	
	
	
	
	
	
}