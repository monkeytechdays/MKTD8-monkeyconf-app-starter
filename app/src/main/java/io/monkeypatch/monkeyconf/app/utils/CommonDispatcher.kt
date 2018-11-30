package io.monkeypatch.monkeyconf.app.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual object CommonDispatcher {
    actual val ui: CoroutineDispatcher = Dispatchers.Main
}