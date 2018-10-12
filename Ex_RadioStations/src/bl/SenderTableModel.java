/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import bl.Sender;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oskar
 */
public class SenderTableModel extends AbstractTableModel{
    
    private String[] colNames = {"Sender","Frequenz","Band"};

    private ArrayList<Sender> sender = new ArrayList<>();
     private ArrayList<Sender> filtered = new ArrayList<>();
    
    public void add(Sender s){
        sender.add(s);
        filtered.add(s);
        fireTableRowsInserted(filtered.size()-1,filtered.size()-1);
    }
    @Override
    public int getRowCount() {
        return filtered.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return filtered.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    
    
    
    
}
