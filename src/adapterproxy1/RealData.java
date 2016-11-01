/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterproxy1;

import java.util.LinkedList;

/**
 *
 * @author A5US
 */
public class RealData implements Data {

    private int tab[];


    public RealData(int size) {
        this.tab = new int[size];
    }

    @Override
    public void set(int idx, int value) {
        tab[idx] = value;
    }

    @Override
    public int get(int idx) {
        return tab[idx];
    }

    @Override
    public int size() {
        return tab.length;
    }

    @Override
    public boolean isEmpty() {
        //zwraca true jesli tab==null
        return tab == null;
    }

}
