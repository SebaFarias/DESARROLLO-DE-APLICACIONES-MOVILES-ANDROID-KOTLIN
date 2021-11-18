package com.example.terrenosmarte.client

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith( JUnit4::class)
class TerrainClientTest {

    var server = MockWebServer()

    @Before
    fun setUp() {
        server.start
    }

    @After
    fun tearDown() {
    }
}