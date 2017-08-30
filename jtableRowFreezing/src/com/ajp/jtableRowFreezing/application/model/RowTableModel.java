package com.ajp.jtableRowFreezing.application.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

@SuppressWarnings({ "serial", "rawtypes" })
public class RowTableModel extends AbstractListModel {
	List<String> rows = new ArrayList<String>();
	
	public RowTableModel() {
		rows.add("A");
		rows.add("B");
		rows.add("C");
		rows.add("D");
		rows.add("E");
		rows.add("F");
		rows.add("G");
	}
	
	@Override
    public int getSize() { 
    	return rows.size(); 
    }
    
    @Override
    public Object getElementAt(int index) {
    	return rows.get(index);
    }
}
