package com.example.mvpexample.data.source.remote.helper

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object NetworkHelper {

    private const val TIME_OUT = 10000
    private const val METHOD_GET = "GET"

    fun getJsonFromUrl(strUrl: String): String {
        val url = URL(strUrl)
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.run {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            requestMethod = METHOD_GET
            setRequestProperty("User-Agent", "Mozilla/4.0")
            connect()
        }

        val bufferedReader = BufferedReader(InputStreamReader(httpURLConnection.inputStream))
        val stringBuilder = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuilder.toString()
    }

}
