package com.example.simplediary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplediary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var diaryViewModel: DiaryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Set contactItemClick & contactItemLongClick lambda
        val adapter = DiaryAdapter({ contact ->
            val intent = Intent(this, AddActivity::class.java)
            intent.putExtra(AddActivity.EXTRA_DIARY_TITLE, contact.title)
            intent.putExtra(AddActivity.EXTRA_DIARY_CONTENT, contact.content)
            intent.putExtra(AddActivity.EXTRA_DIARY_ID, contact.id)
            startActivity(intent)
        }, { contact ->
            deleteDialog(contact)
        })

        val lm = LinearLayoutManager(this)
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager = lm
        binding.tvMain.setHasTransientState(true)

        diaryViewModel = ViewModelProviders.of(this).get(DiaryViewModel::class.java)
        diaryViewModel.getAll().observe(this, Observer<List<Diary>> { diarys ->
            adapter.setDiarys(diarys!!)
        })

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    private fun deleteDialog(contact: Diary) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Delete selected contact?")
            .setNegativeButton("NO") { _, _ -> }
            .setPositiveButton("YES") { _, _ ->
                diaryViewModel.delete(contact)
            }
        builder.show()
    }
}