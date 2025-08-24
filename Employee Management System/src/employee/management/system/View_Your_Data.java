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
public class View_Your_Data extends JFrame implements ActionListener
{
  JLabel title,name,address, mob_no,password,email_id,position,team,emp_id,emp_id_text;
  JLabel name_text,address_text,mob_no_text,password_text,email_id_text,position_text,team_text;
  JButton exit,back;
  String emp_back;
  
  View_Your_Data(String empid)
  {
      emp_back = empid;
      setTitle("View Your Data");
      getContentPane().setBackground(Color.WHITE);
      title = new JLabel("VIEW YOUR DATA");
      
      name = new JLabel("Name");
      address = new JLabel("Address");
      mob_no = new JLabel("Mobile Number");
      password = new JLabel("Password");
      email_id = new JLabel("Email_id");
      position = new JLabel("Position");
      team = new JLabel("Team");
      emp_id = new JLabel("Employee ID");
      
      name_text = new JLabel("");
      address_text = new JLabel("");
      mob_no_text = new JLabel("");
      password_text = new JLabel("");
      email_id_text = new JLabel("");
      position_text = new JLabel("");
      team_text = new JLabel("");
      emp_id_text = new JLabel();
      
      
      exit = new JButton("Exit");
      back = new JButton("Back");
      
      title.setBounds(395,50,1200,60);
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
      
      
      exit.setBounds(750,615,200,50);
      back.setBounds(450,615,200,50);
      
      title.setFont(new Font("Times New Roman",Font.BOLD,60));
      name.setFont(new Font("Times New Roman",Font.BOLD,20));
      address.setFont(new Font("Times New Roman",Font.BOLD,20));
      mob_no.setFont(new Font("Times New Roman",Font.BOLD,20));
      password.setFont(new Font("Times New Roman",Font.BOLD,20));
      email_id.setFont(new Font("Times New Roman",Font.BOLD,20));
      position.setFont(new Font("Times New Roman",Font.BOLD,20));
      team.setFont(new Font("Times New Roman",Font.BOLD,20));
      emp_id.setFont(new Font("Times New Roman",Font.BOLD,20));
      emp_id_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      
      name_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      address_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      mob_no_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      password_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      email_id_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      position_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      team_text.setFont(new Font("Times New Roman",Font.BOLD,20));
      //emp_id_text.setFont(new Font("Times New Roman",Font.BOLD,15));

      
      
      exit.setFont(new Font("Times New Roman",Font.BOLD,20));
      back.setFont(new Font("Times New Roman",Font.BOLD,20));
      
      
      exit.setBackground(Color.RED);
      exit.setForeground(Color.WHITE);
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
      
      exit.addActionListener(this);
      back.addActionListener(this);
      
      try
      {
          Connections c = new Connections();
          String query = "select * from employee where emp_id = '"+empid+"'";
          ResultSet rs =  c.s.executeQuery(query);
          while(rs.next())
          {
              String pos = rs.getString("position");
              pos = pos.trim();
              boolean b = "Manager".equals(pos);
              boolean bb = "Admin".equals(pos);
              boolean bbb = b || bb;
              if(bbb)
              {
                  add(back);
              }
              name_text.setText(rs.getString("name"));
              address_text.setText(rs.getString("address"));
              mob_no_text.setText(rs.getString("mob_no"));
              password_text.setText(rs.getString("pass_word"));
              email_id_text.setText(rs.getString("email_id"));
              position_text.setText(rs.getString("position"));
              team_text.setText(rs.getString("team"));
              emp_id_text.setText(rs.getString("emp_id"));
          }
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      add(name_text);
      add(address_text);
      add(mob_no_text);
      add(password_text);
      add(email_id_text);
      add(position_text);
      add(team_text);
      add(emp_id_text);
      
      
      
      
      add(exit);
      
      setSize(1920,1080);
      setLayout(null);
      setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
      if(e.getSource() == exit)
      {
          dispose();
          new Login_Page();
      }
      if(e.getSource() == back)
      {
          dispose();
          new Home_Page(emp_back);
      }
      
  }
  
}

