package com.ondeeh.anapandim.ondeeh.ui.pesquisa

import android.support.annotation.StringRes
import com.ondeeh.anapandim.ondeeh.base.BaseView
import com.ondeeh.anapandim.ondeeh.model.Endereco

interface PesquisaView : BaseView {
    fun atualizaEndereco(endereco: Endereco)
    fun showError(error: String)
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }
    fun showLoading()
    fun hideLoading()
}
