package com.example.simplediary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.simplediary.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private lateinit var diaryViewModel: DiaryViewModel
    private var id: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        diaryViewModel = ViewModelProviders.of(this).get(DiaryViewModel::class.java)

        // intent null check & get extras
        if (intent != null && intent.hasExtra(EXTRA_DIARY_TITLE) && intent.hasExtra(EXTRA_DIARY_CONTENT)
            && intent.hasExtra(EXTRA_DIARY_ID)) {
            binding.addEdittextName.setText(intent.getStringExtra(EXTRA_DIARY_TITLE))
            binding.addEdittextNumber.setText(intent.getStringExtra(EXTRA_DIARY_CONTENT))
            id = intent.getLongExtra(EXTRA_DIARY_ID, -1)
        }

        binding.addButton.setOnClickListener {
            val name = binding.addEdittextName.text.toString().trim()
            val number = binding.addEdittextNumber.text.toString()

            if (name.isEmpty() || number.isEmpty()) {
                Toast.makeText(this, "Please enter name and number.", Toast.LENGTH_SHORT).show()
            } else {
                val initial = name[0].toUpperCase()
                val diary = Diary(id, title = "", content = "", initial)
                diaryViewModel.insert(diary)
                finish()
            }
        }
    }

    companion object {
        const val EXTRA_DIARY_TITLE = "EXTRA_DIARY_TITLE"
        const val EXTRA_DIARY_CONTENT = "EXTRA_DIARY_CONTENT"
        const val EXTRA_DIARY_ID = "EXTRA_DIARY_ID"
    }
}