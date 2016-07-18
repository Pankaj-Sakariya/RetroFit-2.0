package technopreneurs.retrofitdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import API.gitapi;

import model.register.Data;
import model.register.registermodel;
import model.register.registerrequestdata;
import model.save_user_contacts.SaveUserContactsModel;
import model.save_user_contacts.SaveUserContactsRequestData;
import model.save_user_contacts.UserContactDetailList;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import retrofit2.Retrofit;
import model.register.registermodel.*;

import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends ActionBarActivity {

    Button click;
    TextView tv;
    EditText edit_user;
    ProgressBar pbar;
    String API = "https://api.github.com";                         //BASE URL

    String NEWAPI = "http://j2ml.com.199-79-62-231.plesk-web23.webhostbox.net";
    String key = "ASDdasfdsASDdsf";
    String token = "MERrCwqvu0y_z6GviKIbmKOci1P4-QMIKvGebPpOcyA1";

    private ArrayList<SaveUserContactsRequestData> arrayListsaveUserContactsRequestData  = new ArrayList<>();
    private ArrayList<SaveUserContactsRequestData> arrayListsaveUserContactsRequestDataUniqueList = new ArrayList<>();
    private HashMap<String,SaveUserContactsRequestData> hashmap_contactList = new HashMap<>();

    private ArrayList<model.save_user_contacts.Data> arrayListData = new ArrayList<>();
    gitapi git;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.tv);
        edit_user = (EditText) findViewById(R.id.edit);
        pbar = (ProgressBar) findViewById(R.id.pb);
        pbar.setVisibility(View.INVISIBLE);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = null;
                try {
                    user = URLEncoder.encode(edit_user.getText().toString(),"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                pbar.setVisibility(View.VISIBLE);

//                //Retrofit section start from here...
//                RestAdapter restAdapter = new RestAdapter.Builder()
//                        .setEndpoint(API).build();                                        //create an adapter for retrofit with base url
//
//                gitapi git = restAdapter.create(gitapi.class);                            //creating a service for adapter with our GET class
//
//                //Now ,we need to call for response
//                //Retrofit using gson for JSON-POJO conversion
//
//                git.getFeed(user,new Callback<gitmodel>() {
//                    @Override
//                    public void success(gitmodel gitmodel, Response response) {
//                        //we get json object from github server to our POJO or model class
//
//                        tv.setText("Github Name :"+gitmodel.getName()+"\nWebsite :"+gitmodel.getBlog()+"\nCompany Name :"+gitmodel.getCompany()+"\nAvatar Name :"+gitmodel.getAvatarUrl()+"\nID Name :"+gitmodel.getId()+"\nLogin Name :"+gitmodel.getLogin());
//
//                        pbar.setVisibility(View.INVISIBLE);                               //disable progressbar
//                    }
//
//                    @Override
//                    public void failure(RetrofitError error) {
//                        tv.setText(error.getMessage());
//                        pbar.setVisibility(View.INVISIBLE);                               //disable progressbar
//                    }
//                });


            }
        });

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NEWAPI)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        git = retrofit.create(gitapi.class);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("key","ASDdasfdsASDdsf");
            JSONObject data = new JSONObject();
            data.put("DeviceID","abcdefghi");
            data.put("MacAddress","54:as:27:85:45:daq");
            jsonObject.put("data",data);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Data data = new Data();
        data.setMacAddress("54:as:27:85:45:daq");
        data.setDeviceID("abcdefghi");
        registerrequestdata rr = new registerrequestdata(data);

        rr.setKey("ASDdasfdsASDdsf");
        rr.setToken("");


        //rr.getData1().setDevideID("abcdefghi");
     //   rr.getData1().setMacAddress();

        // rr.data1.setDevideID("abcdefghi");

        //rr.getData1().setDevideID("abcdefghi");
        //rr.data1.setMacAddress("54:as:27:85:45:daq");
        //rr.getData1().setMacAddress("54:as:27:85:45:daq");111111

        System.out.println("json"+jsonObject);


       // RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),(new JSONObject((Map) jsonObject)).toString());

        Call<registermodel> call = git.registeruser(rr);

        call.enqueue(new Callback<registermodel>() {
            @Override
            public void onResponse(Call<registermodel> registermodel, Response<registermodel> response) {

                int code = response.code();
                Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                try {
                    tv.setText("Data is =" + "\n respo" + response.headers()+response.message());
                    registermodel reg = response.body();

                    Log.d("ResponseMessage", "onResponse: "+reg.getMessage());
                    Log.d("ResponseData", "onResponse: "+reg.getData());
                    Log.d("ResponseCode", "onResponse: "+reg.getCode());
                    Log.d("ResponseErrors", "onResponse: "+reg.getErrors());
                    Log.d("ResponseSuccess", "onResponse: "+reg.getIsSuccess());
                    //{"\data":{"\MacAddress":"54:as:27:85:45:daq","DeviceID":"abcdefghi"},"key":"ASDdasfdsASDdsf"}

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<registermodel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                tv.setText(t.toString());
            }
        });


        preparedata1();




//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(NEWAPI).build();                                        //create an adapter for retrofit with base url
//
//        restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
//        gitapi git = restAdapter.create(gitapi.class);
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("key","ASDdasfdsASDdsf");
//            JSONObject data = new JSONObject();
//            data.put("DeviceID","abcdefghi");
//            data.put("MacAddress","54:as:27:85:45:daq");
//            jsonObject.put("data",data);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        System.out.println("json"+jsonObject);
//        git.registeruser(jsonObject, new Callback<registermodel>() {
//            @Override
//            public void success(registermodel registermodel, Response response) {
//                Toast.makeText(getApplicationContext(),response.getBody().toString(),Toast.LENGTH_LONG).show();
////                tv.setText("Data is ="+(CharSequence) registermodel.getData());
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
//                tv.setText(error.getMessage());
//            }
//        });
    }
    public void preparedata1(){

        SaveUserContactsRequestData saveUserContactsRequestData = null;

        model.save_user_contacts.Data data;
        HashMap<String,String> unique = new HashMap<String,String>();
        ContentResolver cr = this.getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        String phone = null,phonetype=null;

        String emailContact = null;
        String emailType = null;
        String company_name= null;
        String image_uri = "";
        Bitmap bitmap = null;
        String id = null;
        String name = null;
        String orgName = null;
        String title = null;
        String note = null;

        String poBox = null;
        String street = null;
        String city = null;
        String state = null;
        String postalCode = null;
        String country = null;
        String type = null;


        int i=0;
        System.out.println("......Contact Details.....111");
        if (cur.getCount() > 0) {
            while (cur.moveToNext() && i<15) {
                id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                //String  id="6801";
                name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                image_uri = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
//                company_name = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.DATA));
                ArrayList<UserContactDetailList> arrayListUserContactDetailList = new ArrayList<>();
                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    System.out.println("......Contact Details.....2222");
                    System.out.println("prepare name : " + name + ", ID : " + id);

//                   /* Find Phone Number and Phone Type ; Type 2 = Mobile*/
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);

                    if(pCur.getCount()>0) {
                        while (pCur.moveToNext()) {

                            if (pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)) != "" || pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)) != null) {
                                phone = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                phonetype = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                                if (!unique.containsKey(phone)) {
                                    //   uniqe.put(phone,name);
                                    String numbertype=null;
                                    if(phonetype.equalsIgnoreCase("1"))
                                    {
                                        numbertype ="Home" ;
                                    }
                                    if(phonetype.equalsIgnoreCase("2"))
                                    {
                                        numbertype ="Mobile" ;
                                    }
                                    if(phonetype.equalsIgnoreCase("3"))
                                    {
                                        numbertype ="Work" ;
                                    }
                                    UserContactDetailList userContactDetailList = new UserContactDetailList("","","8",id,"Mobile",numbertype,phone,"",true);

                                    arrayListUserContactDetailList.add(userContactDetailList);

                                    System.out.println("prepare phone :" + phone);
                                    System.out.println("prepare phone Type :" + phonetype);

                                }

                                System.out.println("......Contact Details.....3333");
                            } else {
                                phone = "";
                                phonetype = "";
                            }
                        }
                    }
                    else
                    {
                        phone = "";
                        phonetype = "";
                    }
                    pCur.close();

                    /* Find EmailContact and Email TYpe */
                    Cursor emailCur = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?", new String[]{id}, null);
                    if(emailCur.getCount()>0) {
                        while (emailCur.moveToNext()) {
                            if (emailCur.getString(emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA)) != "" || emailCur.getString(emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA)) != null) {
                                emailContact = emailCur.getString(emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                                emailType = emailCur.getString(emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.TYPE));
                                System.out.println("......Contact Details.....44444");
                                System.out.println("prepare Email " + emailContact + " Email Type : " + emailType);
                            } else {
                                emailContact = "";
                                emailType = "";
                            }
                        }
                    }
                    else
                    {
                        emailContact = "";
                        emailType = "";
                    }
                    emailCur.close();
                }

                /* Find Image for contact list*/
                if (image_uri != null) {
                    System.out.println(Uri.parse(image_uri));
                    try {

                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse(image_uri));


                        System.out.println( "prepare Image in Bitmap:" + bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                /* Find Organization Name and Title */
                String orgWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
                String[] orgWhereParams = new String[]{id,
                        ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE};
                Cursor orgCur = cr.query(ContactsContract.Data.CONTENT_URI,
                        null, orgWhere, orgWhereParams, null);
                if(orgCur.getCount()>0) {
                    if (orgCur.moveToFirst()) {
                        if (orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.DATA)) != "" || orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.DATA)) != null) {
                            orgName = orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.DATA));
                        } else {
                            orgName = "";
                        }

                        if (orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.TITLE)) != "" || orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.TITLE)) != null) {
                            title = orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.TITLE));
                        } else {
                            title = "";
                        }

                        System.out.println("prepare  Comapny name:" + orgName);
                        System.out.println("prepare Designation :" + title);

                    }
                }
                else
                {
                    orgName = "";
                    title = "";

                }
                orgCur.close();

                /* Find Note */
                String[] noteWhereParams = new String[]{id,
                        ContactsContract.CommonDataKinds.Note.CONTENT_ITEM_TYPE};
                Cursor noteCur = cr.query(ContactsContract.Data.CONTENT_URI, null, orgWhere, noteWhereParams, null);
                if(noteCur.getCount()>0) {
                    if (noteCur.moveToFirst()) {
                        if (noteCur.getString(noteCur.getColumnIndex(ContactsContract.CommonDataKinds.Note.NOTE)) != "" || noteCur.getString(noteCur.getColumnIndex(ContactsContract.CommonDataKinds.Note.NOTE)) != null) {
                            note = noteCur.getString(noteCur.getColumnIndex(ContactsContract.CommonDataKinds.Note.NOTE));
                        } else {
                            note = "";
                        }

                        System.out.println("prepare Note :" + note);
                    }
                }
                else
                {
                    note = "";
                }
                noteCur.close();

                /* Find Extra Type */
                String[] addrWhereParams = new String[]{id,
                        ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE};
                Cursor addrCur = cr.query(ContactsContract.Data.CONTENT_URI,
                        null, orgWhere, addrWhereParams, null);
                if(addrCur.getCount()>0) {
                    while (addrCur.moveToNext()) {

                        if (addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POBOX)) != "" || addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POBOX)) != null) {
                            poBox = addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POBOX));
                        } else {
                            poBox = "";
                        }

                        if (addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.STREET)) != "" || addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.STREET)) != null) {
                            street = addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.STREET));
                        } else {
                            street = "";
                        }

                        if (addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.CITY)) != "" || addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.CITY)) != null) {
                            city = addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.CITY));
                        } else {
                            city = "";
                        }

                        if (addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.REGION)) != "" || addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.REGION)) != null) {
                            state = addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.REGION));
                        } else {
                            state = "";
                        }

                        if (addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE)) != "" || addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE)) != null) {
                            postalCode = addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE));
                        } else {
                            postalCode = "";
                        }

                        if (addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY)) != "" || addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY)) != null) {
                            country = addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY));
                        } else {
                            country = "";
                        }

                        if (addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.TYPE)) != "" || addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.TYPE)) != null) {
                            type = addrCur.getString(addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.TYPE));
                        } else {
                            type = "";
                        }


                        System.out.println("prepare POBOX :" + poBox);
                        System.out.println("prepare Street:" + street);
                        System.out.println("prepare City :" + city);
                        System.out.println("prepare State :" + state);
                        System.out.println("prepare PostalCode :" + postalCode);
                        System.out.println("prepare Country :" + country);
                        System.out.println("prepare TYpe :" + type);


                    }
                }
                else
                {
                    poBox = "";
                    street = "";
                    city = "";
                    state = "";
                    postalCode = "";
                    country = "";
                    type = "";
                }
                addrCur.close();

                //UserContactDetailList userContactDetailList = new UserContactDetailList("","","8",id,"Mobile","mobile",phone,"",true);
                //ArrayList<UserContactDetailList> arrayListUserContactDetailList = new ArrayList<>();
                //arrayListUserContactDetailList.add(userContactDetailList);
                data = new model.save_user_contacts.Data("", //user contact detail
                        arrayListUserContactDetailList, // user contact detail list
                        "", // contact id generate in DB
                        id, // contact unique id
                        "8", // user ID
                        name, // name
                        "",  // middle name
                        "", // last name
                        emailContact, // email
                        orgName,  // org name
                        title,   // job title
                        street,  // address
                        city,   // city
                        state,  //state
                        country,    // country
                        "",     // birthdate
                        note,   //notes
                        true,   // isActive
                        false,  // isFavourite
                        false,  //isDeleted
                        false, // isBlocked
                        "",  // Blocked TIme
                        "",  // Photo URL
                        "");  // CreatedDate

                arrayListData.add(data);

                saveUserContactsRequestData = new SaveUserContactsRequestData(key,token,arrayListData);
                arrayListsaveUserContactsRequestData.add(saveUserContactsRequestData);


                if(!hashmap_contactList.containsKey(phone)){
                    hashmap_contactList.put(phone,saveUserContactsRequestData);
                }

