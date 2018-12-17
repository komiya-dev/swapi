package com.yurentsy.swapi.mvp.di.component;

import com.yurentsy.swapi.gui.fragment.FilmFragment;
import com.yurentsy.swapi.mvp.di.module.FilmModule;
import com.yurentsy.swapi.mvp.di.scope.ListScope;

import dagger.Subcomponent;

@ListScope
@Subcomponent(modules = {FilmModule.class})
public interface FilmComponent {
    void inject(FilmFragment fragment);
}
