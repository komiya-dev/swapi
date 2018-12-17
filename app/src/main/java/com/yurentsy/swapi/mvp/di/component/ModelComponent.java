package com.yurentsy.swapi.mvp.di.component;

import com.yurentsy.swapi.gui.fragment.ListFragment;
import com.yurentsy.swapi.mvp.di.module.ModelModule;
import com.yurentsy.swapi.mvp.di.scope.ListScope;

import dagger.Subcomponent;

@ListScope
@Subcomponent(modules = {ModelModule.class})
public interface ModelComponent {
    void inject(ListFragment fragment);
}
