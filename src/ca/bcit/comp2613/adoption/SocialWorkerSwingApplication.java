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

public class SocialWorkerSwingApplication {

    private JFrame frame;
    private JTable table; 
    private JTextField idTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;  
    private JTextField regionTextField;
  
    private JLabel lblId;
   
    private SwingMainModel swingMainModel;
 
    public String[] columnNames = new String[] { "id", "First Name",
            "Last Name", "Region" };


    public static List<SocialWorker> SocialWorkers;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SocialWorkerSwingApplication window = new SocialWorkerSwingApplication();
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
    public SocialWorkerSwingApplication() {
        SocialWorkers = SearchAndCreateSocialWorker.createSocialWorkers();
        initialize();
        initTable();
    }

    private void initTable() {

        //table = new JTable(swingMainModel);
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
            regionTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 3).toString());

        } catch (Exception e) {}
    }

    public void doSave() {
        String id = idTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        @SuppressWarnings("unused")
        String region = regionTextField.getText();    
        SocialWorker SocialWorker = new SocialWorker(id, firstName, lastName, null);        
 
        SearchAndCreateSocialWorker.save(SocialWorkers, SocialWorker);

        //table.clearSelection();
        refreshTable();
    }
    
    public void doDelete() {
        String id = idTextField.getText();
        SocialWorker SocialWorker = new SocialWorker(id, null, null, null);
        SearchAndCreateSocialWorker.delete(SocialWorkers, SocialWorker);
        refreshTable();
    }
    
    public void doNew() {
        String id = UUID.randomUUID().toString();
        idTextField.setText(id);
        firstNameTextField.setText("");
        lastNameTextField.setText("");  
        regionTextField.setText("");
    }

    private void refreshTable() {
        //swingMainModel = new SwingMainModel();
        Object[][] data = null;

        data = new Object[SocialWorkers.size()][4];
        int i = 0;
        for (SocialWorker SocialWorker : SocialWorkers) {
            data[i][0] = SocialWorker.getId();
            data[i][1] = SocialWorker.getFirstName();
            data[i][2] = SocialWorker.getLastName();
            data[i][3] = SocialWorker.getRegion();
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

        JLabel lblRegion = new JLabel("Region");
        lblRegion.setBounds(44, 408, 77, 14);
        frame.getContentPane().add(lblRegion);
        
        
        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(159, 328, 325, 20);
        frame.getContentPane().add(firstNameTextField);
        firstNameTextField.setColumns(10);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(159, 368, 325, 20);
        frame.getContentPane().add(lastNameTextField);
        lastNameTextField.setColumns(10);

        regionTextField = new JTextField();
        regionTextField.setBounds(159, 408, 325, 20);
        frame.getContentPane().add(regionTextField);
        regionTextField.setColumns(10);        
        
        
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
