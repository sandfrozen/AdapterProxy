/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterproxy1;

/**
 *
 * @author A5US
 */
public class RealData implements Data {

    int tab[];

    public RealData(int size) {
        tab = new int[size];
    }

    @Override
    public int get(int idx) {
        return tab[idx];
    }

    @Override
    public void set(int idx, int value) {
        tab[idx] = value;
    }

    @Override
    public int size() {
        return tab.length;
    }

}
