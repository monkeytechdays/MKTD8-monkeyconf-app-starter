package io.monkeypatch.monkeyconf.app

import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test

class TalkListPresenterTest {

    @Test
    fun simpleTest() {
        val repo = mockk<ConferenceRepository> {
            coEvery { getConference() } returns listOf(
                Talk(
                    "id", "title", "date", "08:00:00", "09:00:00",
                    listOf(Speaker("Lambda", "Man", "bio", "avatar")),
                    Room("room"),
                    TechInfo(listOf("tech"), "EASY"), "description"
                ),
                Talk(
                    "id2", "title2", "date2", "09:00:00", "10:00:00",
                    listOf(Speaker("Didier", "Plainsoft", "bio", "avatar")),
                    Room("room"),
                    TechInfo(listOf("tech"), "EASY"), "description"
                )
            )
        }
        val view = mockk<TalkListView>(relaxed = true)
        val presenter = TalkListPresenter(view, repo, Dispatchers.Unconfined)
        presenter.onCreate()

        val expectedSummary = listOf(
            TalkSummary(
                "id", "08:00\n09:00", "title", "Lambda Man, room"
            ),
            TalkSummary(
                "id2", "09:00\n10:00", "title2", "Didier Plainsoft, room"
            )
        )

        verify(exactly = 1) {
            view.displayTalks(expectedSummary)
        }
    }
}