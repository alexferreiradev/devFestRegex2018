package remote;

import com.sun.xml.internal.ws.api.pipe.ContentType;
import data.model.DevFestData;
import helper.StreamHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DevFestRemoteAPIApi implements BaseRemoteAPI {

	private static final int CONNECT_TIMEOUT = 10000;
	private URL url;
	private DevFestData data;

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
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Content-Type", "plan/text");
			urlConnection.setRequestProperty("Content-Length", String.valueOf(data.getFileText().getBytes().length));
			urlConnection.connect();
			OutputStream outputStream = urlConnection.getOutputStream();
			String fileText = data.getFileText();
			outputStream.write(fileText.getBytes());
			outputStream.flush();
			outputStream.close();
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

	@Override
	public void setData(DevFestData data) {
		this.data = data;
	}
}
