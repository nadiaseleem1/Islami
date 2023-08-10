package com.example.islami.ui.hadeethDetails

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.islami.databinding.ActivityHadeethDetailsBinding
import com.example.islami.ui.home.fragments.HadeethFragment


class HadeethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadeethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityHadeethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hadeethPosition = intent.getIntExtra(HadeethFragment.HADEETH_POSITION, 0)
        val hadeeth = readFromFile("hadeeth.txt", hadeethPosition)

        val title = getHadeethTitle(hadeeth, hadeethPosition)
        binding.hadeethContent.hadeethLabel.text = title
        setupToolbar()
        binding.hadeethContent.hadeethContent.movementMethod = ScrollingMovementMethod()
        binding.hadeethContent.hadeethContent.text = getHadeethContent(hadeeth, title)
    }

    private fun getHadeethContent(hadeeth: String, title: String): String {

        return hadeeth.replace(title.toRegex(), "")
    }

    private fun setupToolbar() {

        setSupportActionBar(binding.toolbarHadeeth)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun readFromFile(fileName: String, position: Int): String {
        val fileContent = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        return fileContent.split("#")[position]
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getHadeethTitle(hadeeth: String, position: Int): String {
        if (position == 0) {
            return hadeeth.split("\n")[0]
        } else {
            return hadeeth.split("\n")[1]
        }
    }

}