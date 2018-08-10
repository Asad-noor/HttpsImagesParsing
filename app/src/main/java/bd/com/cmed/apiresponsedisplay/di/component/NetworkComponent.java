package bd.com.cmed.apiresponsedisplay.di.component;


import bd.com.cmed.apiresponsedisplay.di.SingletonScope;
import bd.com.cmed.apiresponsedisplay.di.module.RetrofitModule;
import bd.com.cmed.apiresponsedisplay.service.WebService;
import dagger.Component;


/**
 * Created by Asad on 11/1/2017.
 */
@SingletonScope
@Component(modules = RetrofitModule.class)
public interface NetworkComponent {
    WebService getWebService();
}
