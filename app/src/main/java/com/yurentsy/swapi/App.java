package com.yurentsy.swapi;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.yurentsy.swapi.gui.fragment.FilmFragment;
import com.yurentsy.swapi.mvp.di.component.AppComponent;
import com.yurentsy.swapi.mvp.di.component.DaggerAppComponent;
import com.yurentsy.swapi.mvp.di.component.FilmComponent;
import com.yurentsy.swapi.mvp.di.module.AppModule;
import com.yurentsy.swapi.mvp.di.module.FilmModule;

public class App extends Application {

    private static App instance;
    private AppComponent appComponent;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        Stetho.initializeWithDefaults(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public FilmComponent initFilmComponent(FilmFragment fragment) {
        return appComponent.plus(new FilmModule(fragment));
    }
}
