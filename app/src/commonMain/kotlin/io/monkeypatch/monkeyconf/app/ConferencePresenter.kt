package io.monkeypatch.monkeyconf.app

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class ConferencePresenter(
    view: TalkListView,
    private val repo: ConferenceRepository,
    private val uiDispatcher: CoroutineDispatcher
) : BasePresenter<TalkListView>(view) {

    override fun onCreate() {
        super.onCreate()
        loadConference()
    }

    fun loadConference() {
        launch(uiDispatcher) {
            try {
                view.displayConferences(repo.getConference())
            } catch (e: Exception) {
                view.displayError(e)
            } finally {
                view.showLoading(false)
            }
        }
    }
}