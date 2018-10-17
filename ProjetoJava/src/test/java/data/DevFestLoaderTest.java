package data;

import data.model.DevFestData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DevFestLoaderTest {

	private static final String FILE_PATH = "file path";
	private DataInterface<DevFestData> dataLoader;

	@Before
	public void setUp() throws Exception {
		dataLoader = new DevFestLoader();
		dataLoader.setSourceFile(FILE_PATH);
	}

	@Test
	public void loadModel() throws Exception {
		DevFestData devFestData = dataLoader.loadModel();

		Assert.assertEquals("Conteudo esperado", devFestData.getFileText());
		Assert.assertEquals("Path esperado", devFestData.getFilePath());
	}

}