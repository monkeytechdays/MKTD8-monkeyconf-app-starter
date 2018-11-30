package io.monkeypatch.monkeyconf.app.utils

import kotlinx.coroutines.CoroutineDispatcher

expect object CommonDispatcher {
    val ui: CoroutineDispatcher
}