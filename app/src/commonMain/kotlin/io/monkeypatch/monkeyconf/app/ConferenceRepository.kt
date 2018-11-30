package io.monkeypatch.monkeyconf.app

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.list

interface ConferenceRepository {
    suspend fun getConference(): List<Talk>
    suspend fun getTalk(id: String): Talk?
}

class ConferenceRepositoryImpl(
    private val url: String
) : ConferenceRepository {
    private val client get() = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer().apply {
                register(Talk.serializer().list)
            }
        }
    }

    private var conferences: List<Talk>? = null

    private suspend fun loadTalks(): List<Talk> = client.get(url)

    override suspend fun getConference(): List<Talk> =
        conferences ?: loadTalks().also { conferences = it }

    override suspend fun getTalk(id: String): Talk? =
        getConference().find { it.id == id }
}