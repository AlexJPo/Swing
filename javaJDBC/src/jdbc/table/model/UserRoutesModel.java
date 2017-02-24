package jdbc.table.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserRoutesModel extends AbstractTableModel {
	private static final int ID_RECORD_COL = 1;
	private static final int USER_ID_COL = 2;
	private static final int ROUTE_NAME_COL = 3;
	private static final int ROUTE_COL = 4;
	private static final int DISTANCE_COL = 5;
	
	private String[] columnNames = { "IdRecord", "UserId", "RouteName", "Route", "Distance" };
	private List<UserRoutes> userRoutes;
	
	public UserRoutesModel(List<UserRoutes> theUserRoutes) {
		userRoutes = theUserRoutes;
	}
	
	@Override
	public int getRowCount() {
		return userRoutes.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UserRoutes selectedUser = userRoutes.get(rowIndex);
		
		switch (columnIndex) {
			case ID_RECORD_COL: return selectedUser.getIdRecord(); 			
			case USER_ID_COL: return selectedUser.getUserId();				
			case ROUTE_NAME_COL: return selectedUser.getRouteName();				
			case ROUTE_COL: return selectedUser.getRoute();				
			case DISTANCE_COL: return selectedUser.getDistance();
			default: return selectedUser.getUserId();				
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
}
