package mvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Karol Maciejewski_ on 23.08.2016.
 */
public class Initiative  {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("detailsImage")
    private String detailsImage;

    @SerializedName("image")
    private String image;

    @SerializedName("socialCastUrl")
    private String socialCastUrl;

    @SerializedName("publishingDate")
    private String publishingDate;

    @SerializedName("id")
    private int id;

    @SerializedName("initiativeCategoryId")
    private int initiativeCategoryId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailsImage() {
        return detailsImage;
    }

    public void setDetailsImage(String detailsImage) {
        this.detailsImage = detailsImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSocialCastUrl() {
        return socialCastUrl;
    }

    public void setSocialCastUrl(String socialCastUrl) {
        this.socialCastUrl = socialCastUrl;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInitiativeCategoryId() {
        return initiativeCategoryId;
    }

    public void setInitiativeCategoryId(int initiativeCategoryId) {
        this.initiativeCategoryId = initiativeCategoryId;
    }


}
