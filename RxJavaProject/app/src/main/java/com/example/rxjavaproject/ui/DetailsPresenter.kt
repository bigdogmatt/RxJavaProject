package com.example.rxjavaproject.ui

import com.example.rxjavaproject.data.DataRepository
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class DetailsPresenter (
    private val dataRepository: DataRepository
) : MvpBasePresenter<DetailsContract.View>(), DetailsContract.Presenter {

    override fun loadUsers(numOfUsers: Int) {
        dataRepository
            .loadUsers(numOfUsers)
            .subscribe({ifViewAttached { view -> view.onDataFinished(it) }}, {ifViewAttached { view -> view.onError(it) }})
    }
}