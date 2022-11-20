package com.demo.extensions

import org.junit.Assert.*
import org.junit.Test

class PrimitiveExtensionsKtTest {

    @Test
    fun `Given a null string, when isValid is called, returns false`() {
        val string: String? = null

        val isValid = string.isValid()

        assertFalse(isValid)
    }

    @Test
    fun `Given an empty string, when isValid is called, returns false`() {
        val string: String? = ""

        val isValid = string.isValid()

        assertFalse(isValid)
    }

    @Test
    fun `Given an non-empty, non-null string, when isValid is called, returns true`() {
        val string: String? = "Now we're talking!"

        val isValid = string.isValid()

        assertTrue(isValid)
    }
}
