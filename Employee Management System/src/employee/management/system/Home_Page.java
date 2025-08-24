/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author arulj
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Home_Page extends JFrame implements ActionListener
{
    JButton add_emp,view_emp,remove_emp,update_emp,back,view_your_data;
    JLabel image,title;
    String emp_back;
    Home_Page(String empback)
    {
        emp_back = empback;
        setTitle("Home Page");
        add_emp = new JButton("Add Employee Data");
        view_emp = new JButton("View Employee Data");
        remove_emp = new JButton("Remove Employee Data");
        update_emp = new JButton("Update Employee Data");
        view_your_data = new JButton("View Your Data");
        back = new JButton("Back");
        
        title = new JLabel("Employee Management System");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1700,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,1700,900);
        add(image);
        
        add_emp.addActionListener(this);
        view_emp.addActionListener(this);
        remove_emp.addActionListener(this);
        update_emp.addActionListener(this);
        view_your_data.addActionListener(this);
        back.addActionListener(this);
        
        view_emp.setBounds(600, 200, 200, 50);
        view_your_data.setBounds(900, 200, 200, 50);
        add_emp.setBounds(600, 300, 200, 50);
        remove_emp.setBounds(900, 300, 200, 50);
        back.setBounds(1200, 200, 200, 50);
        update_emp.setBounds(1200, 300, 200, 50);
        title.setBounds(600,50,600,60);
        
        title.setFont(new Font("Times New Roman",Font.BOLD,40));
        add_emp.setFont(new Font("Times New Roman",Font.BOLD,15));
        view_emp.setFont(new Font("Times New Roman",Font.BOLD,15));
        remove_emp.setFont(new Font("Times New Roman",Font.BOLD,15));
        update_emp.setFont(new Font("Times New Roman",Font.BOLD,15));
        view_your_data.setFont(new Font("Times New Roman",Font.BOLD,15));
        back.setFont(new Font("Times New Roman",Font.BOLD,15));
        title.setForeground(Color.WHITE);
        
        add_emp.setBackground(Color.WHITE);
        add_emp.setForeground(Color.BLACK);
        view_emp.setBackground(Color.WHITE);
        view_emp.setForeground(Color.BLACK);
        remove_emp.setBackground(Color.WHITE);
        remove_emp.setForeground(Color.BLACK);
        update_emp.setBackground(Color.WHITE);
        update_emp.setForeground(Color.BLACK);
        view_your_data.setBackground(Color.WHITE);
        view_your_data.setForeground(Color.BLACK);
        
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        
        
        
        image.add(title);
        
        image.add(view_emp);
       
       
        image.add(view_your_data);
        image.add(back);
        
        
        try
        {
        Connections c = new Connections();
        String query = "select * from employee where emp_id = '"+emp_back+"'";
        ResultSet rs =  c.s.executeQuery(query);
        if(rs.next())
            {
          String pos = rs.getString("position");
          pos = pos.trim();
          
          boolean bb = "Admin".equals(pos);
         
                if(bb)
                {
                   image.add(add_emp); 
                   image.add(remove_emp);
                   image.add(update_emp);
                }
        
        
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

            
        setSize(1700,1700);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == add_emp)
        {
            dispose();
            new Add_Employee(emp_back);
        }
        if(e.getSource() == view_emp)
        {
            dispose();
            new View_Employee(emp_back);
        }
        if(e.getSource() == remove_emp)
        {
            dispose();
            new Remove_Employee(emp_back);
        }
        if(e.getSource() == update_emp)
        {
            dispose();
            new Preview_Update(emp_back);
        }
        if(e.getSource() == back)
        {
            dispose();
            new Login_Page();
        }
        if(e.getSource() == view_your_data)
        {
            dispose();
            new View_Your_Data(emp_back);
        }
     }
    
}
