package com.demo.extensions

import android.view.View
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class ViewExtensionsKtTest {

    @Test
    fun `Given a view, when visible is called, its visibility should change to VISIBLE`() {
        val context = RuntimeEnvironment.systemContext
        val view = View(context)

        view.visible()

        assertEquals(View.VISIBLE, view.visibility)
    }

    @Test
    fun `Given a view, when gone is called, its visibility should change to VISIBLE`() {
        val context = RuntimeEnvironment.systemContext
        val view = View(context)

        view.gone()

        assertEquals(View.GONE, view.visibility)
    }
}
