package com.yurentsy.swapi.mvp.di.module;

import android.content.Context;
import android.view.LayoutInflater;

import com.yurentsy.swapi.App;
import com.yurentsy.swapi.gui.fragment.FilmFragment;
import com.yurentsy.swapi.gui.fragment.HomeFragment;
import com.yurentsy.swapi.gui.fragment.PeopleFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = RepoModule.class)
public class AppModule {
    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return app;
    }

    @Singleton
    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(app);
    }

    @Provides
    HomeFragment provideHomeFragment() {
        return HomeFragment.newInstance();
    }

    @Provides
    FilmFragment provideFilmFragment() {
        return FilmFragment.newInstance();
    }

    @Provides
    PeopleFragment providePeopleFragment() {
        return PeopleFragment.newInstance();
    }
}
