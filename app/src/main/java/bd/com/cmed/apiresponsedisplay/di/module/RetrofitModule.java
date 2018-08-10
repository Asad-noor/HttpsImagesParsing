package bd.com.cmed.apiresponsedisplay.di.module;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import bd.com.cmed.apiresponsedisplay.di.SingletonScope;
import bd.com.cmed.apiresponsedisplay.service.WebService;
import bd.com.cmed.apiresponsedisplay.util.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Asad on 11/1/2017.
 */
@Module
public class RetrofitModule {

    @Provides
    @SingletonScope
    OkHttpClient provideOkhttpClient() {
        return new OkHttpClient.Builder()
                //.addInterceptor(provideHttpLoggingInterceptor())
                //.cache(provideHttpCache(context))
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @SingletonScope
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        return gsonBuilder.create();
    }

    @Provides
    @SingletonScope
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(provideGson()))
                .baseUrl(Constants.BASE_URL)
                .client(provideOkhttpClient())
                .build();
    }

    @Provides
    @SingletonScope
    WebService provideRetrofitToWeb() {
        Retrofit retrofit = provideRetrofit();
        return retrofit.create(WebService.class);
    }
}
