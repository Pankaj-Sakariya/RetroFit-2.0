package model.save_user_contacts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserContactDetailList {

    @SerializedName("ContactDetailID")
    @Expose
    private String contactDetailID;
    @SerializedName("ContactID")
    @Expose
    private String contactID;
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("ContactUniqueID")
    @Expose
    private String contactUniqueID;
    @SerializedName("KeyType")
    @Expose
    private String keyType;
    @SerializedName("KeyName")
    @Expose
    private String keyName;
    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("OrderNo")
    @Expose
    private String orderNo;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;

    public UserContactDetailList(String contactDetailID, String contactID, String userID, String contactUniqueID, String keyType, String keyName, String value, String orderNo, Boolean isActive) {
        this.contactDetailID = contactDetailID;
        this.contactID = contactID;
        this.userID = userID;
        this.contactUniqueID = contactUniqueID;
        this.keyType = keyType;
        this.keyName = keyName;
        this.value = value;
        this.orderNo = orderNo;
        this.isActive = isActive;
    }

    /**
     *
     * @return
     * The contactDetailID
     */
    public String getContactDetailID() {
        return contactDetailID;
    }

    /**
     *
     * @param contactDetailID
     * The ContactDetailID
     */
    public void setContactDetailID(String contactDetailID) {
        this.contactDetailID = contactDetailID;
    }

    /**
     *
     * @return
     * The contactID
     */
    public String getContactID() {
        return contactID;
    }

    /**
     *
     * @param contactID
     * The ContactID
     */
    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    /**
     *
     * @return
     * The userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     * The UserID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     *
     * @return
     * The contactUniqueID
     */
    public String getContactUniqueID() {
        return contactUniqueID;
    }

    /**
     *
     * @param contactUniqueID
     * The ContactUniqueID
     */
    public void setContactUniqueID(String contactUniqueID) {
        this.contactUniqueID = contactUniqueID;
    }

    /**
     *
     * @return
     * The keyType
     */
    public String getKeyType() {
        return keyType;
    }

    /**
     *
     * @param keyType
     * The KeyType
     */
    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    /**
     *
     * @return
     * The keyName
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     *
     * @param keyName
     * The KeyName
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     *
     * @return
     * The value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The Value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return
     * The orderNo
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     *
     * @param orderNo
     * The OrderNo
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     *
     * @return
     * The isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     *
     * @param isActive
     * The IsActive
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
