package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("constructor call: url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //service start call method

    public void connect() {
        System.out.println("connect:  " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + "message = " + message);
    }

    //service terminated call method

    public void disconnect() {
        System.out.println("NetworkClient.disconnect");
        System.out.println("close: " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("initialized connect message");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
