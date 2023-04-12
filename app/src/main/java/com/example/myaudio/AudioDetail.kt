package com.example.myaudio

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AudioDetail : AppCompatActivity(){
    private lateinit var btnShare: Button
    private lateinit var txtDetailNama: TextView
    private lateinit var ivDetailFoto: ImageView
    private lateinit var txtDetailDeskripsi: TextView
    private lateinit var txtDetail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataBarang = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Audio>("key_detail") as Audio
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Audio>("key_detail") as Audio
        }
        /*val dataBarang = intent.getParcelableExtra("key_detail") as Audio*/

        txtDetailNama = findViewById(R.id.dt_name)
        txtDetailDeskripsi = findViewById(R.id.dt_desc)
        txtDetail = findViewById(R.id.dt_detail)
        ivDetailFoto = findViewById(R.id.dt_photo)

        txtDetailNama.text = dataBarang.name
        txtDetailDeskripsi.text = dataBarang.desc
        txtDetail.text = dataBarang.detail
        ivDetailFoto.setImageResource(dataBarang.photo)


        btnShare = findViewById(R.id.dt_share)
        btnShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, dataBarang.name)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

}