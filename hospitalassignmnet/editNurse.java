package hospitalassignmnet;



import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;
import java.io.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class editNurse extends JFrame implements ActionListener 
{
	public JTextField NID=new JTextField(5);
	public JTextField gender = new JTextField(10);
	public JTextField nurName = new JTextField(10);
	public JTextField userName = new JTextField(10);
	public JPasswordField passWord = new JPasswordField(10);
	public JTextField registartionDate=new JTextField(10);
	public JTextField qualificatianDate =new JTextField(10);
	
	
	

	public JButton buttonEdit = new JButton("edit");
	public JButton buttonClear = new JButton("Clear");
	public JButton buttonSave = new JButton("Save");
	public JButton buttonExit = new JButton("Exit");
	public JButton buttonDelete = new JButton("delete");

	public DefaultTableModel tableModel;
	JTable contactTable = new JTable();
	boolean button=true;

	



	int n = 0;


	public editNurse() 
	{
		super("editing Nurse");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		JPanel insidePanel = new JPanel();
		JLabel didLabel =new JLabel("nurseid");
		JLabel regDate = new JLabel("regDate");
		JLabel qualificatonDate = new JLabel("QualificationDate");
		JLabel dgender =new JLabel("gender");
		JLabel dName =new JLabel("name");
		JLabel userLabel = new JLabel ("Username");
		JLabel passwordLabel = new JLabel ("Password");

		

		insidePanel.add(didLabel);
		insidePanel.add(NID);

		insidePanel.add(regDate);
		insidePanel.add(registartionDate);
		
		insidePanel.add(qualificatonDate);
		insidePanel.add(qualificatianDate);
		
		insidePanel.add(dName);
		insidePanel.add(nurName);
		
		insidePanel.add(dgender);
		insidePanel.add(gender);

		
		

		insidePanel.add(userLabel);
		insidePanel.add(userName);

		insidePanel.add(passwordLabel);
		insidePanel.add(passWord);

		//buttons 
		JPanel buttonPanel = new JPanel();


		buttonClear.addActionListener(this);
		buttonExit.addActionListener(this);
		buttonSave.addActionListener(this);
		buttonEdit.addActionListener(this);

	
		buttonPanel.add(buttonClear);
		buttonPanel.add(buttonSave);
		buttonPanel.add(buttonExit);
		buttonPanel.add(buttonEdit);
		buttonPanel.add(buttonDelete);


		// table layout
		Container tableButtonContainer = getContentPane();
		tableButtonContainer.setLayout(new BorderLayout());
		tableButtonContainer.setLayout(new BoxLayout(tableButtonContainer, BoxLayout.Y_AXIS));
		tableButtonContainer.add(insidePanel, BorderLayout.WEST);

		// table with 6 columns
		tableModel = new DefaultTableModel(0,9);

		// Name columns
		String column[] =  { "nurseID", "name","regdate","qualidate","gender","UserName","PassWord"};
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

		ArrayList<String> nurseArray= new ArrayList<String>();

		
		File t = new File("nurse.txt");

		try{

			Scanner data = new Scanner(t);

			data.useDelimiter("[,\n]");


			while(data.hasNext()&& n<=tableModel.getRowCount()) {
				tableModel.setRowCount(n + 1);
				
				for(int j=0;j<7;j++) {
					
					nurseArray.add(j,data.next());
					
					
					
				}
				for(int y=0;y<7;y++) {
				tableModel.setValueAt(nurseArray.get(y), n, y);
				
				}
				n++;

			}



			data.close();





		}
		catch(IOException e){ System.out.println(e);

		}
		
	





	contactTable.addMouseListener(new MouseAdapter(){

		@Override
		public void mouseClicked(MouseEvent e){

			
			int j = contactTable.getSelectedRow();
			NID.setText((String) tableModel.getValueAt(j,0));
			registartionDate.setText((String) tableModel.getValueAt(j,1));
			qualificatianDate.setText((String) tableModel.getValueAt(j,2));
			nurName.setText((String) tableModel.getValueAt(j,3));
			gender.setText((String) tableModel.getValueAt(j,4));
			userName.setText((String) tableModel.getValueAt(j,5));
			passWord.setText((String) tableModel.getValueAt(j,6)); 
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
	
	File data = new File("nurse.txt");
	File user = new File("LoginNurse.txt");

	try{

		FileWriter data1 = new FileWriter(data);

		FileWriter Login1 = new FileWriter(user);

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

	}
	













public void Edit() {
	
	

			String contact = nurName.getText();
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
				JOptionPane.showMessageDialog(null, "Please enter a valid 10 digit password", "Error", JOptionPane.ERROR_MESSAGE);
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





			String did = NID.getText();
			try
			{
				Integer.parseInt(did);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter a valid nurse ID", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("Please enter a valid nurse Id");

				return;
			}

	
	
	
	int i = contactTable.getSelectedRow();
	
	tableModel.setValueAt(NID.getText(),i,0);
	tableModel.setValueAt( registartionDate.getText(), i, 1);
	tableModel.setValueAt(  qualificatianDate.getText(), i, 2);
	tableModel.setValueAt(nurName.getText(), i, 3);
	tableModel.setValueAt(gender.getText(), i, 4);
	tableModel.setValueAt(userName.getText(), i, 5);
	tableModel.setValueAt(passWord.getText(), i, 6);
	
	
	
	
	
	
}

//Clear values 
void DeleteDoc() 


{                        

	
	
	
	
	
	
	

	NID.setText(null);
	nurName.setText(null); 
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
            new editNurse().setVisible(true);
        }
    });
}



public void saveAction(){

	File data = new File("nurse.txt");
	File user = new File("LoginNurse.txt");

	try{

		FileWriter data1 = new FileWriter(data);

		FileWriter Login1 = new FileWriter(user);

		for(int i=0; i< tableModel.getRowCount(); i++) {
			for(int j=0; j<tableModel.getColumnCount(); j++) {

				if(j==8) {
					data1.write(tableModel.getValueAt(i,j).toString());
				}

				else {
					data1.write(tableModel.getValueAt(i,j).toString()+",");
				}

			}

			Login1.write(tableModel.getValueAt(i,4).toString()+","+"\t");
			Login1.write(tableModel.getValueAt(i,5).toString()+"\t");

			data1.write("\r\n");
			Login1.write("\r\n");
		}


		data1.close();
		Login1.close();


		





	}catch(IOException e){ System.out.println(e); }
}
}
