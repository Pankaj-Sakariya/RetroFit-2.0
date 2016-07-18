package model.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//
public class Data {

    @SerializedName("UserID")
    @Expose
    private Integer userID;
    @SerializedName("Token")
    @Expose
    private String token;
    @SerializedName("DeviceID")
    @Expose
    private String deviceID;
    @SerializedName("MacAddress")
    @Expose
    private String macAddress;
    @SerializedName("IsNewUser")
    @Expose
    private Boolean isNewUser;

    /**
     *
     * @return
     * The userID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     * The UserID
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
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
     * The Token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * @return
     * The deviceID
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     *
     * @param deviceID
     * The DeviceID
     */
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    /**
     *
     * @return
     * The macAddress
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     *
     * @param macAddress
     * The MacAddress
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     *
     * @return
     * The isNewUser
     */
    public Boolean getIsNewUser() {
        return isNewUser;
    }

    /**
     *
     * @param isNewUser
     * The IsNewUser
     */
    public void setIsNewUser(Boolean isNewUser) {
        this.isNewUser = isNewUser;
    }

}
