package io.monkeypatch.monkeyconf.app

interface TalkListView : BaseView {

    fun showLoading(loading: Boolean)
    fun displayConferences(conferences: List<Talk>)
}