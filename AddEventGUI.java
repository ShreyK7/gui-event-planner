
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class AddEventGUI extends JFrame{

        private JPanel base;
        private JLabel namelabel, hclabel, addrlabel, budgetlabel, attendeeslabel;
        private JTextField nametext, hctext, addrtext, budgettext, attendeestext;
        private JButton saveeventBtn,backBtn;
        private JFrame currframe = this;


    public AddEventGUI(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,300,500,500);

        base = new JPanel();
        base.setBorder(new EmptyBorder(10,10,10,10));
        setContentPane(base);
        base.setLayout(null);

        namelabel = new JLabel("Name");
        namelabel.setBounds(50,50,200,20);
        base.add(namelabel);

        nametext = new JTextField();
        nametext.setBounds(200,50,200,50);
        base.add(nametext);
        nametext.setColumns(15);

        hclabel = new JLabel("HeadCount");
        hclabel.setBounds(50,100,200,20);
        base.add(hclabel);

        hctext = new JTextField();
        hctext.setBounds(200,100,200,50);
        base.add(hctext);
        hctext.setColumns(15);

        addrlabel = new JLabel("Address");
        addrlabel.setBounds(50,150,200,20);
        base.add(addrlabel);

        addrtext = new JTextField();
        addrtext.setBounds(200,150,200,50);
        base.add(addrtext);
        addrtext.setColumns(15);

        budgetlabel = new JLabel("Budget");
        budgetlabel.setBounds(50,200,200,20);
        base.add(budgetlabel);

        budgettext = new JTextField();
        budgettext.setBounds(200,200,200,50);
        base.add(budgettext);
        budgettext.setColumns(15);

        attendeeslabel = new JLabel("Attendees");
        attendeeslabel.setBounds(50,250,200,20);
        base.add(attendeeslabel);

        attendeestext = new JTextField();
        attendeestext.setBounds(200,250,200,50);
        base.add(attendeestext);
        attendeestext.setColumns(15);


        saveeventBtn = new JButton("Save Event");
        saveeventBtn.setBounds(150,300,200,20);
        base.add(saveeventBtn);
        saveeventBtn.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Event tmp = new Event(nametext.getText(), addrtext.getText(),hctext.getText(), budgettext.getText(),attendeestext.getText() );
                MainPanelGUI.FM.addEventToFile(tmp);
                // MainPanelGUI.defaultlist.addElement(tmp);
                currframe.dispose();
            }
        });


        backBtn = new JButton("Back");
        backBtn.setBounds(150,350,200,20);
        base.add(backBtn);
        backBtn.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                currframe.dispose();
            }
        });


    }

}
