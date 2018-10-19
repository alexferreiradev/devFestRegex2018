package data;

import data.model.DevFestData;
import helper.StreamHelper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DevFestLoader implements DataInterface<DevFestData> {

	@Override
	public DevFestData loadModel() throws DataException {
		DevFestData devFestData = new DevFestData();

		String contentString;
		try {
			InputStream fileStream = getClass().getResourceAsStream("/data/pdf_content.txt");
			contentString = StreamHelper.parseStream(fileStream);
		} catch (IOException e) {
			throw new DataException("Erro ao fazer parse de stream", e);
		}
		devFestData.setFileText(contentString);

		return devFestData;
	}

	@Override
	public void setSourceFile(String file) {

	}

	@Override
	public void setSourceFile(File file) {

	}

}
