package com.ondeeh.anapandim.ondeeh.injection.module

import android.app.Application
import android.content.Context
import com.ondeeh.anapandim.ondeeh.base.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule {
    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }
    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}
