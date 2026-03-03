package com.example.fitbit2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.fitbit2.databinding.ActivityAddEntryBinding
import kotlinx.coroutines.launch

class AddEntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            val date = binding.editTextDate.text.toString()
            val hours = binding.editTextHours.text.toString().toIntOrNull()
            val quality = binding.editTextQuality.text.toString()

            if (date.isNotEmpty() && hours != null && quality.isNotEmpty()) {
                val entry = SleepEntry(date = date, hours = hours, quality = quality)
                saveEntry(entry)
            }
        }
    }

    private fun saveEntry(entry: SleepEntry) {
        val database = AppDatabase.getDatabase(this)
        lifecycleScope.launch {
            database.sleepDao().insert(entry)
            finish()
        }
    }
}
