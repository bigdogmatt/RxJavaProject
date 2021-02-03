package com.example.rxjavaproject.ui

import com.example.rxjavaproject.data.model.Results
import com.example.rxjavaproject.data.model.User
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface DetailsContract {

    interface View: MvpView {
        fun initializeRecyclerView()
        fun onDataFinished(users: Results)
        fun onError(e: Throwable)
    }

    interface Presenter: MvpPresenter<View> {
        fun loadUsers(numOfUsers: Int)
    }
}