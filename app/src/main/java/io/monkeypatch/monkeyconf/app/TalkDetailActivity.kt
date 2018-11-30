package io.monkeypatch.monkeyconf.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*

class TalkDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        setContentView(R.layout.activity_detail)
        exampleDisplayData()
    }

    fun exampleDisplayData() {
        supportActionBar?.title = "title"
        speakersTextView.text = "speakers"
        hourTextView.text = "hour"
        roomTextView.text = "room"
        descriptionTextView.text = "description"
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