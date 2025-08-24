import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class LoginPage extends JFrame implements ActionListener
{
    JLabel username,password,title;
    JTextField userText,passtext;
    JButton enter;
    LoginPage()
    {
      setTitle("Login Page");
      getContentPane().setBackground(Color.WHITE);
      title = new JLabel("LOGIN PAGE");
      username = new JLabel("Username");
      password = new JLabel("Password");
      userText = new JTextField("Enter here");
      passtext = new JTextField("Enter here");
      enter = new JButton("Enter");
      enter.setBackground(Color.BLACK);
      enter.setForeground(Color.WHITE);
      title.setBounds(550,50,1200,60);
      title.setFont(new Font("Times New Roman",Font.BOLD,60));
      username.setBounds(500, 200, 100, 100);
      password.setBounds(500,300 ,100,100 );
      userText.setBounds(600,225,200,50);
      passtext.setBounds(600,325,200,50);
      enter.setBounds(600, 425, 200, 50);
      enter.addActionListener(this);
      add(title);
      add(enter);
      add(username);
      add(password);
      add(userText);
      add(passtext);
      setLayout(null);
      setSize(10000, 10000);
      setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {

      if(e.getSource() == enter)
      {
        try
        {
        String userString = userText.getText();
        String passString = passtext.getText();
        Connections c = new Connections();
       // username.setText("Passed Connections");
        String query = "select * from login_page where username = '"+userString+"' and password = '"+passString+"'";
        ResultSet rs =  c.s.executeQuery(query);
        username.setText("Passed Result Set");
        if(rs.next())
        {
          setVisible(false);
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Invalid udername or password");
          setVisible(false);
        }
        }
        catch(Exception a)
        {
          a.printStackTrace();
        }
      }
        
    }
}