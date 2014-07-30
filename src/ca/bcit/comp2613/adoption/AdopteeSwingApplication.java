package ca.bcit.comp2613.adoption;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class AdopteeSwingApplication {

    private JFrame frame;
    private JTable table; 
    private JTextField idTextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField genderTextField;    
    private JTextField regionTextField;
    private JTextField birthYearTextField;
    private JTextField adoptionYearTextField;    
    private JTextField ageAtAdoptionTextField;    
    private JTextField socialWorkerTextField;    
    private JLabel lblId;
    
    private SwingMainModel swingMainModel;
    JComboBox<Gender> genderComboBox = new JComboBox<>();
    JComboBox<Region> regionComboBox = new JComboBox<>();
    JComboBox<SocialWorker> socialWorkerComboBox = new JComboBox<>();
    
    public String[] columnNames = new String[] { "id", "First Name",
            "Last Name", "Gender", "Region", "Birth Year", "Adoption Year", 
            "Age At Adoption", "Social Worker" };


    public static List<Adoptee> adoptees;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdopteeSwingApplication window = new AdopteeSwingApplication();
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
    public AdopteeSwingApplication() {
        adoptees = SearchAndCreateHelper.createAdoptees();
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
       
              genderComboBox.setModel(new DefaultComboBoxModel<>(Gender.values()));
             //       .getSelectedItem(table.getSelectedRow(), 3).toString());
            //genderComboBox.setModel(new DefaultComboBoxModel<>(Gender.values())
                  //    .getValueAt(table.getSelectedRow(), 3).toString());         
            
            regionComboBox.setModel(new DefaultComboBoxModel<>(Region.values()));
            
     /*       genderTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 3).toString()); 
            regionTextField.setText(table.getModel()        
                    .getValueAt(table.getSelectedRow(), 4).toString()); */
            
            birthYearTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 5).toString());
            adoptionYearTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 6).toString());
            ageAtAdoptionTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 7).toString());
            
       //     socialWorkerComboBox.setModel(new DefaultComboBoxModel<>(SocialWorker.values()));
            socialWorkerTextField.setText(table.getModel()
                    .getValueAt(table.getSelectedRow(), 8).toString());
        } catch (Exception e) {}
    }

    public void doSave() {
        String id = idTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
     //   String gender = genderTextField.getText();  
        Gender gender = (Gender)genderComboBox.getSelectedItem();       
      //  String region = regionTextField.getText();
        Region region = (Region)regionComboBox.getSelectedItem();
        
        String birthYear = birthYearTextField.getText();   
        String adoptionYear = adoptionYearTextField.getText();
        String ageAtAdoption = ageAtAdoptionTextField.getText();
        
        @SuppressWarnings("unused")
        Object socialWorker = socialWorkerTextField.getText();   
            
        Adoptee adoptee = new Adoptee(id, firstName, lastName, gender, region, birthYear, adoptionYear, ageAtAdoption, null);        

        SearchAndCreateHelper.save(adoptees, adoptee);

        //table.clearSelection();
        refreshTable();
    }
    
    public void doDelete() {
        String id = idTextField.getText();
        Adoptee adoptee = new Adoptee(id, null, null, null, null, null, null, null, null );
        SearchAndCreateHelper.delete(adoptees, adoptee);
        refreshTable();
    }
    
    public void doNew() {
        String id = UUID.randomUUID().toString();
        idTextField.setText(id);
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        genderTextField.setText("");  
        regionTextField.setText("");
        birthYearTextField.setText("");   
        adoptionYearTextField.setText("");
        ageAtAdoptionTextField.setText("");
        socialWorkerTextField.setText(""); 
    }

    private void refreshTable() {
        //swingMainModel = new SwingMainModel();
        Object[][] data = null;

        data = new Object[adoptees.size()][9];
        int i = 0;
        for (Adoptee adoptee : adoptees) {
            data[i][0] = adoptee.getId();
            data[i][1] = adoptee.getFirstName();
            data[i][2] = adoptee.getLastName();
            data[i][3] = adoptee.getGender();
            data[i][4] = adoptee.getRegion();
            data[i][5] = adoptee.getBirthYear();
            data[i][6] = adoptee.getAdoptionYear();
            data[i][7] = adoptee.getAgeAtAdoption();
            data[i][8] = adoptee.getSocialWorker();
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
        frame.setBounds(100, 100, 601, 750);
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

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(44, 408, 77, 14);
        frame.getContentPane().add(lblGender);

        JLabel lblRegion = new JLabel("Region");
        lblRegion.setBounds(44, 448, 77, 14);
        frame.getContentPane().add(lblRegion);
        
        JLabel lblBirthYear = new JLabel("Birth Year");
        lblBirthYear.setBounds(44, 488, 77, 14);
        frame.getContentPane().add(lblBirthYear);
        
        JLabel lblAdoptionYear = new JLabel("Adoption Year");
        lblAdoptionYear.setBounds(44, 528, 77, 14);
        frame.getContentPane().add(lblAdoptionYear);
        
        JLabel lblAgeAtAdoption = new JLabel("Age At Adoption");
        lblAgeAtAdoption.setBounds(44, 568, 77, 14);
        frame.getContentPane().add(lblAgeAtAdoption);
        
        JLabel lblSocialWorker = new JLabel("Social Worker");
        lblSocialWorker.setBounds(44, 608, 77, 14);
        frame.getContentPane().add(lblSocialWorker);
        
        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(159, 328, 325, 20);
        frame.getContentPane().add(firstNameTextField);
        firstNameTextField.setColumns(10);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(159, 368, 325, 20);
        frame.getContentPane().add(lastNameTextField);
        lastNameTextField.setColumns(10);

        genderTextField = new JTextField();
        genderTextField.setBounds(159, 408, 325, 20);
        frame.getContentPane().add(genderTextField);
        genderTextField.setColumns(10);        

        regionTextField = new JTextField();
        regionTextField.setBounds(159, 448, 325, 20);
        frame.getContentPane().add(regionTextField);
        regionTextField.setColumns(10);    
        
        birthYearTextField = new JTextField();
        birthYearTextField.setBounds(159, 488, 325, 20);
        frame.getContentPane().add(birthYearTextField);
        birthYearTextField.setColumns(10);    
        
        adoptionYearTextField = new JTextField();
        adoptionYearTextField.setBounds(159, 528, 325, 20);
        frame.getContentPane().add(adoptionYearTextField);
        adoptionYearTextField.setColumns(10); 
        
        ageAtAdoptionTextField = new JTextField();
        ageAtAdoptionTextField.setBounds(159, 568, 325, 20);
        frame.getContentPane().add(ageAtAdoptionTextField);
        ageAtAdoptionTextField.setColumns(10);    

        socialWorkerTextField = new JTextField();
        socialWorkerTextField.setBounds(159, 608, 325, 20);
        frame.getContentPane().add(socialWorkerTextField);
        socialWorkerTextField.setColumns(10); 
        
        
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doSave();
            }
        });
        btnSave.setBounds(44, 655, 89, 23);
        frame.getContentPane().add(btnSave);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doDelete();
            }
        });
        btnDelete.setBounds(169, 655, 89, 23);
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
