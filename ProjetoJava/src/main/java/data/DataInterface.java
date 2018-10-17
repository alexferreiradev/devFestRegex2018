package data;

import data.model.BaseModel;

import java.io.File;

public interface DataInterface<ModelType extends BaseModel> {

	ModelType loadModel();

	void setSourceFile(String file);

	void setSourceFile(File file);

}
