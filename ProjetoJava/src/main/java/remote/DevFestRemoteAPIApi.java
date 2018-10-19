package remote;

import java.net.URL;

public class DevFestRemoteAPIApi implements BaseRemoteAPI {

	private URL url;

	@Override
	public Object callRemoteApi() {
		return "null";
	}

	@Override
	public void setURL(URL url) {
		this.url = url;
	}
}
