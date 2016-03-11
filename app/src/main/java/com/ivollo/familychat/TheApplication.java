package com.ivollo.familychat;

import android.app.Application;

import com.ivollo.commons.di.CommonModule;
import com.ivollo.familychat.di.ApplicationComponent;
import com.ivollo.familychat.di.ApplicationModule;
import com.ivollo.familychat.di.DaggerApplicationComponent;
import com.ivollo.timescore.di.TimesModule;

/**
 * Comments:
 *
 * @author yining
 *         Created on 2016/3/9 11:42
 */
public class TheApplication extends Application {
    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CommonModule commonModule = new CommonModule(this, GlobalConstants.SERVER, GlobalConstants.OAUTH_CLIENT_ID,
                GlobalConstants.OAUTH_CLIENT_SECRET, 200);
        applicationComponent = DaggerApplicationComponent.builder().commonModule(commonModule)
                .timesModule(new TimesModule())
                .applicationModule(new ApplicationModule(this))
                .build();

    }
}
