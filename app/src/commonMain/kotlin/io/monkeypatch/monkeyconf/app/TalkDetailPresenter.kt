package io.monkeypatch.monkeyconf.app

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

interface TalkDetailView : BaseView {
    fun displayTalk(talk: TalkDetail)
}

class TalkDetailPresenter(
    private val talkId: String,
    private val talkDetailView: TalkDetailView,
    private val conferenceRepository: ConferenceRepository,
    private val uiDispatcher: CoroutineDispatcher
) : BasePresenter(talkDetailView){

    override fun onCreate() {
        super.onCreate()
        loadTalk()
    }

    private fun loadTalk() {
        launch(uiDispatcher) {
            try {
                val talk = conferenceRepository.getTalk(talkId)
                talk?.let { talkDetailView.displayTalk(it.toTalkDetail()) }
            } catch (e: Exception) {
                view.displayError(e)
            }
        }
    }
}