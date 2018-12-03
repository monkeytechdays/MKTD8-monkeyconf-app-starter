package io.monkeypatch.monkeyconf.app

data class TalkDetail(
    val title: String,
    val speakersString: String,
    val hourString: String,
    val roomAndTechString: String,
    val descriptionString: String
)

fun Talk.toTalkDetail(): TalkDetail {
    val title = this.title
    val speakersString = speakers.joinToString(", ") { it.fullName() }
    val hourString = "${startTime.dropLast(3)} - ${endTime.dropLast(3)}"
    val techInfoString = techInfo?.let {
        val difficultyString = when (it.difficulty) {
            "EASY" -> "facile"
            "MEDIUM" -> "moyen"
            "HARD" -> "difficile"
            else -> ""
        }
        ": ${it.themes.joinToString(", ")} - $difficultyString"
    } ?: ""
    val roomString = "${room.name} $techInfoString"

    return TalkDetail(
        title,
        speakersString,
        hourString,
        roomString,
        description
    )
}