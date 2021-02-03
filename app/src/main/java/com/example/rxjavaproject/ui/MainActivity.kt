package com.example.rxjavaproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.rxjavaproject.R

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setupViews()
  }

  private fun setupViews() {
    val spinner = findViewById<Spinner>(R.id.spinner)
    val arrayAdapter = ArrayAdapter(this,
      android.R.layout.simple_spinner_item,
      listOf(
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15))
    spinner.adapter = arrayAdapter

    val submitButton = findViewById<Button>(R.id.button)
    submitButton.setOnClickListener {
      val value = spinner.selectedItem as Int
      val detailsActivity = Intent(this, DetailsActivity::class.java)
      detailsActivity.putExtra("value", value)
      startActivity(detailsActivity)
    }
  }
}