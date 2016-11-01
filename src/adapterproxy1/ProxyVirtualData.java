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
public class ProxyVirtualData implements Data {

    private Data data;
    private int size;
    private LinkedList<KopiaProxyVirtualData> kopie = new LinkedList<KopiaProxyVirtualData>();

    public ProxyVirtualData(int size) {
        this.data = null;
        this.size = size;
    }

    public void odlaczKopie() {
        for (KopiaProxyVirtualData kopia : kopie) {
            kopia.kopiuj();
        }
        kopie.clear();
    }

    public Data kopia() {
        KopiaProxyVirtualData kopia = new KopiaProxyVirtualData(this);
        kopie.addLast(kopia);
        return kopia;
    }

    @Override
    public int get(int idx) {
        return this.data == null ? 0 : this.data.get(idx);
    }

    @Override
    public void set(int idx, int value) {
        if (!kopie.isEmpty()) {
            odlaczKopie();
        }
        if (data == null) {
            System.out.println("Bylo proxy, stworzenie obiektu o rozmiarze: " + size);
            this.data = new RealData(size);
        }
        this.data.set(idx, value);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.data == null;
    }
}
