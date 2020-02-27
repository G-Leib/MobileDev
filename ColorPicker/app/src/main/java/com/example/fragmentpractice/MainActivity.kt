package com.example.fragmentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import android.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_frag_one.*
import kotlinx.android.synthetic.main.fragment_frag_two.*
import kotlin.math.floor


class MainActivity : AppCompatActivity() {

    fun activateColorOne(state: Boolean) : Boolean {

        if (state) {
            supportFragmentManager.beginTransaction().hide(fragment1).commit()
        } else {
            supportFragmentManager.beginTransaction().show(fragment1).commit()
        }

        return !(state)
    }

    fun activateColorTwo(state: Boolean) : Boolean {

        if (state) {
            supportFragmentManager.beginTransaction().hide(fragment2).commit()
        } else {
            supportFragmentManager.beginTransaction().show(fragment2).commit()
        }

        return !(state)
    }

    fun getColor(state: Boolean, prog: Int) : Int {

        var newColor : Int

        if (state) {
            newColor = prog
        } else {
            newColor = 0
        }

        return newColor
    }

    fun changeColor(stateOne: Boolean, stateTwo: Boolean, progOne: Int, progTwo: Int) : Int {

        if (stateOne && stateTwo) {
            val newColOne = progOne
            val newColTwo = progTwo

            val newCol = floor(((newColOne.toDouble() + newColTwo) / 2)).toInt()

            return newCol

        } else if (stateOne) {
            return progOne
        } else  if (stateTwo){
            return progTwo
        }

        return 0


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var colorOneActive = true
        var colorTwoActive = true

        var mainRed: Int
        var mainGreen: Int
        var mainBlue: Int

        fun setFragThree() {
            mainRed = changeColor(colorOneActive, colorTwoActive, sb_red_one.progress, sb_red_two.progress)
            mainGreen = changeColor(colorOneActive, colorTwoActive, sb_green_one.progress, sb_green_two.progress)
            mainBlue = changeColor(colorOneActive, colorTwoActive, sb_blue_one.progress, sb_blue_two.progress)

            fragment3?.view?.setBackgroundColor(Color.rgb(mainRed, mainGreen, mainBlue))
        }

        col_one_btn.setOnClickListener {
            colorOneActive = activateColorOne(colorOneActive)

            setFragThree()
        }

        col_two_btn.setOnClickListener {
            colorTwoActive = activateColorTwo(colorTwoActive)

            setFragThree()
        }

        // Set reds
        sb_red_one!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                fragment1?.view?.setBackgroundColor(Color.rgb(sb_red_one.progress, sb_green_one.progress, sb_blue_one.progress))
                FragOneRedVal.text = progress.toString()
                setFragThree()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })

        sb_red_two!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                fragment2?.view?.setBackgroundColor(Color.rgb(sb_red_two.progress, sb_green_two.progress, sb_blue_two.progress))
                FragTwoRedVal.text = progress.toString()
                setFragThree()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })

        // Set greens
        sb_green_one!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                fragment1?.view?.setBackgroundColor(Color.rgb(sb_red_one.progress, sb_green_one.progress, sb_blue_one.progress))
                FragOneGreenVal.text = progress.toString()
                setFragThree()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })

        sb_green_two!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                fragment2?.view?.setBackgroundColor(Color.rgb(sb_red_two.progress, sb_green_two.progress, sb_blue_two.progress))
                FragTwoGreenVal.text = progress.toString()
                setFragThree()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })

        // Set blues
        sb_blue_one!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                fragment1?.view?.setBackgroundColor(Color.rgb(sb_red_one.progress, sb_green_one.progress, sb_blue_one.progress))
                FragOneBlueVal.text = progress.toString()
                setFragThree()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })

        sb_blue_two!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                fragment2?.view?.setBackgroundColor(Color.rgb(sb_red_two.progress, sb_green_two.progress, sb_blue_two.progress))
                FragTwoBlueVal.text = progress.toString()
                setFragThree()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }
        })



    }


}
