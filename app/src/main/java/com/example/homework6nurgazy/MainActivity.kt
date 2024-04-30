package com.example.homework6nurgazy

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.homework6nurgazy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TextWatcher {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            emailEt.addTextChangedListener(this@MainActivity)
            passwordEt.addTextChangedListener(this@MainActivity)

            enterBtn.setOnClickListener {
                if (emailEt.text.toString() == "admin" && passwordEt.text.toString() == "admin") {
                    Toast.makeText(
                        this@MainActivity, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT
                    ).show()
                    registerBoxLinear.isVisible = false
                } else {
                    Toast.makeText(
                        this@MainActivity, "Неправильный логин или пароль", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        binding.enterBtn.isEnabled =
            binding.emailEt.text.isNotEmpty() && binding.passwordEt.text.isNotEmpty()
    }

}