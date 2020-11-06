package com.example.intentsapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //findViewById<Button>(R.id.displayContactsBtn).setOnClickListener { displayContacts() }
        findViewById<Button>(R.id.buttonCamera).setOnClickListener { dispatchTakePictureIntent() }
        findViewById<Button>(R.id.buttonGoogle).setOnClickListener { openGoogle() }
        findViewById<Button>(R.id.buttonMusic).setOnClickListener { openMusicPlayer() }

        findViewById<Button>(R.id.callButton).setOnClickListener { dialPhoneNumber() }
        findViewById<Button>(R.id.messageButton).setOnClickListener {  composeMmsMessage() }
    }
//    private fun displayContacts() {
//        val uri = Uri.parse("content://contacts/people")
//        val intent2 = Intent(Intent.ACTION_VIEW, uri)
//        startActivity(intent2)
//    }
    //OPEN CAMERA
    val REQUEST_IMAGE_CAPTURE = 1
    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }
    //OPENS SELECTED BROWSER AND ENTERS GOOGLE
    private fun openGoogle (){
        val url = "http://www.google.com"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
    //OPEN THE PHONE'S DEFAULT MUSIC PLAYER APP
    private fun openMusicPlayer(){
    val intent = Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER)
    startActivity(intent)
}
//    val toast = Toast.makeText(context:this, text "No fullname provided", Toast.LENGTH_SHORT)
//            toast.shot()
    fun dialPhoneNumber() {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("")
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    }else{
        val text = "ERROR: No Lawyer telephone number"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}
    fun composeMmsMessage() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("")

        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            val text = "ERROR: No Girlfriend in Contacts Found"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
    }

}