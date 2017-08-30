package com.ajp.jtableRowFreezing.application.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ColTableModel extends AbstractTableModel {
	List<String> columnNames = new ArrayList<String>();
	List<List<String>> rowData = new ArrayList<List<String>>();
	
	public ColTableModel(int rowSize) {
		columnNames.add("A");
		columnNames.add("B");
		columnNames.add("C");
		columnNames.add("D");
		
		for (int i = 0; i < rowSize; i++) {
			List<String> item = new ArrayList<String>();
			
			item.add("A" + i);
			item.add("B" + i);
			item.add("C" + i);
			item.add("D" + i);
			
			rowData.add(item);
		}
	}
	
	@Override
	public int getRowCount() {
		return rowData.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return rowData.get(rowIndex).get(columnIndex);
	}

}
