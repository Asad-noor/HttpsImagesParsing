package bd.com.cmed.apiresponsedisplay;

import android.app.Application;

import bd.com.cmed.apiresponsedisplay.di.component.DaggerNetworkComponent;
import bd.com.cmed.apiresponsedisplay.di.component.NetworkComponent;
import bd.com.cmed.apiresponsedisplay.di.module.RetrofitModule;
import bd.com.cmed.apiresponsedisplay.service.WebService;

public class App extends Application{

    private static App mInstance;
    private WebService webService;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        NetworkComponent networkComponent = DaggerNetworkComponent.builder()
                .retrofitModule(new RetrofitModule()).build();

        webService = networkComponent.getWebService();
    }

    public WebService getWebService() {
        return webService;
    }

    public static App getApp() {
        if (mInstance != null) {
            return mInstance;
        } else {
            mInstance = new App();
            mInstance.onCreate();
            return mInstance;
        }
    }
}
