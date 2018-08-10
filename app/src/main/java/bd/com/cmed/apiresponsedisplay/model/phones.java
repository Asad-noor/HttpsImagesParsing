package bd.com.cmed.apiresponsedisplay.model;

import com.google.gson.annotations.SerializedName;

public class phones {

    @SerializedName("home")
    private String home;

    @SerializedName("mobile")
    private String mobile;

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
