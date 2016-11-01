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
public class KopiaProxyVirtualData implements Data {

    private ProxyVirtualData oryginal;
    private ProxyVirtualData kopia;

    public KopiaProxyVirtualData(ProxyVirtualData oryginal) {
        this.oryginal = oryginal;
    }

    public void kopiuj() {
        if (kopia != null) {
            return;
        }
        kopia = new ProxyVirtualData(oryginal.size());
        for (int i = 0; i < oryginal.size(); i++) {
            kopia.set(i, oryginal.get(i));
        }
        oryginal = null;
    }

    @Override
    public int get(int idx) {
        if (kopia == null) {
            return oryginal.get(idx);
        } else {
            return kopia.get(idx);
        }
    }

    @Override
    public void set(int idx, int value) {
        if (kopia == null) {
            oryginal.odlaczKopie();
        }
        kopia.set(idx, value);
    }

    @Override
    public int size() {
        if (kopia == null) {
            return oryginal.size();
        }
        return kopia.size();
    }

    @Override
    public boolean isEmpty() {
        return kopia == null;
    }

}
