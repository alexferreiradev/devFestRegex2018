package remote;

import helper.StreamHelper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DevFestRemoteAPIApi implements BaseRemoteAPI {

	private static final int CONNECT_TIMEOUT = 10000;
	private URL url;

	@Override
	public Object callRemoteApi() {
		if (url == null) {
			throw new IllegalStateException("Configure uma url antes de realizar a chamada para API");
		}

		HttpURLConnection urlConnection = null;
		InputStream streamResponse = null;
		String stringResponse = null;
		try {
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
			urlConnection.connect();
			streamResponse = (InputStream) urlConnection.getContent();
			stringResponse = StreamHelper.parseStream(streamResponse);
		} catch (IOException e) {
			e.printStackTrace();
			if (urlConnection != null) {
				urlConnection.disconnect();
			}

			if (streamResponse != null) {
				try {
					streamResponse.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return stringResponse;
	}

	@Override
	public void setURL(URL url) {
		this.url = url;
	}
}
