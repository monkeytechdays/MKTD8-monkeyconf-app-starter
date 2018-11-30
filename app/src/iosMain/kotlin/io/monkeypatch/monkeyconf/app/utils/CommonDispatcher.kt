package io.monkeypatch.monkeyconf.app.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.Foundation.NSThread
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext

actual object CommonDispatcher {
    actual val ui = object : CoroutineDispatcher() {

        override fun isDispatchNeeded(context: CoroutineContext): Boolean = !NSThread.isMainThread

        override fun dispatch(context: CoroutineContext, block: Runnable) {
            dispatch_async(dispatch_get_main_queue()) {
                block.run()
            }
        }
    }
}