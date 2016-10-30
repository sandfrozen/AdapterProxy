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
public class ProxyVirtualData implements Data {

    private RealData data;
    private int size;

    public ProxyVirtualData(int size) {
        this.data = null;
        this.size = size;
    }

    @Override
    public int get(int idx) {
        return this.data == null ? 0 : this.data.get(idx);
    }

    @Override
    public void set(int idx, int value) {
        if( data == null ){
            System.out.println("Bylo proxy, stworzenie obkietu size: " + size);
            this.data = new RealData(size);
        } else{
            System.out.println("Bylo juz obiekt size: " + size);
        }
        this.data.set(idx, value);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        //return this.data==null ? false : true;
        return this.data == null;
    }

}
