package com.hilalcifci.thy3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hilalcifci.thy3.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        apiService = retrofit.create(ApiService::class.java)

        binding.registerbutton.setOnClickListener {
            startActivity(Intent(applicationContext, Mainregister::class.java))
        }
        binding.forgetpasswordbutton.setOnClickListener {
            startActivity(Intent(applicationContext, MainForgetPassword::class.java))
        }

        binding.loginbutton.setOnClickListener {

            val user = User("email@example.com", "password123", "2000-01-01", "pembe", "surname", "female")
            val call = apiService.loginUser(user)

            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Toast.makeText(applicationContext, "Giriş başarılı", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Giriş başarısız", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Tebrikler", Toast.LENGTH_SHORT).show()
                }
            })

            intent = Intent(applicationContext, activity_loginpage::class.java)
            startActivity(intent)
        }
    }
}