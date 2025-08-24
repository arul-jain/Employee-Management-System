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
import net.proteanit.sql.DbUtils;

public class View_Employee extends JFrame implements ActionListener
{
    JTable table;
    JScrollPane scroll;
    JButton back;
    JLabel title;
    String emp_back;
    String team_text;
    View_Employee(String empback)
    {
        emp_back = empback;
        setTitle("View Employee Data");
        getContentPane().setBackground(Color.WHITE);
        table = new JTable();
        try
        {
            Connections c = new Connections();
            String query = "select * from employee where emp_id = '"+emp_back+"'";
            ResultSet rs = c.s.executeQuery(query); 
            if(rs.next())
            {
               String pos = rs.getString("position");
               pos = pos.trim();
               boolean b = "Manager".equals(pos);
               boolean bb = "Admin".equals(pos);
               boolean bbb = b || bb;
               
                   if(bb)
                   {
                     
                    String q = "select * from employee";
                    ResultSet rs2 = c.s.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs2));
                   } 
                   else
                   {
                       
                       team_text = rs.getString("team");
                       String qq = "select * from employee where team = '" + team_text+"'";
                       ResultSet rs3 = c.s.executeQuery(qq);
                       table.setModel(DbUtils.resultSetToTableModel(rs3));
                   }
            }
                
            
           
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        scroll = new JScrollPane(table);
        scroll.setBounds(0,200,1530,1920);
        add(scroll);
        back = new JButton("Back");
        back.setBounds(20,100,200,50);
        
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        
        back.addActionListener(this);
        add(back);
        title = new JLabel("View Employee Data");
        title.setFont(new Font("Times New Roman",Font.BOLD,60));
        back.setFont(new Font("Times New Roman",Font.BOLD,20));
        title.setBounds(500,50,1200,70);
        add(title);
        setLayout(null);
        setSize(1920,1080);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == back)
        {
           dispose();
           new Home_Page(emp_back); 
        }
            
    }
}
