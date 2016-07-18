package API;

import java.util.ArrayList;

import model.gitmodel;
import model.register.registermodel;
import model.register.registerrequestdata;
import model.save_user_contacts.SaveUserContactsModel;
import model.save_user_contacts.SaveUserContactsRequestData;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by Pankaj Sakariya on 14/07/2016.
 */
public interface gitapi {

    @GET("/users/{user}")      //here is the other url part.best way is to start using

    void getFeed(@Path("user") String user, Callback<gitmodel> response);     //string user is for passing values from edittext for eg: user=basil2style,google
    //response is the response from the server which is now in the POJO

//    @Headers({
//            "Content-type: application/json"
//    })
    @POST("/user/registeruser")
    Call<registermodel> registeruser(@Body registerrequestdata req);

    @POST("/user/SaveUserContacts")
    Call<SaveUserContactsModel> SaveUserContacts(@Body SaveUserContactsRequestData req);
}