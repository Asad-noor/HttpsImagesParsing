package bd.com.cmed.apiresponsedisplay.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Asad on 11/3/2017.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface SingletonScope {
}
