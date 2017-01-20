package javaSwingTable.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1700855315401951931L;
	private final int columnsCount = 2;
	private ArrayList<Persons> personsList;
	
	public TableModel() {
		personsList = new ArrayList<Persons>();
		personsList.add(new Persons("Vital", "123456"));
		personsList.add(new Persons("Sanya", "36545"));
		personsList.add(new Persons("Alex", "228229"));
	}
	
	@Override
	public int getColumnCount() { return columnsCount; }
	
	@Override
	public int getRowCount() { return personsList.size(); }
	
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
			case 0: return "FIO";
			case 1: return "Phone";
		}
		return "";
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Persons selectedRow = personsList.get(rowIndex);
		switch (columnIndex) {
	        case 0:
	            return selectedRow.getFIO();
	        case 1:
	            return selectedRow.getPhone();
        }
        return "";
	}

}
