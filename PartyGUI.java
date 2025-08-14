
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;


public class PartyGUI extends JFrame{

        private JPanel base;
        private JList displaylist;
        private DefaultListModel<Event> currentlist =  new DefaultListModel();
        private JButton backBtn, editeventBtn, deleteeventBtn;
        private JFrame currframe = this;


    public PartyGUI(){


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,300,500,500);

        base = new JPanel();
        base.setBorder(new EmptyBorder(10,10,10,10));
        setContentPane(base);
        base.setLayout(null);

        displaylist = new JList();
        displaylist.setBounds(10,10,250,300);
        base.add(displaylist);

        displaylist.setModel(currentlist);

        deleteeventBtn = new JButton("Delete Event");
        deleteeventBtn.setBounds(150,350,200,20);
        base.add(deleteeventBtn);
        deleteeventBtn.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                    if (displaylist.getSelectedIndex() >= 0 ){
                        MainPanelGUI.FM.removeEventFromFile(currentlist.get(displaylist.getSelectedIndex()).getName());
                        delete_event(displaylist.getSelectedIndex());

                    }
            }
        });


        editeventBtn = new JButton("Edit Event");
        editeventBtn.setBounds(150,400,200,20);
        base.add(editeventBtn);
        editeventBtn.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                    if (displaylist.getSelectedIndex() >= 0 ){
                        Event tmp = currentlist.get(displaylist.getSelectedIndex());
                        EventGUI egui = new EventGUI(tmp.getName(), tmp.getAddress(), tmp.getHeadcount(), tmp.getBudget(), tmp.getAttendees());
                        delete_event(displaylist.getSelectedIndex());
                        currframe.dispose();

                        egui.show();
                    }

            }
        });


        backBtn = new JButton("Back");
        backBtn.setBounds(150,450,200,20);
        base.add(backBtn);
        backBtn.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e){
                currframe.dispose();
            }
        });



        //init
        ArrayList<Event> loadlist = MainPanelGUI.FM.getEventsFromFile();
        for(int i = 0; i < loadlist.size(); i++){
            currentlist.addElement(loadlist.get(i));
        }
        // for(int i = 0; i < MainPanelGUI.defaultlist.size(); i++){
        //     currentlist.addElement(MainPanelGUI.defaultlist.get(i));
        // }
        displaylist.setModel(currentlist);  

    }


    //delete event
    public void delete_event(int tmp){
        // MainPanelGUI.defaultlist.remove(tmp);
        MainPanelGUI.FM.removeEventFromFile(currentlist.get(displaylist.getSelectedIndex()).getName());

        currentlist.remove(tmp);
    }
}
