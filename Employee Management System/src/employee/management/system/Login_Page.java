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

class Login_Page extends JFrame implements ActionListener
{
    JLabel emp_id,password,title,image;
    JTextField emp_id_Text,passtext;
    String emp_id_String;
    JButton enter,exit;
    Login_Page()
    {
      setTitle("Login Page");
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Login.jpeg"));
      Image i2 = i1.getImage().getScaledInstance(1700,800,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      image = new JLabel(i3);
      image.setBounds(0,0,1700,800);
      add(image);
      
      title = new JLabel("LOGIN PAGE");
      emp_id = new JLabel("Employee ID");
      password = new JLabel("Password");
      emp_id_Text = new JTextField();
      passtext = new JTextField();
      enter = new JButton("Enter");
      exit = new JButton("Exit");
      
      enter.setBackground(Color.BLACK);
      enter.setForeground(Color.WHITE);
      exit.setBackground(Color.BLACK);
      exit.setForeground(Color.WHITE);
      
      
      
      title.setFont(new Font("Times New Roman",Font.BOLD,60));
      emp_id.setFont(new Font("Times New Roman",Font.BOLD,20));
      password.setFont(new Font("Times New Roman",Font.BOLD,20));
      emp_id_Text.setFont(new Font("Times New Roman",Font.BOLD,20));
      passtext.setFont(new Font("Times New Roman",Font.BOLD,20));
      enter.setFont(new Font("Times New Roman",Font.BOLD,20));
      exit.setFont(new Font("Times New Roman",Font.BOLD,20));
     
      title.setBounds(550,50,1200,60);
      emp_id.setBounds(480, 150, 200, 100);
      password.setBounds(500,250 ,100,100 );
      emp_id_Text.setBounds(600,175,200,50);
      passtext.setBounds(600,275,200,50);
      enter.setBounds(600, 375, 200, 50);
      exit.setBounds(600, 475, 200, 50);
      
      enter.addActionListener(this);
      exit.addActionListener(this);
        
      
      
      image.add(title);
      image.add(enter);
      image.add(emp_id);
      image.add(password);
      image.add(emp_id_Text);
      image.add(passtext);
      image.add(exit);
      
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
        emp_id_String = emp_id_Text.getText();
        String passString = passtext.getText();
        Connections c = new Connections();
        String query = "select * from employee where emp_id = '"+emp_id_String+"' and pass_word = '"+passString+"'";
        ResultSet rs =  c.s.executeQuery(query);
        if(rs.next())
        {
          String pos = rs.getString("position");
          pos = pos.trim();
          boolean b = "Manager".equals(pos);
          boolean bb = "Admin".equals(pos);
          boolean bbb = b || bb;
          
          if(bbb)
          {
              dispose();
              new Home_Page(emp_id_String);
          
          }
          else
          {
              dispose();
              new View_Your_Data(emp_id_String);
          }
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
        }
        catch(Exception a)
        {
          a.printStackTrace();
        }
        }
        if(e.getSource() == exit)
        {
            dispose();
        }
      }
    }

