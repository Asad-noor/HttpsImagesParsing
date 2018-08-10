package bd.com.cmed.apiresponsedisplay.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse {

    @SerializedName("product")
    private String product;

    @SerializedName("version")
    private float version;

    @SerializedName("users")
    private List<users> usersList;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public List<users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<users> usersList) {
        this.usersList = usersList;
    }
}
