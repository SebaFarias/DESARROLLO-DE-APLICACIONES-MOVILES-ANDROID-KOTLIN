package com.example.terrenosmarte.client

import com.example.terrenosmarte.FileReader
import com.google.common.truth.Truth
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith( JUnit4::class)
class TerrainClientTest {

    private var server = MockWebServer()
    private var body = FileReader.lectorJson("terrenos.json")

    @Before
    fun setUp() {
        server.start(8080)
        server.enqueue(MockResponse().setResponseCode(200).setBody(body))
        server.url("realestate")
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
    @Test
    fun test_apiSuccess()
    {
        val call = TerrainClient.getClient("http://localhost:8080/").getTerrains()

        val terrainslist = call.execute().body()
        Truth.assertThat(terrainslist?.get(0)?.type.toString()).isEqualTo("buy")

    }
}