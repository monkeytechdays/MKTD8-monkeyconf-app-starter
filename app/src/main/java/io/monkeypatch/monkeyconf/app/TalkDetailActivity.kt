package io.monkeypatch.monkeyconf.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*

class TalkDetailActivity : AppCompatActivity(), TalkDetailView {
    lateinit var presenter: TalkDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        setContentView(R.layout.activity_detail)

        presenter = Container.talkDetailPresenter(intent.getStringExtra("talkId"), this)
        presenter.onCreate()
    }

    override fun displayTalk(talk: TalkDetail) {
        supportActionBar?.title = talk.title
        speakersTextView.text = talk.speakersString
        hourTextView.text = talk.hourString
        roomTextView.text = talk.roomAndTechString
        descriptionTextView.text = talk.descriptionString
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