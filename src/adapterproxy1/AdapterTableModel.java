/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterproxy1;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author A5US
 */
public class AdapterTableModel extends AbstractTableModel {

    private Data data;

    public AdapterTableModel(int size) {
        data = new RealData(size);
    }
    
    public void setData(Data data){
        this.data = data;
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //dla kolumny == 0 zwraca numer indeksu
        //dla kolumny == 1 zwraca wartosc jaka jest w tabeli :)
        return columnIndex==0 ? rowIndex : data.get(rowIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data.set(rowIndex, Integer.parseInt(aValue.toString()));
        fireTableStructureChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //return columnIndex!=0 ? true : false;
        //dla kolumny == 0 zwraca "false" - nie mozna edytowac
        //dla kolumny == 1 zwraca "true"  - mozna edytowac
        return columnIndex==1;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
        //dla kolumny == 0 zwraca napis "index"
        //dla kolumny == 1 zwraca napis "wartość"
        return column==0 ? "index" : (data.isEmpty() ? "to jest proxy" : "wartość");
        //
    }

    void clean() {
        this.data = new RealData(0);
        fireTableStructureChanged();
    }

}
