package com.example.islami.ui.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.islami.databinding.ActivityChapterDetailsBinding
import com.example.islami.ui.chapterDetails.adapter.ChapterDetailsAdapter
import com.example.islami.ui.home.fragments.QuranFragment


class ChapterDetailsActivity : AppCompatActivity() {

    private lateinit var adapter: ChapterDetailsAdapter
    lateinit var binding: ActivityChapterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val chapterName = intent.getStringExtra(QuranFragment.CHAPTER_NAME) as String
        val chapterPosition = intent.getIntExtra(QuranFragment.CHAPTER_POSITION, 0)
        binding.chapterContent.chapterName.text = chapterName
        val verses = readFromFile("${chapterPosition + 1}.txt")
        adapter = ChapterDetailsAdapter(verses)
        initRecyclerview()

        setupToolbar()

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initRecyclerview() {
        binding.chapterContent.rvVerses.adapter = adapter
    }

    private fun readFromFile(fileName: String): List<String> {
        val fileContent = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        return fileContent.split("\n")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}