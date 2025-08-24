/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author arulj
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Remove_Employee extends JFrame implements ActionListener
{
    JLabel name,mob_no,email_id,emp_id,title,name_text,mob_no_text,email_id_text,image;
    JTextField emp_id_text;
    JButton delete,back,retrieve;
    String emp_back;
    Remove_Employee(String empback)
    {
        emp_back = empback;
      setTitle("Remove Employee Data");
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Remove.jpeg"));
      Image i2 = i1.getImage().getScaledInstance(1500,1000,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      image = new JLabel(i3);
      image.setBounds(900,0,800,800);
      add(image);
      getContentPane().setBackground(Color.WHITE);
      name = new JLabel("Name");
      mob_no = new JLabel("Mobile Number");
      email_id = new JLabel("Email ID");
      emp_id = new JLabel("Employee ID");
      title = new JLabel("DELETE EMPLOYEE DATA");
      
      name_text = new JLabel();
      mob_no_text = new JLabel();
      email_id_text = new JLabel();
      emp_id_text = new JTextField("Enter Employee ID");
      
      delete = new JButton("Delete");
      back = new JButton("Back");
      retrieve = new JButton("Retrieve");
      
      title.setBounds(50,50,1200,60);
      emp_id.setBounds(100,200,150,50);
      mob_no.setBounds(100,300,150,50);
      email_id.setBounds(100,400,150,50);
      name.setBounds(100,500,150,50);
      
      emp_id_text.setBounds(300,200,200,50);
      mob_no_text.setBounds(300,300,200,50);
      email_id_text.setBounds(300,400,200,50);
      name_text.setBounds(300,500,200,50);
      
      delete.setBounds(100,600,200,50);
      back.setBounds(400,600,200,50);
      retrieve.setBounds(250,700,200,50);
      
      title.setFont(new Font("Times New Roman",Font.BOLD,60));
      name.setFont(new Font("Times New Roman",Font.BOLD,20));
      mob_no.setFont(new Font("Times New Roman",Font.BOLD,20));
      email_id.setFont(new Font("Times New Roman",Font.BOLD,20));
      emp_id.setFont(new Font("Times New Roman",Font.BOLD,20));
      name_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      mob_no_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      email_id_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      emp_id_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      
      back.setFont(new Font("Times New Roman",Font.BOLD,20));
      retrieve.setFont(new Font("Times New Roman",Font.BOLD,20));
      delete.setFont(new Font("Times New Roman",Font.BOLD,20));
      
      
      
      delete.setBackground(Color.RED);
      delete.setForeground(Color.WHITE);
      back.setBackground(Color.RED);
      back.setForeground(Color.WHITE);
      retrieve.setBackground(Color.RED);
      retrieve.setForeground(Color.WHITE);
      
      add(name);
      add(mob_no);
      add(email_id);
      add(emp_id);
      
      add(name_text);
      add(mob_no_text);
      add(email_id_text);
      add(emp_id_text);
      
      delete.addActionListener(this);
      retrieve.addActionListener(this);
      back.addActionListener(this);
        
      add(delete);
      add(back);
      add(retrieve);
      
      add(title);
      
      setLayout(null);
      setSize(1920,1080);
      setVisible(true);
            
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == retrieve)
        {
            try
             {     
               Connections c = new Connections();
               String query = "select * from employee where emp_id = '"+emp_id_text.getText()+"'";
               ResultSet rs =  c.s.executeQuery(query);
               
               if(rs.next())
               {
               
                     name_text.setText(rs.getString("name"));
             
                     mob_no_text.setText(rs.getString("mob_no"));
             
                     email_id_text.setText(rs.getString("email_id"));
          
                      emp_id_text.setText(rs.getString("emp_id"));
                   
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Wrong Employee ID");
               }
                   
               
        }
        catch(Exception a)
              {
                a.printStackTrace();
              }
        }
        if(e.getSource() == back)
        {
            dispose();
            new Home_Page(emp_back);
        }
        if(e.getSource() == delete)
        {
            
            try
            {
            Connections c = new Connections();
            String query = "delete from employee where emp_id = '"+emp_id_text.getText()+"'";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Succesfully deleted");
            dispose();
            new Home_Page(emp_back);
            }
            catch(Exception a)
            {
                a.printStackTrace();
            }
    }
    }
}
