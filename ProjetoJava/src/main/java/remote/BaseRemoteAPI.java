package remote;

import java.net.URL;

public interface BaseRemoteAPI {

	Object callRemoteApi();

	void setURL(URL url);

}
