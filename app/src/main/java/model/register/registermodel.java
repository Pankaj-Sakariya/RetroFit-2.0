package model.register;

/**
 * Created by Pankaj Sakariya on 14/07/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class registermodel {

    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("IsSuccess")
    @Expose
    private Boolean isSuccess;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("Errors")
    @Expose
    private Object errors;

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The Code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The isSuccess
     */
    public Boolean getIsSuccess() {
        return isSuccess;
    }

    /**
     *
     * @param isSuccess
     * The IsSuccess
     */
    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The Message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The data
     */
    public Data getData() {
        return data;
    }

    /**
     *
     * @param data
     * The Data
     */
    public void setData(Data data) {
        this.data = data;
    }

  /**
     *
     * @return
     * The errors
     */
    public Object getErrors() {
        return errors;
    }

    /**
     *
     * @param errors
     * The Errors
     */
    public void setErrors(Object errors) {
        this.errors = errors;
    }

}