//                arrayListsaveUserContactsRequestData.add(saveUserContactsRequestData);



                try {
                    System.out.println("!!!!"+i
                            + "  -Phone  " + phone
                            + "  -PhoneType=  " + phonetype
                            + "  -emailContact  " + emailContact
                            + "  -emailType  " + emailType
                            + "  -company_name=  " + company_name
                            + "  -imageURi=  " + image_uri
                            + "  -bitmap=  " + bitmap
                            + "  -id=  " + id
                            + "  -name=  " + name
                            + "  -orgName=  " + orgName
                            + "  -title=  " + title
                            + "  -note=  " + note
                            + "  -pobox=  " + poBox
                            + "  -street=  " + street
                            + "  -city=  " + city
                            + "  -state=  " + state
                            + "  -postalcode=  " + postalCode
                            + "  -country=  " + country
                            + "  -type=  " + type
                    );
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            i++;



            }



            Set s= hashmap_contactList.keySet();
            Iterator i1 = s.iterator();
            int j=0;
            while (i1.hasNext()){
                arrayListsaveUserContactsRequestDataUniqueList.add(hashmap_contactList.get(i1.next()));
                System.out.println("zzzz!!!!"+arrayListsaveUserContactsRequestDataUniqueList.get(j).getKey());
                j++;
            }

           // Collections.sort(uniqueList, Item_Contact_List.contactnameCompare);
        }

        Call<SaveUserContactsModel> SaveUserContacts = git.SaveUserContacts(saveUserContactsRequestData);
        SaveUserContacts.enqueue(new Callback<SaveUserContactsModel>() {
            @Override
            public void onResponse(Call<SaveUserContactsModel> call, Response<SaveUserContactsModel> response) {

                int code = response.code();
                Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                try {
                    tv.setText("Data is =" + "\n respo" + response.headers()+response.message());
                    SaveUserContactsModel reg = response.body();

                    Log.d("ResponseMessage", "onResponse: "+reg.getMessage());
                    Log.d("ResponseData", "onResponse: "+reg.getData());
                    Log.d("ResponseCode", "onResponse: "+reg.getCode());
                    Log.d("ResponseErrors", "onResponse: "+reg.getErrors());
                    Log.d("ResponseSuccess", "onResponse: "+reg.getIsSuccess());
                    //{"\data":{"\MacAddress":"54:as:27:85:45:daq","DeviceID":"abcdefghi"},"key":"ASDdasfdsASDdsf"}

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<SaveUserContactsModel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                tv.setText(t.toString());
            }
        });


    }




}