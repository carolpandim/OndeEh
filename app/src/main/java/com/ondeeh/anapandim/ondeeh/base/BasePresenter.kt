package com.ondeeh.anapandim.ondeeh.base

import com.ondeeh.anapandim.ondeeh.injection.component.DaggerPresenterInjector
import com.ondeeh.anapandim.ondeeh.injection.component.PresenterInjector
import com.ondeeh.anapandim.ondeeh.injection.module.ContextModule
import com.ondeeh.anapandim.ondeeh.injection.module.NetworkModule
import com.ondeeh.anapandim.ondeeh.ui.pesquisa.PesquisaPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V){

    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated(){


    }

    open fun onViewDestroyed(){


    }

    private fun inject() {
        when (this) {
            is PesquisaPresenter -> injector.inject(this)
        }
    }


}
