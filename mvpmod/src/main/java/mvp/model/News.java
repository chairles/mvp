package mvp.model;



import com.google.gson.annotations.SerializedName;


/**
 * Created by Karol Maciejewski_ on 16.06.2016.
 */

public class News  {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private String image;

    @SerializedName("publishingDate")
    private String publishingDate;

    @SerializedName("id")
    private String id;

    @SerializedName("breakingNewsCategoryId")
    private int breakingNewsCategoryId;


    @SerializedName("detailsImage")
    private String detailsImage;

    @SerializedName("socialCastUrl")
    private String socialCastUrl;


    public String getSocialCastUrl() {
        return socialCastUrl;
    }

    public void setSocialCastUrl(String socialCastUrl) {
        this.socialCastUrl = socialCastUrl;
    }


    public String getDetailsImage() {
        return detailsImage;
    }

    public void setDetailsImage(String detailsImage) {
        this.detailsImage = detailsImage;
    }


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

    public String getImage() {
        return image;
    }


 public void setImage(String image) {
        this.image = image;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBreakingNewsCategoryId() {
        return breakingNewsCategoryId;
    }

    public void setBreakingNewsCategoryId(int breakingNewsCategoryId) {
        this.breakingNewsCategoryId = breakingNewsCategoryId;
    }


}
