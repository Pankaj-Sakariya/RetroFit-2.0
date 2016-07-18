package model.register;

/**
 * Created by Pankaj Sakariya on 15/07/2016.
 */
public class registerrequestdata {


    private String key;
    private String token;
    Data data;


    public registerrequestdata(Data data)
    {
        this.data = data;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
