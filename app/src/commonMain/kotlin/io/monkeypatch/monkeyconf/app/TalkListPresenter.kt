package io.monkeypatch.monkeyconf.app

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

interface TalkListView : BaseView {
    fun displayTalks(talks: List<TalkSummary>)
    fun displayLoading(b: Boolean)
}

class TalkListPresenter(
    private val talkListView: TalkListView,
    private val conferenceRepository: ConferenceRepository,
    private val uiDispatcher: CoroutineDispatcher
) : BasePresenter(talkListView) {
    var talks: List<Talk>? = null

    override fun onCreate() {
        super.onCreate()
        loadTalks()
    }

    private fun loadTalks() {
        launch(uiDispatcher) {
            try {
                talkListView.displayLoading(true)
                val talks = conferenceRepository.getConference()
                talkListView.displayTalks(talks.map { it.toTalkSummary() })
                this@TalkListPresenter.talks = talks
            } catch (e: Exception) {
                view.displayError(e)
            } finally {
                talkListView.displayLoading(false)
            }
        }
    }

    fun filterTalks(text: String) {
        talks?.let { t ->
            talkListView.displayTalks(t.filterTalks(text).map { it.toTalkSummary() })
        }
    }
}
