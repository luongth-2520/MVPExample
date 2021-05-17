package com.example.mvpexample.data.source.remote.helper

import android.os.AsyncTask
import com.example.mvpexample.data.source.remote.OnFetchDataListener
import org.json.JSONObject

class FetchDataTask<T> constructor(
    private val listener: OnFetchDataListener<T>,
) : AsyncTask<String, Unit, String>() {

    private var exception: Exception? = null

    override fun onPreExecute() {
        super.onPreExecute()
        listener.onLoading()
    }

    override fun doInBackground(vararg params: String): String {
        var result = ""
        try {
            result = NetworkHelper.getJsonFromUrl(params[0])
        } catch (ex: Exception) {
            exception = ex
        }
        return result
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        if (!result.isNullOrBlank()) {
            JSONObject(result).also {
                listener.onSuccess(JsonHelper.parseJsonArray(it) as T)
            }
        } else {
            listener.onError(exception)
        }
    }

}
