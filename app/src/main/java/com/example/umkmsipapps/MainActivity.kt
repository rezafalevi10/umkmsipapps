package com.example.umkmsipapps

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectumkm.UserAdapter
import com.example.umkmsiapps.network.ApiConfig
import com.example.umkmsipapps.model.DataItem
import com.example.umkmsipapps.model.ResponseUser
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(mutableListOf())

        rv_users.setHasFixedSize(true)
        rv_users.layoutManager = LinearLayoutManager(this)
        rv_users.adapter = adapter
        getUser()
    }
    private fun getUser(){
        val client = ApiConfig.getApiService().getListUsers("2")
//        val client = ApiConfig.getApiService().getAllUsers()

//        getAllUsers
        client.enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>){
                Log.d("TestCatApi", "SUCCESS posting a fav: $response")
                if(response.isSuccessful){
                    val dataArray = response.body()?.data as List<DataItem>
                    for (data in dataArray){
                        adapter.addUser(data)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message, Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}