/*

Demon a simple JList

*/

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ListDemo implements ListSelectionListener {

    JList<String> jlst;
    JLabel jlab;
    JScrollPane jscrlp;

    String names[] = { "Sherry", "jon", "Rachel", "Sasha", "Josselyn", "Randy",
                       "Tom", "Mary", "Ken", "Andrew", "Matt", "Todd" };
    ListDemo() {
        JFrame jfrm = new JFrame("Jlist demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 160);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jlst = new JList<String>(names);
        //jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(120, 90));

        jlab = new JLabel("Please choose a name");

        jlst.addListSelectionListener(this);

        jfrm.add(jscrlp);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent le) {
        int[] idx = jlst.getSelectedIndices();
        boolean bSelectionMade = false;
        String strSelectionText = "";

        if(idx.length != 0) {
            for (int i : idx) {
                strSelectionText += names[i] + " ";
                bSelectionMade = true;
            }
            jlab.setText("Current selection: " + strSelectionText);
        } else { strSelectionText = "Please choose a name"; }

        jlab.setText(strSelectionText);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListDemo();
            }
        });
    }
}