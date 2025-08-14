
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
        
        //init
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,300,500,500);

        //panel
        base = new JPanel();
        base.setBorder(new EmptyBorder(10,10,10,10));
        setContentPane(base);
        base.setLayout(null);

        //labels and buttons
        namelabel = new JLabel("Name");
        namelabel.setBounds(50,50,200,20);
        base.add(namelabel);
        nametext = new JTextField();
        nametext.setBounds(200,50,200,50);
        nametext.setColumns(15);
        base.add(nametext);
        hclabel = new JLabel("HeadCount");
        hclabel.setBounds(50,100,200,20);
        base.add(hclabel);
        hctext = new JTextField();
        hctext.setBounds(200,100,200,50);
        hctext.setColumns(15);
        base.add(hctext);
        addrlabel = new JLabel("Address");
        addrlabel.setBounds(50,150,200,20);
        base.add(addrlabel);
        addrtext = new JTextField();
        addrtext.setBounds(200,150,200,50);
        addrtext.setColumns(15);
        base.add(addrtext);
        budgetlabel = new JLabel("Budget");
        budgetlabel.setBounds(50,200,200,20);
        base.add(budgetlabel);
        budgettext = new JTextField();
        budgettext.setBounds(200,200,200,50);
        budgettext.setColumns(15);
        base.add(budgettext);
        attendeeslabel = new JLabel("Attendees");
        attendeeslabel.setBounds(50,250,200,20);
        base.add(attendeeslabel);
        attendeestext = new JTextField();
        attendeestext.setBounds(200,250,200,50);
        attendeestext.setColumns(15);
        base.add(attendeestext);


        saveeventBtn = new JButton("Save Event");
        saveeventBtn.setBounds(150,300,200,20);
        base.add(saveeventBtn);
        saveeventBtn.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                create_event(nametext.getText(), addrtext.getText(),hctext.getText(), budgettext.getText(),attendeestext.getText());
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

    void create_event(String name, String addr, String hc, String budget, String atd){
                Event tmp = new Event(name, addr, hc, budget, atd);
                MainPanelGUI.FM.addEventToFile(tmp);
                currframe.dispose();
    }

}
