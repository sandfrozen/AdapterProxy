/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterproxy1;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author A5US
 */
class Baza extends AbstractListModel {

    private ArrayList<Data> ar = new ArrayList<Data>();
    
    public void add(Data tab) {
        ar.add(tab);
        fireIntervalAdded(ar, 0, 0);
    }
    
    public void remove(int idx) {
        ar.remove(idx);
        fireIntervalRemoved(ar, idx, idx);
    }
    
    @Override
    public int getSize() {
        return ar.size();
    }
    
    @Override
    public Object getElementAt(int index) {
        return ar.get(index);
    }
}
