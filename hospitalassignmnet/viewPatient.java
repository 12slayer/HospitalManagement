package hospitalassignmnet;


import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;
import java.io.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class viewPatient extends JFrame implements ActionListener 
    {
 
   
     
 
    
       
    public JButton exitBtn = new JButton("Exit");
    public DefaultTableModel tableModel;
    JTable contactTable = new JTable();
     boolean button=true;
     
     
     
    int c = 0;
    
     
    public viewPatient() 
    {
        super("View Detail");
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        
        setVisible(true);
        
        setResizable(true);
         
        // labels for everything
        
                 
      
                 
        //place for buttons 
        JPanel buttonPanel = new JPanel();
        
        
 
       
      
        exitBtn.addActionListener(this);
                
        
        buttonPanel.add(exitBtn);
 
        // table layout
        Container tableButtonContainer = getContentPane();
       
        tableButtonContainer.setLayout(new BorderLayout());
        tableButtonContainer.setLayout(new BoxLayout(tableButtonContainer, BoxLayout.Y_AXIS));
        
 
        // table with 6 columns
        tableModel = new DefaultTableModel(0,9);
        
         
                // Name columns
        String col[] =  { "name","dob","medicalstaff","patient id","email","address","phone","dateof treatment" };
        tableModel.setColumnIdentifiers(col);
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
        
ArrayList<String> doctorArray= new ArrayList<String>();


int i=0;
		
		File t = new File("patient.txt");

		try{

			Scanner data = new Scanner(t);

			data.useDelimiter("[,\n]");


			while(data.hasNext()&& i<=tableModel.getRowCount()) {
				tableModel.setRowCount(i + 1);
				
				for(int j=0;j<8;j++) {
					
					doctorArray.add(j,data.next());
					
					
					
				}
				for(int y=0;y<8;y++) {
				tableModel.setValueAt(doctorArray.get(y), i, y);
				
				}
				i++;

			}



			data.close();





		}
		catch(IOException e){ System.out.println(e);

		}
        
        
        
        
 
    }
 
   
    
    
                                                     
       
        
                  
    
    
    
    
    public void actionPerformed(ActionEvent event)
    {
    	
        JButton source = (JButton) event.getSource();
         if (source == exitBtn) 
        {
            quit();
        }
    }
 

    
    
  
    
    
    
   
                
             
    
    
       
    
    
 
//Clear values 
    
    
    
    
    
 
    
    
    
 
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
                new viewPatient().setVisible(true);
            }
        });
    }
 
  
 
         
    
  public void saveAction(){
     
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
      
        
   
        
        
 
    }catch(IOException e){ System.out.println(e); }
}
    }