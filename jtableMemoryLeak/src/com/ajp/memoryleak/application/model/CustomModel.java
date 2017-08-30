package com.ajp.memoryleak.application.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class CustomModel extends AbstractTableModel{
	private final int columnsCount = 2;
	private final int counter = 100;
	private List<SomeDate> someDataList;
	
	public CustomModel() {
		someDataList = new ArrayList<SomeDate>();
	}
	
	public void addOneHundredRecords() {
		int curentRowSize = someDataList.size() + counter;
		
		for (int i = someDataList.size(); i < curentRowSize; ++i) {
			SomeDate tempSomeData = new SomeDate();
			tempSomeData.setFieldOne("one " + i);
			tempSomeData.setFieldOne("two " + i);
			
			someDataList.add(tempSomeData);
		}
		
		fireTableDataChanged();
	}
	
	public void removeOneHundredRecords() {
		int curentRowSize = someDataList.size() - counter;
		
		if (curentRowSize >= 0) {
			for (int i = someDataList.size(); i > curentRowSize; --i) {
				someDataList.remove(i - 1);
				fireTableRowsDeleted(i, i);
			}
			
			fireTableDataChanged();
		}
	}
	
	@Override
	public int getColumnCount() {
		return columnsCount;
	}
	
	@Override
	public int getRowCount() {
		return someDataList.size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
			case 0: return "First column";
			case 1: return "Second column";
		}
		
		return "";
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		SomeDate selectedRow = someDataList.get(rowIndex);
		
		switch (columnIndex) {
	        case 0:
	            return selectedRow.getFieldOne();
	        case 1:
	            return selectedRow.getFieldTwo();
        }
		
        return "";
	}
}
