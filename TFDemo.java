// Input text and either reverse it or display it

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TFDemo implements ActionListener {
    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPrompt, jlabContents;

    TFDemo() {
        JFrame jfrm = new JFrame("Use a Text Field");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(240, 120);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtf = new JTextField(10);
        jtf.setActionCommand("myTF");

        JButton jbtnRev = new JButton("Reverse");

        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);

        jlabPrompt = new JLabel("Enter text: ");
        jlabContents = new JLabel("");

        jfrm.add(jlabPrompt);
        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jlabContents);

        jfrm.setVisible(true);
    }

    // Reverse the entered string if the Reverse-button is hit.  
    // If hit Enter, display the entered text.
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Reverse")) {
            String orgStr = jtf.getText();
            String resStr = "";

            for (int i=orgStr.length()-1; i >= 0; i--) 
                resStr += orgStr.charAt(i);
            
                jtf.setText(resStr);
        } else
            jlabContents.setText("You pressed ENTER. Text is: " + jtf.getText());
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable(){
        
            @Override
            public void run() {
                new TFDemo();
            }
        });
    }
}
