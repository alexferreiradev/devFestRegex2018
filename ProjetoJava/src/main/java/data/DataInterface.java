package data;

import data.model.BaseModel;

public interface DataInterface<ModelType extends BaseModel> {

	ModelType loadModel();

}
