package model.save_user_contacts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

   @SerializedName("UserContactDetail")
   @Expose
   private Object userContactDetail;
   @SerializedName("UserContactDetailList")
   @Expose
   private List<UserContactDetailList> userContactDetailList = new ArrayList<UserContactDetailList>();
   @SerializedName("ContactID")
   @Expose
   private String contactID;
   @SerializedName("ContactUniqueID")
   @Expose
   private String contactUniqueID;
   @SerializedName("UserID")
   @Expose
   private String userID;
   @SerializedName("FirstName")
   @Expose
   private String firstName;
   @SerializedName("MiddleName")
   @Expose
   private Object middleName;
   @SerializedName("LastName")
   @Expose
   private String lastName;
   @SerializedName("Email")
   @Expose
   private String email;
   @SerializedName("Company")
   @Expose
   private Object company;
   @SerializedName("JobTitle")
   @Expose
   private Object jobTitle;
   @SerializedName("Address")
   @Expose
   private Object address;
   @SerializedName("City")
   @Expose
   private Object city;
   @SerializedName("State")
   @Expose
   private Object state;
   @SerializedName("Country")
   @Expose
   private Object country;
   @SerializedName("BirthDate")
   @Expose
   private Object birthDate;
   @SerializedName("Notes")
   @Expose
   private Object notes;
   @SerializedName("IsActive")
   @Expose
   private Boolean isActive;
   @SerializedName("IsFavourite")
   @Expose
   private Boolean isFavourite;
   @SerializedName("IsDeleted")
   @Expose
   private Boolean isDeleted;
   @SerializedName("IsBlocked")
   @Expose
   private Boolean isBlocked;
   @SerializedName("BlockedTime")
   @Expose
   private Object blockedTime;
   @SerializedName("PhotoUrl")
   @Expose
   private Object photoUrl;
   @SerializedName("CreatedDate")
   @Expose
   private String createdDate;
   @SerializedName("ModifiedDate")
   @Expose
   private String modifiedDate;


   public Data(Object userContactDetail, List<UserContactDetailList> userContactDetailList, String contactID, String contactUniqueID, String userID, String firstName, Object middleName, String lastName, String email, Object company, Object jobTitle, Object address, Object city, Object state, Object country, Object birthDate, Object notes, Boolean isActive, Boolean isFavourite, Boolean isDeleted, Boolean isBlocked, Object blockedTime, Object photoUrl, String createdDate) {
      this.userContactDetail = userContactDetail;
      this.userContactDetailList = userContactDetailList;
      this.contactID = contactID;
      this.contactUniqueID = contactUniqueID;
      this.userID = userID;
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.email = email;
      this.company = company;
      this.jobTitle = jobTitle;
      this.address = address;
      this.city = city;
      this.state = state;
      this.country = country;
      this.birthDate = birthDate;
      this.notes = notes;
      this.isActive = isActive;
      this.isFavourite = isFavourite;
      this.isDeleted = isDeleted;
      this.isBlocked = isBlocked;
      this.blockedTime = blockedTime;
      this.photoUrl = photoUrl;
      this.createdDate = createdDate;
    //  this.modifiedDate = modifiedDate;
   }

   /**
    *
    * @return
    * The userContactDetail
    */
   public Object getUserContactDetail() {
       return userContactDetail;
   }

   /**
    *
    * @param userContactDetail
    * The UserContactDetail
    */
   public void setUserContactDetail(Object userContactDetail) {
       this.userContactDetail = userContactDetail;
   }

   /**
    *
    * @return
    * The userContactDetailList
    */
   public List<UserContactDetailList> getUserContactDetailList() {
       return userContactDetailList;
   }

   /**
    *
    * @param userContactDetailList
    * The UserContactDetailList
    */
   public void setUserContactDetailList(List<UserContactDetailList> userContactDetailList) {
       this.userContactDetailList = userContactDetailList;
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
    * The firstName
    */
   public String getFirstName() {
       return firstName;
   }

   /**
    *
    * @param firstName
    * The FirstName
    */
   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }

   /**
    *
    * @return
    * The middleName
    */
   public Object getMiddleName() {
       return middleName;
   }

   /**
    *
    * @param middleName
    * The MiddleName
    */
   public void setMiddleName(Object middleName) {
       this.middleName = middleName;
   }

   /**
    *
    * @return
    * The lastName
    */
   public String getLastName() {
       return lastName;
   }

   /**
    *
    * @param lastName
    * The LastName
    */
   public void setLastName(String lastName) {
       this.lastName = lastName;
   }

   /**
    *
    * @return
    * The email
    */
   public String getEmail() {
       return email;
   }

   /**
    *
    * @param email
    * The Email
    */
   public void setEmail(String email) {
       this.email = email;
   }

   /**
    *
    * @return
    * The company
    */
   public Object getCompany() {
       return company;
   }

   /**
    *
    * @param company
    * The Company
    */
   public void setCompany(Object company) {
       this.company = company;
   }

   /**
    *
    * @return
    * The jobTitle
    */
   public Object getJobTitle() {
       return jobTitle;
   }

   /**
    *
    * @param jobTitle
    * The JobTitle
    */
   public void setJobTitle(Object jobTitle) {
       this.jobTitle = jobTitle;
   }

   /**
    *
    * @return
    * The address
    */
   public Object getAddress() {
       return address;
   }

   /**
    *
    * @param address
    * The Address
    */
   public void setAddress(Object address) {
       this.address = address;
   }

   /**
    *
    * @return
    * The city
    */
   public Object getCity() {
       return city;
   }

   /**
    *
    * @param city
    * The City
    */
   public void setCity(Object city) {
       this.city = city;
   }

   /**
    *
    * @return
    * The state
    */
   public Object getState() {
       return state;
   }

   /**
    *
    * @param state
    * The State
    */
   public void setState(Object state) {
       this.state = state;
   }

   /**
    *
    * @return
    * The country
    */
   public Object getCountry() {
       return country;
   }

   /**
    *
    * @param country
    * The Country
    */
   public void setCountry(Object country) {
       this.country = country;
   }

   /**
    *
    * @return
    * The birthDate
    */
   public Object getBirthDate() {
       return birthDate;
   }

   /**
    *
    * @param birthDate
    * The BirthDate
    */
   public void setBirthDate(Object birthDate) {
       this.birthDate = birthDate;
   }

   /**
    *
    * @return
    * The notes
    */
   public Object getNotes() {
       return notes;
   }

   /**
    *
    * @param notes
    * The Notes
    */
   public void setNotes(Object notes) {
       this.notes = notes;
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

   /**
    *
    * @return
    * The isFavourite
    */
   public Boolean getIsFavourite() {
       return isFavourite;
   }

   /**
    *
    * @param isFavourite
    * The IsFavourite
    */
   public void setIsFavourite(Boolean isFavourite) {
       this.isFavourite = isFavourite;
   }

   /**
    *
    * @return
    * The isDeleted
    */
   public Boolean getIsDeleted() {
       return isDeleted;
   }

   /**
    *
    * @param isDeleted
    * The IsDeleted
    */
   public void setIsDeleted(Boolean isDeleted) {
       this.isDeleted = isDeleted;
   }

   /**
    *
    * @return
    * The isBlocked
    */
   public Boolean getIsBlocked() {
       return isBlocked;
   }

   /**
    *
    * @param isBlocked
    * The IsBlocked
    */
   public void setIsBlocked(Boolean isBlocked) {
       this.isBlocked = isBlocked;
   }

   /**
    *
    * @return
    * The blockedTime
    */
   public Object getBlockedTime() {
       return blockedTime;
   }

   /**
    *
    * @param blockedTime
    * The BlockedTime
    */
   public void setBlockedTime(Object blockedTime) {
       this.blockedTime = blockedTime;
   }

   /**
    *
    * @return
    * The photoUrl
    */
   public Object getPhotoUrl() {
       return photoUrl;
   }

   /**
    *
    * @param photoUrl
    * The PhotoUrl
    */
   public void setPhotoUrl(Object photoUrl) {
       this.photoUrl = photoUrl;
   }

   /**
    *
    * @return
    * The createdDate
    */
   public String getCreatedDate() {
       return createdDate;
   }

   /**
    *
    * @param createdDate
    * The CreatedDate
    */
   public void setCreatedDate(String createdDate) {
       this.createdDate = createdDate;
   }

   /**
    *
    * @return
    * The modifiedDate
    */
   public String getModifiedDate() {
       return modifiedDate;
   }

   /**
    *
    * @param modifiedDate
    * The ModifiedDate
    */
   public void setModifiedDate(String modifiedDate) {
       this.modifiedDate = modifiedDate;
   }

}
