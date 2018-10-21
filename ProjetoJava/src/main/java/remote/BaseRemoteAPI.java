package remote;

import data.model.DevFestData;

import java.net.URL;

public interface BaseRemoteAPI {

	Object callRemoteApi();

	void setURL(URL url);

	void setData(DevFestData data);

}
