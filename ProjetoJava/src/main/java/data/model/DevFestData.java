package data.model;

import data.DataInterface;

public class DevFestData implements DataInterface<DevFestData>, BaseModel {

	private Long id;

	@Override
	public DevFestData loadModel() {
		return null;
	}

	@Override
	public Long getId() {
		return id;
	}
}
