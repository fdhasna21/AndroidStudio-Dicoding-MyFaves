package com.fdhasna21.androidstudio_dicoding_myfaves

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_group_detail.*
import java.lang.String

class GroupDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.title = selectedRow.name

        val intent = Intent()
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        intent.action = Intent.ACTION_VIEW

        detail_description.text = getString(R.string.tab)+selectedRow.desc
        detail_kpopwiki.setOnClickListener {
            intent.data = Uri.parse(String.format(selectedRow.kpopwiki))
            startActivity(Intent.createChooser(intent, "Open with"))
        }
        detail_wikipedia.setOnClickListener {
            intent.data = Uri.parse(String.format(selectedRow.wikipedia))
            startActivity(Intent.createChooser(intent, "Open with"))
        }
        detail_kprofile.setOnClickListener {
            intent.data = Uri.parse(String.format(selectedRow.kprofile))
            startActivity(Intent.createChooser(intent, "Open with"))
        }

        Glide.with(this)
            .load(selectedRow.photo)
            .into(detail_image)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}