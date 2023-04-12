package com.example.myaudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvAudio : RecyclerView
    private val list = ArrayList<Audio>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val aboutPage = Intent(this, AboutActivity::class.java)
                startActivity(aboutPage)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAudio = findViewById(R.id.rv_audio)
        rvAudio.setHasFixedSize(true)
        list.addAll(getList())
        showRecyclerList()
    }

    private fun getList(): ArrayList<Audio>{
        val dataName = resources.getStringArray(R.array.data_Item)
        val dataDesc = resources.getStringArray(R.array.desc_Item)
        val dataDetail = resources.getStringArray(R.array.detail_Item)
        val dataPhoto = resources.obtainTypedArray(R.array.photo_Item)

        val listAudio = ArrayList<Audio>()
        for (i in dataName.indices){
            val audio = Audio(dataName[i], dataDesc[i], dataDetail[i],dataPhoto.getResourceId(i, -1))
            listAudio.add(audio)
        }
        return listAudio
    }

    private fun showRecyclerList(){
        rvAudio.layoutManager = LinearLayoutManager(this)
        val listAngkringanAdapter = ListAudioAdapter(list)
        rvAudio.adapter = listAngkringanAdapter
    }
}