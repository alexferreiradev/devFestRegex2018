package remote;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DevFestRemoteAPIApiTest {

	private DevFestRemoteAPIApi remoteApi;

	@Before
	public void setUp() throws Exception {
		remoteApi = new DevFestRemoteAPIApi();
	}

	@Test
	public void callRemoteApi() throws Exception {
		Object response = remoteApi.callRemoteApi();

		Assert.assertEquals("123", response);
	}

}