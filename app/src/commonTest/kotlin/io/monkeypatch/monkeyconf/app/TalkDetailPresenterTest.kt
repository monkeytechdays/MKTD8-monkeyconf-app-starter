package io.monkeypatch.monkeyconf.app

import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test

class TalkDetailPresenterTest {

    @Test
    fun simpleTest() {
        val repo = mockk<ConferenceRepository> {
            coEvery { getTalk("id") } returns Talk(
                "id", "title", "date", "08:00:00", "09:00:00",
                listOf(Speaker("Lambda", "Man", "bio", "avatar")),
                Room("room"),
                TechInfo(listOf("tech"), "EASY"), "description"
            )
        }
        val view = mockk<TalkDetailView>(relaxed = true)
        val presenter = TalkDetailPresenter("id", view, repo, Dispatchers.Unconfined)
        presenter.onCreate()

        val expected = TalkDetail(
            "title", "Lambda Man", "08:00 - 09:00", "room : tech - facile", "description"
        )

        verify(exactly = 1) {
            view.displayTalk(expected)
        }
    }
}