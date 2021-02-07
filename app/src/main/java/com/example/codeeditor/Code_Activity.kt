package com.example.codeeditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView


class Code_Activity : AppCompatActivity() {
    lateinit var web_browser:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_)

        web_browser=findViewById<WebView>(R.id.web_browser)




        web_browser.loadData(intent.getStringExtra("code").toString(),"text/html; charset=UTF-8", null )
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator=menuInflater
        inflator.inflate(R.menu.code_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.enablejs ->{
                web_browser.settings.javaScriptEnabled

                return true}



        }
        return super.onOptionsItemSelected(item)
    }

}