package com.ajp.jtableRowFreezing.application.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CustomModel extends AbstractTableModel {
	List<String> columnNames = new ArrayList<String>();
	List<List<String>> rowData = new ArrayList<List<String>>();
	
	public CustomModel() {
		columnNames.add("fixed 1");
		columnNames.add("fixed 2");
		columnNames.add("A");
		columnNames.add("B");
		columnNames.add("C");
		columnNames.add("D");
		columnNames.add("E");
		columnNames.add("F");
		
		for (int i = 0; i < 20; i++) {
			List<String> item = new ArrayList<String>();
			
			for (int j = 0; j < columnNames.size(); j++) {
				item.add(columnNames.get(j) + " " + i);
			}
			
			rowData.add(item);
		}
	}
	
	@Override
	public int getRowCount() {
		return rowData.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}
	
	@Override
	public String getColumnName(int col) {
        return columnNames.get(col);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return rowData.get(rowIndex).get(columnIndex);
	}

}
