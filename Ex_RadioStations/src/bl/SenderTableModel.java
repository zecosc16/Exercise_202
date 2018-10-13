/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import GUI.GUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oskar
 */
public class SenderTableModel extends AbstractTableModel{
    
    private String[] colNames = {"Sender","Frequenz","Band"};
    private int colL=3;

    private ArrayList<Sender> sender = new ArrayList<>();
     private ArrayList<Sender> filtered = new ArrayList<>();
    
    public void add(Sender s){
        sender.add(s);
        filtered.add(s);
        Collections.sort(sender);
        Collections.sort(filtered);
        fireTableRowsInserted(filtered.size()-1,filtered.size()-1);
    }
    @Override
    public int getRowCount() {
        return filtered.size();
    }

    @Override
    public int getColumnCount() {
        return colL;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return filtered.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void updateColBand(boolean show){
        if(show){
            colL=3;
        }
        else{
            colL=2;
        }
        
        fireTableStructureChanged();
    }
    
    public void readFile(File f) {
         try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line ="";
                String[] parts;
             try {
                 while((line=br.readLine())!=null){
                     parts=line.split(",");
                     this.add(new Sender(parts[0],parts[1],Double.parseDouble(parts[2])));
                 }
             } catch (IOException ex) {
                 Logger.getLogger(SenderTableModel.class.getName()).log(Level.SEVERE, null, ex);
             }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void writeFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./save.csv"));
            for (Sender s : sender) {
                bw.write(String.format("%s,%s,%f", s.getSendername(),s.getBand(),s.getFrequenz()));
                bw.newLine();
            }
            System.out.println("halo");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(SenderTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
