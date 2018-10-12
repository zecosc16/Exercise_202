/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex_radiostations;

/**
 *
 * @author oskar
 */
public class Sender {
    private String Sendername,Band;
    private double frequenz;

    public Sender(String Sendername, String Band, double frequenz) {
        this.Sendername = Sendername;
        this.Band = Band;
        this.frequenz = frequenz;
    }

    public String getSendername() {
        return Sendername;
    }

    public String getBand() {
        return Band;
    }

    public double getFrequenz() {
        return frequenz;
    }
    
}
