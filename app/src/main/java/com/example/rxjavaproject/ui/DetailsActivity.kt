package com.example.rxjavaproject.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavaproject.R
import com.example.rxjavaproject.data.DataRepository
import com.example.rxjavaproject.data.model.Results
import com.example.rxjavaproject.data.model.User
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : MvpActivity<DetailsContract.View, DetailsContract.Presenter>(),
    DetailsContract.View {

    private val detailsPresenter = DetailsPresenter(DataRepository())
    private var myAdapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initializeRecyclerView()
        loadUsers()
    }

    override fun initializeRecyclerView() {
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        user_list_item.layoutManager = layoutManager
        myAdapter = MyAdapter(mutableListOf())
        user_list_item.adapter = myAdapter
    }

    override fun onDataFinished(users: Results) {
        Log.d("TAG", "onNext triggered")

        Toast.makeText(this, "onNext triggered", Toast.LENGTH_SHORT).show()
        myAdapter?.swapData(users.results.orEmpty())
    }

    override fun onError(e: Throwable) {
        Log.d("TAG", e.localizedMessage)

        Toast.makeText(this, "Error ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    private fun loadUsers() {
        val numOfUsers = intent.getIntExtra("value", 0)
        detailsPresenter.loadUsers(numOfUsers)
    }

    override fun createPresenter(): DetailsContract.Presenter = detailsPresenter
}