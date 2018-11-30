package io.monkeypatch.monkeyconf.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

class TalkDetailActivity : AppCompatActivity(), TalkDetailView {
    lateinit var presenter: TalkDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        presenter = Container.talkDetailPresenter(intent.getStringExtra("talkId"), this)
        presenter.onCreate()
    }

    override fun displayTalk(talk: Talk) {
        supportActionBar?.title = talk.title
    }

    override fun displayError(e: Exception) {
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> false
        }
}