package jdbc.table.model;

public class UserRoutes {
	private int IdRecord;
	private String UserId;
	private String RouteName;
	private String Route;
	private Double Distance;
	
	public UserRoutes(int id, String userId, String routeName, String route, Double distance) {
		this.IdRecord = id;
		this.UserId = userId;
		this.RouteName = routeName;
		this.Route = route;
		this.Distance = distance;
	}
	
	public int getIdRecord() {
		return IdRecord;
	}
	
	public String getUserId() {
		return UserId;
	}
	
	public String getRouteName() {
		return RouteName;
	}
	
	public String getRoute() {
		return Route;
	}
	
	public Double getDistance() {
		return Distance;
	}
	
	@Override
	public String toString() {
		return String.format("UserRoutes ['IdRecord' = %s,"
				+ " 'UserId' = %s, "
				+ "'RouteName' = %s, "
				+ "'Route = ' %s, "
				+ "'Distance' = %s]", IdRecord, UserId, RouteName, Route, Distance);
	}
}
