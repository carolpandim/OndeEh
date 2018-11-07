package com.ondeeh.anapandim.ondeeh.ui.pesquisa

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ondeeh.anapandim.ondeeh.R
import com.ondeeh.anapandim.ondeeh.base.BaseActivity
import com.ondeeh.anapandim.ondeeh.model.Endereco

class PesquisaActivity : BaseActivity<PesquisaPresenter>(), PesquisaView {
    override fun instantiatePresenter(): PesquisaPresenter {
        return PesquisaPresenter(this)
    }

    override fun atualizaEndereco(endereco: Endereco) {
        Toast.makeText(this, endereco.logradouro, Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        Toast.makeText(this, "Carregando...", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        Toast.makeText(this, "Fui....", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)
        presenter.loadPosts("04191270")
    }
}
