package com.yurentsy.swapi.mvp.di.component;

import com.yurentsy.swapi.gui.fragment.PeopleFragment;
import com.yurentsy.swapi.mvp.di.module.PeopleModule;
import com.yurentsy.swapi.mvp.di.scope.ListScope;

import dagger.Subcomponent;

@ListScope
@Subcomponent(modules = {PeopleModule.class})
public interface PeopleComponent {
    void inject(PeopleFragment fragment);
}
