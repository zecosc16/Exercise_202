/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_radiostations;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oskar
 */
public class SenderTableModel extends AbstractTableModel{

    private ArrayList<Sender> sender = new ArrayList<>();
    @Override
    public int getRowCount() {
        return sender.size();
    }

    @Override
    public int getColumnCount() {
        retur
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return sender;
    }
    
}
