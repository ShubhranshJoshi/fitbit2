package com.example.fitbit2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitbit2.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sleepAdapter: SleepAdapter
    private val sleepEntries = mutableListOf<SleepEntry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        binding.buttonAddEntry.setOnClickListener {
            val intent = Intent(this, AddEntryActivity::class.java)
            startActivity(intent)
        }

        observeSleepEntries()
    }

    private fun setupRecyclerView() {
        sleepAdapter = SleepAdapter(sleepEntries)
        binding.recyclerView.adapter = sleepAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeSleepEntries() {
        val database = AppDatabase.getDatabase(this)
        lifecycleScope.launch {
            database.sleepDao().getAll().collectLatest { entries ->
                sleepEntries.clear()
                sleepEntries.addAll(entries)
                sleepAdapter.notifyDataSetChanged()
            }
        }
    }
}
