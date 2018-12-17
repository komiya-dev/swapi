package com.yurentsy.swapi.mvp.di.module;

import android.view.LayoutInflater;

import com.yurentsy.swapi.gui.adapter.film.FilmAdapter;
import com.yurentsy.swapi.gui.adapter.film.FilmListItemViewHolderFactory;
import com.yurentsy.swapi.gui.fragment.FilmFragment;
import com.yurentsy.swapi.mvp.di.scope.ListScope;

import dagger.Module;
import dagger.Provides;

@Module
public class FilmModule {
    private final FilmFragment filmFragment;

    public FilmModule(FilmFragment fragment) {
        this.filmFragment = fragment;
    }

    @ListScope
    @Provides
    FilmAdapter provideFilmAdapter(FilmListItemViewHolderFactory factory) {
        return new FilmAdapter(factory);
    }

    @ListScope
    @Provides
    FilmListItemViewHolderFactory provideFilmListItemViewHolderFactory(LayoutInflater layoutInflater) {
        return new FilmListItemViewHolderFactory(layoutInflater, filmFragment);
    }
}
