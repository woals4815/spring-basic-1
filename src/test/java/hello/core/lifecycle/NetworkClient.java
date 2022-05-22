package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

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


    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("initialized connect message");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
