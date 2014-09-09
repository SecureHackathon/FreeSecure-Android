package freesecure.framework.models;

public class Camera extends BaseModel {

	
	private String name;
	private String id;
	private boolean active;
	
	public Camera(String id, String name, boolean active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getActive() {
		return active;
	}
}
