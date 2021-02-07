package com.example.codeeditor

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import android.widget.Button

lateinit var run:Button
lateinit var user_code:AutoCompleteTextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        run=findViewById<Button>(R.id.run_btn)
        user_code=findViewById<AutoCompleteTextView>(R.id.user_code)
        run.setOnClickListener {
            Run()
        }

    }

    private fun Run() {
         val intent = Intent(this,Code_Activity::class.java)
         intent.putExtra("code", user_code.text.toString())
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         val inflator=menuInflater
        inflator.inflate(R.menu.main_menu,menu)
        return true
    }

    @SuppressLint("SetTextI18n")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.run_menu ->{
                Run()
             return true}
            R.id.html_code ->{
                user_code.setText("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<title>HTML Tutorial</title>\n" +
                        "<body>\n" +
                        "\n" +
                        "<h1>This is a heading</h1>\n" +
                        "<p>This is a paragraph.</p>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>\n")

                }
            R.id.clear ->{
                user_code.setText("")
                return true
                }
            R.id.close ->{
                finish()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

}