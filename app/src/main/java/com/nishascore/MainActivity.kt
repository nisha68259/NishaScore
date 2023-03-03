package com.nishascore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.nishascore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var rdp2: RadioButton
    var rdp4:RadioButton? = null
    var rdp6:RadioButton? = null
    var rdp8:RadioButton? = null
    var `val` = 0

    var checked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tgbutton.setOnClickListener { arg0: View? ->
            checked = if (binding.tgbutton.isChecked) {
                true
            } else {
                false
            }

            rdp2 = binding.rdp2
            rdp4 = binding.rdp4
            rdp6 = binding.rdp6
            rdp8 = binding.rdp8
            binding.inc?.setOnClickListener(View.OnClickListener { v: View? ->
                if (checked) {
                    var hh = (binding.teamascr?.getText().toString() + "").toInt()
                    hh = hh + `val`
                    binding.teamascr?.setText(hh.toString() + "")
                } else {
                    var hh = (binding.teambscr?.getText().toString() + "").toInt()
                    hh = hh + `val`
                    binding.teambscr?.setText(hh.toString() + "")
                }
            })


            binding.dec?.setOnClickListener(View.OnClickListener { v: View? ->
                if (checked) {
                    var hh = (binding.teamascr?.getText().toString() + "").toInt()
                    hh = hh - `val`
                    if (hh < 0) {
                        hh = 0
                    }
                    binding.teamascr?.setText(hh.toString() + "")
                } else {
                    var hh = (binding.teambscr?.getText().toString() + "").toInt()
                    hh = hh - `val`
                    if (hh < 0) {
                        hh = 0
                    }
                    binding.teambscr?.setText(hh.toString() + "")
                }
            })

        }
    }
    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.rdp2 -> if (checked) `val` = 2
            R.id.rdp4 -> if (checked) `val` = 4
            R.id.rdp6 -> if (checked) `val` = 6
            R.id.rdp8 -> if (checked) `val` = 8
        }
    }
}