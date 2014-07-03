package ca.bcit.comp2613.adoption.model;

import javax.swing.table.DefaultTableModel;

public class SwingAdoptionModel extends DefaultTableModel {

    private static final long serialVersionUID = 1L;

    public boolean isCellEditable(int row, int column) {
        return false;
     }
    
}

