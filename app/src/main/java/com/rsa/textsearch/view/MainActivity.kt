package com.rsa.textsearch.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rsa.textsearch.R
import com.rsa.textsearch.adapter.UserAdapter
import com.rsa.textsearch.model.UserModel


class MainActivity : AppCompatActivity() {
    
    private lateinit var editText: EditText
    private lateinit var recycleView: RecyclerView
    private lateinit var userList: ArrayList<UserModel>
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inIt()
        addData()
        searchQuery()
    }

    private fun searchQuery() {
        editText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                search(s.toString())
            }
        })
    }

    fun search(text: String) {
        val filterList: ArrayList<UserModel> = ArrayList()
        for (d in userList) {
            if (d.name.lowercase().contains(text.lowercase())) {
                filterList.add(d)
            }
        }
        //update recyclerview
        setAdapter(filterList)
    }


    private fun addData() {
        val model = UserModel(1, "Babar Azam")
        val model1 = UserModel(2, "Shahen Afridi")
        val model2 = UserModel(3, "Hassan Ali")
        val model3 = UserModel(4, "Shahid Afridi")
        val model4 = UserModel(5, "Shaheen Afridi")
        val model5 = UserModel(6, "Shoab Malik")
        val model6 = UserModel(7, "Wasim Junior")
        val model7 = UserModel(8, "Shadab Khan")
        val model8 = UserModel(9, "Imad Wasim")
        val model9 = UserModel(10, "Sarfraz Ahmad")
        val model10 = UserModel(11, "Shoab Akhtar")
        userList.add(model)
        userList.add(model1)
        userList.add(model2)
        userList.add(model3)
        userList.add(model4)
        userList.add(model5)
        userList.add(model6)
        userList.add(model7)
        userList.add(model8)
        userList.add(model9)
        userList.add(model10)
        setAdapter(userList)
    }

    private fun setAdapter(commonList: ArrayList<UserModel>) {
        adapter = UserAdapter(this, commonList)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
    }

    private fun inIt() {
        userList = ArrayList()
        editText = findViewById(R.id.editText)
        recycleView = findViewById(R.id.recycleView)
    }
}