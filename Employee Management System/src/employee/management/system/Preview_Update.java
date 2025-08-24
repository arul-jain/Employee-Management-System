/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author arulj
 */
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Preview_Update extends JFrame implements ActionListener
{
    JLabel emp_id,title,image;
    JTextField emp_id_Text;
    JButton enter,back;
    String emp_back;
    Preview_Update(String empback)
    {
         emp_back = empback;
      setTitle("Preview_Update");
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Preview Update.jpg"));
      Image i2 = i1.getImage().getScaledInstance(1600,1000,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      image = new JLabel(i3);
      image.setBounds(0,0,1550,800);
      add(image);
      
      title = new JLabel("Preview Update");
      emp_id = new JLabel("Employee ID");
      emp_id_Text = new JTextField();
      enter = new JButton("Enter");
      back = new JButton("Back");
      
      enter.setBackground(Color.BLACK);
      enter.setForeground(Color.WHITE);
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      
      enter.setFont(new Font("Times New Roman",Font.BOLD,20));
      back.setFont(new Font("Times New Roman",Font.BOLD,20));
      
      
      
      title.setFont(new Font("Times New Roman",Font.BOLD,60));
      emp_id.setFont(new Font("Times New Roman",Font.BOLD,20));
      
      emp_id_Text.setFont(new Font("Times New Roman",Font.BOLD,15));
     
      title.setBounds(550,50,1200,60);
      emp_id.setBounds(450, 150, 200, 100);
      emp_id_Text.setBounds(600,175,200,50);
      enter.setBounds(600, 275, 200, 50);
      back.setBounds(600, 375, 200, 50);
      
      enter.addActionListener(this);
      back.addActionListener(this);
      
      image.add(title);
      image.add(enter);
      image.add(emp_id);
      image.add(emp_id_Text);
      image.add(back);
      
      setLayout(null);
      setSize(1700, 1700);
      setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == enter)
        {
            try
            {
             String empid = emp_id_Text.getText();
             Connections c = new Connections();
             String query = "select * from employee where emp_id = '"+empid+"'";
             ResultSet rs =  c.s.executeQuery(query);
             if(rs.next())
              {
                  dispose();
                  new Update_Employee(empid,emp_back);
              }
             else
             {
                  JOptionPane.showMessageDialog(null, "Invalid employee id");
                 
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
      }
    }