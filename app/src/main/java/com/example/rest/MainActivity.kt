package com.example.rest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.revotrends.eliteswap.data.local.EmailPassword
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



   // lateinit var factory: ViewModelProvider.Factory
     lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailPassword=EmailPassword("aymandkhissi@gmail.com","azertyuiop")
         myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        txtView.setOnClickListener {

            myViewModel.login(emailPassword).observe(this, Observer {
                it.let {
                    Log.e("result",it!!.code().toString())
                }
            })
        }


    }
}
