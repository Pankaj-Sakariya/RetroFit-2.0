package model.save_user_contacts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Pankaj Sakariya on 16/07/2016.
 */


public class SaveUserContactsRequestData {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("Data")
    @Expose
    private List<Data> data = new ArrayList<Data>();

    public SaveUserContactsRequestData(String key, String token, List<Data> data) {
        this.key = key;
        this.token = token;
        this.data = data;
    }


    /**
     *
     * @return
     * The key
     */
    public String getKey() {
        return key;
    }

    /**
     *
     * @param key
     * The key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Data> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The Data
     */
    public void setData(List<Data> data) {
        this.data = data;
    }

}


