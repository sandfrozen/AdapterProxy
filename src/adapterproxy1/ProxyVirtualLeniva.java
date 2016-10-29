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
public class ProxyVirtualLeniva extends AbstractTableModel {

    private int[] tab = null;
    private int size;

    public ProxyVirtualLeniva(int size) {
        this.tab = null;
        this.size = size;
    }
    
    public void setData(int size){
        this.tab = null;
        this.size = size;
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return size;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //dla kolumny == 0 zwraca numer indeksu
        //dla kolumny == 1 zwraca wartosc jaka jest w tabeli, a jeśli nie ma tabeli to zwraca 0
        return columnIndex==0 ? rowIndex : ( tab==null ? 0 : tab[rowIndex] );
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if( tab == null ){
            tab = new int[size];
        }
        System.out.println("JAKA JEST LICZBA ?: " + Integer.parseInt(aValue.toString()) );
        tab[rowIndex] = Integer.parseInt(aValue.toString());
        fireTableStructureChanged();
        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //return columnIndex!=0 ? true : false;
        //dla kolumny == 0 zwraca "false" - nie mozna edytowac
        //dla kolumny == 1 zwraca "true"  - mozna edytowac
        return columnIndex != 0;
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
        return column == 0 ? "index" : "wartość";
    }

}
