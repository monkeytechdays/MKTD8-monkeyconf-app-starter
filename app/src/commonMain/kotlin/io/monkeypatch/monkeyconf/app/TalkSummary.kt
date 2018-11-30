package io.monkeypatch.monkeyconf.app

data class TalkSummary(
    val id: String,
    val hourString: String,
    val title: String,
    val subtitle: String
)

fun Speaker.fullName() = "$firstName $lastName"

fun Talk.toTalkSummary(): TalkSummary {
    val hourString = "${startTime.dropLast(3)}\n${endTime.dropLast(3)}"
    val title = this.title
    val speakersString = speakers.joinToString(", ") { it.fullName() }
    val subtitle = "$speakersString, ${room.name}"
    return TalkSummary(id, hourString, title, subtitle)
}