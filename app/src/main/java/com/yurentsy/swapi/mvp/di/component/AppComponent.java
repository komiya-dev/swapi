package com.yurentsy.swapi.mvp.di.component;

import com.yurentsy.swapi.gui.activity.HomeActivity;
import com.yurentsy.swapi.gui.fragment.HomeFragment;
import com.yurentsy.swapi.mvp.di.module.AppModule;
import com.yurentsy.swapi.mvp.di.module.FilmModule;
import com.yurentsy.swapi.mvp.di.module.ModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    ModelComponent plus(ModelModule modelModule);

    FilmComponent plus(FilmModule filmModule);

    void inject(HomeActivity activity);

    void inject(HomeFragment homeFragment);
}
