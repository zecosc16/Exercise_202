/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import bl.Sender;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author oskar
 */
public class SenderTableRenderer implements TableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        Sender s = (Sender) value;
        label.setOpaque(true);
        if (s.getBand().equals("FM")) {
            
            label.setBackground(Color.red);
            
        } else {
            label.setBackground(Color.BLUE);
        }
        label.setFont(new Font("Courier New", Font.ITALIC, 14));
        label.setForeground(Color.lightGray);
        
        switch (column) {
            case 0:
                label.setText(s.getSendername());
                break;
            case 1:
                label.setText(String.format("%.2f", s.getFrequenz()));
                break;
            case 2:
                label.setText(s.getBand());
                break;
            default:
                label.setText("??");
            
        }
        
        if(isSelected){
            label.setBackground(Color.black);
            label.setForeground(Color.white);
        }
        return label;
        
    }
    
}
