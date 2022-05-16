package com.example.cart.listener

import com.example.cart.model.DrinkModel

interface IDrinkLoadListener {
    fun onDrinkLoadSuccess(drinkModelList:List<DrinkModel>?)
    fun onDrinkLoadFailed(message:String?)
}