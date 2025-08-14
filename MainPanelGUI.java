
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class MainPanelGUI extends JFrame{

        private JPanel base;
        private JButton addeventBTN, browseeventBTN;
        private JFrame currframe = this;
        static EventFileSystem FM = new EventFileSystem("events.txt");


    public MainPanelGUI(){



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,300,500,500);

        base = new JPanel();
        base.setBorder(new EmptyBorder(10,10,10,10));
        base.setLayout(null);
        setContentPane(base);


        addeventBTN = new JButton("Add Event");
        addeventBTN.setBounds(50,50,200,20);
        base.add(addeventBTN);
        addeventBTN.addActionListener(  new ActionListener() {
            public void actionPerformed(ActionEvent e){
                AddEventGUI aegui = new AddEventGUI();
                aegui.show();
            }
        });



        browseeventBTN = new JButton("Browse Events");
        browseeventBTN.setBounds(50,100,200,20);
        base.add(browseeventBTN);
        browseeventBTN.addActionListener(   new ActionListener() {
            public void actionPerformed(ActionEvent e){
                PartyGUI pgui = new PartyGUI();
                pgui.show();
            }
        });








    }

}
