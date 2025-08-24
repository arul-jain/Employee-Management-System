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
public class Add_Employee extends JFrame implements ActionListener
{
  JLabel title,name,address, mob_no,password,email_id,position,team,emp_id;
  JTextField name_text,address_text,mob_no_text,password_text,email_id_text,position_text,team_text,emp_id_text;
  JButton enter,back;
  String emp_back;
  Add_Employee(String empback)
  {
      emp_back = empback;
      setTitle("Add Employee Data");
      getContentPane().setBackground(Color.WHITE);
      title = new JLabel("ADD EMPLOYEE DATA");
      
      name = new JLabel("Name");
      address = new JLabel("Address");
      mob_no = new JLabel("Mobile Number");
      password = new JLabel("Password");
      email_id = new JLabel("Email_id");
      position = new JLabel("Position");
      team = new JLabel("Team");
      emp_id = new JLabel("Employee ID");
      
      name_text = new JTextField();
      address_text = new JTextField();
      mob_no_text = new JTextField();
      password_text = new JTextField();
      email_id_text = new JTextField();
      position_text = new JTextField();
      team_text = new JTextField();
      emp_id_text = new JTextField();
      
      enter = new JButton("Enter");
      back = new JButton("Back");
      
      title.setBounds(415,50,1200,60);
      name.setBounds(100,150,100,100);
      address.setBounds(100,250,100,100);
      mob_no.setBounds(100,350,150,100);
      password.setBounds(100,450,100,100);
      email_id.setBounds(800,150,100,100);
      position.setBounds(800,250,100,100);
      team.setBounds(800,350,100,100);
      emp_id.setBounds(800,450,150,100);
      
      
      name_text.setBounds(300,175,200,50);
      address_text.setBounds(300,275,200,50);
      mob_no_text.setBounds(300,375,200,50);
      password_text.setBounds(300,475,200,50);
      email_id_text.setBounds(1000,175,200,50);
      position_text.setBounds(1000,275,200,50);
      team_text.setBounds(1000,375,200,50);
      emp_id_text.setBounds(1000,475,200,50);
      
      enter.setBounds(450,615,200,50);
      back.setBounds(750,615,200,50);
      
      title.setFont(new Font("Times New Roman",Font.BOLD,60));
      name.setFont(new Font("Times New Roman",Font.BOLD,20));
      address.setFont(new Font("Times New Roman",Font.BOLD,20));
      mob_no.setFont(new Font("Times New Roman",Font.BOLD,20));
      password.setFont(new Font("Times New Roman",Font.BOLD,20));
      email_id.setFont(new Font("Times New Roman",Font.BOLD,20));
      position.setFont(new Font("Times New Roman",Font.BOLD,20));
      team.setFont(new Font("Times New Roman",Font.BOLD,20));
      emp_id.setFont(new Font("Times New Roman",Font.BOLD,20));
      
      enter.setFont(new Font("Times New Roman",Font.BOLD,20));
      back.setFont(new Font("Times New Roman",Font.BOLD,20));
      
      name_text.setFont(new Font("Times New Roman",Font.BOLD,15));
      address_text.setFont(new Font("Times New Roman",Font.BOLD,15));
      mob_no_text.setFont(new Font("Times New Roman",Font.BOLD,15));
      password_text.setFont(new Font("Times New Roman",Font.BOLD,15));
      email_id_text.setFont(new Font("Times New Roman",Font.BOLD,15));
      position_text.setFont(new Font("Times New Roman",Font.BOLD,15));
      team_text.setFont(new Font("Times New Roman",Font.BOLD,15));
      emp_id_text.setFont(new Font("Times New Roman",Font.BOLD,15));
      
      
      
      enter.setBackground(Color.RED);
      enter.setForeground(Color.WHITE);
      back.setBackground(Color.RED);
      back.setForeground(Color.WHITE);
      
      
      add(title);
      add(name);
      add(address);
      add(mob_no);
      add(password);
      add(email_id);
      add(position);
      add(team);
      add(emp_id);
      
      add(name_text);
      add(address_text);
      add(mob_no_text);
      add(password_text);
      add(email_id_text);
      add(position_text);
      add(team_text);
      add(emp_id_text);
      
      enter.addActionListener(this);
      back.addActionListener(this);
      add(enter);
      add(back);
      
      setSize(1920,1080);
      setLayout(null);
      setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e)
  {
      if(e.getSource() == enter)
      {
         String name = name_text.getText();
         String address = address_text.getText();
         String mob_no = mob_no_text.getText();
         String password = password_text.getText();
         String email_id = email_id_text.getText();
         String position = position_text.getText();
         String team = team_text.getText();
         String emp_id = emp_id_text.getText();
         try
         {
             Connections c = new Connections();
             String query = "insert into employee values('"+name+"', '"+address+"', '"+mob_no+"', '"+password+"', '"+email_id+"', '"+position+"', '"+team+"', '"+emp_id+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Succesfully added");   
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
