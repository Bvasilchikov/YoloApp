package com.example.myapplication


import android.R.attr.path
import android.os.AsyncTask
import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import java.util.*


class CallAPI : AsyncTask<String, String, Void>() {

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: String): Void? {
        val urlString = "http://192.168.1.233:7000/sl/ai/test/tag" // URL to call
        val data = params[1] //data to post
        var out: OutputStream? = null

        try {
            val url = URL(urlString)
            val urlConnection = url.openConnection() as HttpURLConnection
            out = BufferedOutputStream(urlConnection.outputStream)

            val writer = BufferedWriter(OutputStreamWriter(out, "UTF-8"))
            writer.write(data)
            writer.flush()
            writer.close()
            out.close()

            urlConnection.connect()
        } catch (e: Exception) {
            println(e.message)
        }

        return null
    }


}//set context variables if required