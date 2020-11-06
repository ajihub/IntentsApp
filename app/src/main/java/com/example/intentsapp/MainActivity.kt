package com.example.intentsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set Action
        intent.setAction(Intent.ACTION_ANSWER)
        //set data

//        intent.setData(uri)

        //instantiate
        //listen to event by registering event listener
        findViewById<Button>(R.id.displayContactsBtn).setOnClickListener { displayContacts() }
//        findViewById<Button>(R.id.buttonGoogle).setOnClickListener { openGoogle() }
        findViewById<Button>(R.id.buttonMusic).setOnClickListener { openMusicPlayer() }
    }
    private fun displayContacts() {
        val uri = Uri.parse("content://contacts/people")
        val intent2 = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent2)
    }
    private fun openGoogle (){
        val url = "http://www.google.com"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
    private fun openMusicPlayer(){
    val intent = Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER)
    startActivity(intent)
}
}