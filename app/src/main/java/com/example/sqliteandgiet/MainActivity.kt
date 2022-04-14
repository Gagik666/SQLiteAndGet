package com.example.sqliteandgiet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqliteandgiet.Db.MyDbManager
import com.example.sqliteandgiet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val myDbManager= MyDbManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            binding.tv.text = ""
            myDbManager.insertToDB(binding.ed1.text.toString())
            val dataList =myDbManager.readDb()
            for (i in dataList) {
                binding.tv.append(i)
                binding.tv.append("\n")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.onCloseDb()
    }
}