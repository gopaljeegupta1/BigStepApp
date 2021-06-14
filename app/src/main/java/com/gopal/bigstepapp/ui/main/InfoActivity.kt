package com.gopal.bigstepapp.ui.main

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gopal.bigstepapp.R
import com.gopal.bigstepapp.data.entities.Results

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


        var ivThumb = findViewById<ImageView>(R.id.ivThumb)
        var tvSongName = findViewById<TextView>(R.id.tvSongName)
        var tvAuthor = findViewById<TextView>(R.id.tvAuthor)
        var tvDate = findViewById<TextView>(R.id.tvDate)
        var tvPrice = findViewById<TextView>(R.id.tvPrice)

        val data = intent.extras
        val items = data?.getParcelable<Results>("DATA")

        tvSongName.text = items?.trackName
        tvAuthor.text = items?.artistName
        tvDate.text = items?.releaseDate
        tvPrice.text = items?.trackPrice.toString()

        Glide.with(this)
            .load(items?.artworkUrl100)
            .into(ivThumb)

    }


}