package io.monkeypatch.monkeyconf.app

private fun Talk.matches(query: String) =
    title.toLowerCase().contains(query)
            || speakers.any { it.fullName().toLowerCase().contains(query) }
            || description.toLowerCase().contains(query)

fun List<Talk>.filterTalks(query: String) = filter {it.matches(query.toLowerCase()) }