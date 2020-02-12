package hospitalassignmnet;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class editPatient extends JFrame implements ActionListener 
{

	public JTextField PID=new JTextField(5);
	public JTextField name = new JTextField(10);
	public JTextField address = new JTextField(10);
	public JTextField phone = new JTextField(10);
	public JTextField email = new JTextField(10);
	public JTextField dob=new JTextField(10);
	public JTextField doctor =new JTextField(10);
	public JTextField date =new JTextField(10);
	
	
	

	public JButton buttonEdit = new JButton("edit");
	public JButton buttonClear = new JButton("Clear");
	public JButton buttonSave = new JButton("Save");
	public JButton buttonExit = new JButton("Exit");


	public DefaultTableModel tableModel;
	JTable patientTable = new JTable();
	boolean button=true;

	


	int d = 0;


	public editPatient() 
	{
		super("editPatient");
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


		buttonEdit.addActionListener(this);
		buttonClear.addActionListener(this);
		buttonExit.addActionListener(this);
		buttonSave.addActionListener(this);

		buttonPanel.add(buttonEdit);
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
		String column[] =  {"name","dob","medicalstaff","patient id","email","address","phone","dateof treatment"};
		tableModel.setColumnIdentifiers(column);
		patientTable.setModel(tableModel);


		// create pane for table
		JScrollPane tableScroller =
				new JScrollPane(patientTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		tableScroller.setViewportView(patientTable);
		tableButtonContainer.add(patientTable, BorderLayout.CENTER);
		tableButtonContainer.add(buttonPanel, BorderLayout.SOUTH);
		tableButtonContainer.add(tableScroller);
		tableScroller.setViewportView(patientTable);
		pack();



ArrayList<String> doctorArray= new ArrayList<String>();

		
		File t = new File("patient.txt");

		try{

			Scanner data = new Scanner(t);

			data.useDelimiter("[,\n]");


			while(data.hasNext()&& d<=tableModel.getRowCount()) {
				tableModel.setRowCount(d + 1);
				
				for(int j=0;j<8;j++) {
					
					doctorArray.add(j,data.next());
					
					
					
				}
				for(int y=0;y<8;y++) {
				tableModel.setValueAt(doctorArray.get(y), d, y);
				
				}
				d++;

			}



			data.close();





		}
		catch(IOException e){ System.out.println(e);

		}
		
	





	patientTable.addMouseListener(new MouseAdapter(){

		@Override
		public void mouseClicked(MouseEvent e){

			
			int j = patientTable.getSelectedRow();
			PID.setText((String) tableModel.getValueAt(j,0));
			name.setText((String) tableModel.getValueAt(j,1));
			address.setText((String) tableModel.getValueAt(j,2));
			phone.setText((String) tableModel.getValueAt(j,3));
			dob.setText((String) tableModel.getValueAt(j,4));
			email.setText((String) tableModel.getValueAt(j,5));
			date.setText((String) tableModel.getValueAt(j,6)); 
			doctor.setText((String) tableModel.getValueAt(j,7)); 
		}
	});
	
}












public void actionPerformed(ActionEvent event)
{

	JButton source = (JButton) event.getSource();
	
	 if (source == buttonClear) 
	{
		buttonClear.setFocusable(false);

		DeleteDoc();
	} 
	
	else if (source == buttonExit) 
	{
		quit();
	}
	
	else if(source==buttonEdit)
	{
		Edit();
	}
	else if(source==buttonSave) {
		
		
		Save();
	}

	
}

public void Save() {
	
	File data = new File("patient.txt");
	

	try{

		FileWriter data1 = new FileWriter(data);

		

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

	}
	













public void Edit() {
	
	

			String contact = email.getText();
			if (contact == null || contact.equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}


			String g = name.getText();
			if (g == null || g.equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			




			String password = address.getText();
			if (password == null || password.equals("") || password.length()<4) 
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid address", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			

			String username = phone.getText();

			if (username == null || username.equals("")) 
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid phone number", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			

			String reg = dob.getText();
			if ( reg == null || reg.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Enter a valid  date of birth", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			

			String quali = date.getText();
			if ( quali == null || quali.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Enter a valid  dateoftreatment", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String doc = doctor.getText();
			if ( doc == null || doc.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Enter a valid  medicalstaff", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}





			String did = PID.getText();
			try
			{
				Integer.parseInt(did);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter a patient ID", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("Please enter a valid patient Id");

				return;
			}

	
	
	
	int i = patientTable.getSelectedRow();
	
	tableModel.setValueAt(PID.getText(),i,0);
	tableModel.setValueAt( name.getText(), i, 1);
	tableModel.setValueAt( address.getText(), i, 2);
	tableModel.setValueAt(phone.getText(), i, 3);
	tableModel.setValueAt(dob.getText(), i, 4);
	tableModel.setValueAt(email.getText(), i, 5);
	tableModel.setValueAt(date.getText(), i, 6);
	tableModel.setValueAt(doctor.getText(), i, 7);
	
	
	
	
	
	
}

//Clear values 
void DeleteDoc() 


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
            new editPatient().setVisible(true);
        }
    });
}



public void saveAction(){

	File data = new File("patient.txt");
	

	try{

		FileWriter data1 = new FileWriter(data);



		for(int i=0; i< tableModel.getRowCount(); i++) {
			for(int j=0; j<tableModel.getColumnCount(); j++) {

				if(j==8) {
					data1.write(tableModel.getValueAt(i,j).toString());
				}

				else {
					data1.write(tableModel.getValueAt(i,j).toString()+",");
				}

			}

			

			data1.write("\r\n");
			
		}


		data1.close();



		





	}catch(IOException e){ System.out.println(e); }
}
}
