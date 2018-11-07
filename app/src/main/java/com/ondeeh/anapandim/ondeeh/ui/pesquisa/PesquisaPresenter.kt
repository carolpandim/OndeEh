package com.ondeeh.anapandim.ondeeh.ui.pesquisa

import com.ondeeh.anapandim.ondeeh.R
import com.ondeeh.anapandim.ondeeh.base.BasePresenter
import com.ondeeh.anapandim.ondeeh.network.EnderecoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PesquisaPresenter(pesquisaView: PesquisaView) :
        BasePresenter<PesquisaView>(pesquisaView) {

    @Inject
    lateinit var enderecoApi: EnderecoAPI

    private var subscription: Disposable? = null

    override fun onViewCreated() {
    }

    fun loadPosts(cep: String) {
        view.showLoading()
        subscription = enderecoApi
                .pesquisar(cep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { endereco -> view.atualizaEndereco(endereco) },
                        { view.showError("Erro desconhecido") }
                )
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        subscription?.dispose()
    }
}

