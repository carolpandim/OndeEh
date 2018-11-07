package com.ondeeh.anapandim.ondeeh.injection.component

import com.ondeeh.anapandim.ondeeh.base.BaseView
import com.ondeeh.anapandim.ondeeh.injection.module.ContextModule
import com.ondeeh.anapandim.ondeeh.injection.module.NetworkModule
import com.ondeeh.anapandim.ondeeh.ui.pesquisa.PesquisaPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    fun inject(pesquisaPresenter: PesquisaPresenter)
    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector
        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder
        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}
