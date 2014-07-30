package ca.bcit.comp2613.adoption;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.bcit.comp2613.adoption.model.*;
import ca.bcit.comp2613.adoption.util.*;

public class AdoptiveMotherSwingApplication {

    private JFrame frame;
    private JTable table; 
    private JTextField idTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;  
    private JTextField yearsWaitingTextField;
  
    private JLabel lblId;
   
    private SwingMainModel swingMainModel;
 
    public String[] columnNames = new String[] { "id", "First Name",
            "Last Name", "Years Waiting" };


    public static List<AdoptiveMother> AdoptiveMothers;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdoptiveMotherSwingApplication window = new AdoptiveMotherSwingApplication();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AdoptiveMotherSwingApplication() {
        AdoptiveMothers = SearchAndCreateAdoptiveMother.createAdoptiveMothers();
        initialize();
        initTable();
    }

    private void initTable() {

        //table = new JTable(AdoptiveMotherModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (e.getValueIsAdjusting()) {
                            populateFields();
                        }
                    }
                });
        refreshTable();

    }

    private void populateFields() {
        try {
            idTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 0).toString());
            firstNameTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 1).toString());
            lastNameTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 2).toString());
            yearsWaitingTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 3).toString());

        } catch (Exception e) {}
    }

    public void doSave() {
        String id = idTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String yearsWaiting = yearsWaitingTextField.getText();    
        AdoptiveMother AdoptiveMother = new AdoptiveMother(id, firstName, lastName, yearsWaiting);        
 
        SearchAndCreateAdoptiveMother.save(AdoptiveMothers, AdoptiveMother);

        //table.clearSelection();
        refreshTable();
    }
    
    public void doDelete() {
        String id = idTextField.getText();
        AdoptiveMother AdoptiveMother = new AdoptiveMother(id, null, null, null);
        SearchAndCreateAdoptiveMother.delete(AdoptiveMothers, AdoptiveMother);
        refreshTable();
    }
    
    public void doNew() {
        String id = UUID.randomUUID().toString();
        idTextField.setText(id);
        firstNameTextField.setText("");
        lastNameTextField.setText("");  
        yearsWaitingTextField.setText("");
    }

    private void refreshTable() {
        //AdoptiveMotherModel = new AdoptiveMotherModel();
        Object[][] data = null;

        data = new Object[AdoptiveMothers.size()][4];
        int i = 0;
        for (AdoptiveMother AdoptiveMother : AdoptiveMothers) {
            data[i][0] = AdoptiveMother.getId();
            data[i][1] = AdoptiveMother.getFirstName();
            data[i][2] = AdoptiveMother.getLastName();
            data[i][3] = AdoptiveMother.getYearsWaiting();
            i++;
        }
        swingMainModel.setDataVector(data, columnNames);
        table.repaint();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 601, 510);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // table = new JTable();
        swingMainModel = new SwingMainModel();

        table = new JTable(swingMainModel);

        // table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        // table.setBounds(0, 11, 585, 247);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 11, 585, 247);
        frame.getContentPane().add(scrollPane);
        // scrollPane.add(table);
        // frame.getContentPane().add(table);

        lblId = new JLabel("ID");
        lblId.setBounds(44, 288, 46, 14);
        frame.getContentPane().add(lblId);
        
        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(44, 328, 103, 14);
        frame.getContentPane().add(lblFirstName);
        
        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(44, 368, 77, 14);
        frame.getContentPane().add(lblLastName);

        JLabel lblYearsWaiting = new JLabel("YearsWaiting");
        lblYearsWaiting.setBounds(44, 408, 77, 14);
        frame.getContentPane().add(lblYearsWaiting);
        
        
        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(159, 328, 325, 20);
        frame.getContentPane().add(firstNameTextField);
        firstNameTextField.setColumns(10);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(159, 368, 325, 20);
        frame.getContentPane().add(lastNameTextField);
        lastNameTextField.setColumns(10);

        yearsWaitingTextField = new JTextField();
        yearsWaitingTextField.setBounds(159, 408, 325, 20);
        frame.getContentPane().add(yearsWaitingTextField);
        yearsWaitingTextField.setColumns(10);        
        
        
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doSave();
            }
        });
        btnSave.setBounds(44, 450, 89, 23);
        frame.getContentPane().add(btnSave);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doDelete();
            }
        });
        btnDelete.setBounds(169, 450, 89, 23);
        frame.getContentPane().add(btnDelete);

        JButton btnNewButton = new JButton("New");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doNew();
            }
        });
        btnNewButton.setBounds(496, 260, 89, 23);
        frame.getContentPane().add(btnNewButton);

        idTextField = new JTextField();
        idTextField.setEditable(false);
        idTextField.setBounds(159, 285, 325, 20);
        frame.getContentPane().add(idTextField);
        idTextField.setColumns(10);
    }
}
