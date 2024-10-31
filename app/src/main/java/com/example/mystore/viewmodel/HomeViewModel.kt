package com.example.mystore.viewmodel

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mystore.R
import com.example.mystore.adapters.AdapterCardCatalog
import com.example.mystore.adapters.AdapterCardCategories
import com.example.mystore.adapters.AdapterCardPromo
import com.example.mystore.adapters.AdapterCardStock
import com.example.mystore.data_models.ItemsCardCatalog
import com.example.mystore.data_models.ItemsCardCategories
import com.example.mystore.data_models.ItemsCardPromo
import com.example.mystore.data_models.ItemsCardStock


class HomeViewModel : ViewModel() {

    private val categories = listOf(
        ItemsCardCategories(R.drawable.image_169, "Летний пикник"),
        ItemsCardCategories(R.drawable.image_170, "Летний обед"),
        ItemsCardCategories(R.drawable.image_172, "На завтрак"),
        ItemsCardCategories(R.drawable.image_173, "На ужин"),
        ItemsCardCategories(R.drawable.image_173, "На ужин"),
        ItemsCardCategories(R.drawable.image_173, "На ужин"),
        ItemsCardCategories(R.drawable.image_173, "На ужин")
    )
    private val _categories= MutableLiveData<AdapterCardCategories>().apply {
        value = AdapterCardCategories(categories)
    }

    val listCategories: LiveData<AdapterCardCategories> = _categories

    private val promo = listOf(
        ItemsCardPromo(R.drawable.new1),
        ItemsCardPromo(R.drawable.new1),
        ItemsCardPromo(R.drawable.new1),
        ItemsCardPromo(R.drawable.new1)
    )
    private val _promo = MutableLiveData<AdapterCardPromo>().apply {
        value = AdapterCardPromo(promo)
    }

    val listPromo: LiveData<AdapterCardPromo> = _promo


    private val stock = listOf(
        ItemsCardStock(
            R.drawable.image_190,
            "Черные спагетти с морепродуктам (большая порция)",
            "230 г",
            "360 р",
            "200 р",
            "-35%",
            true
        ),
        ItemsCardStock(
            R.drawable.image_197, "Казаречче с индейкой и томатами",
            "230 г",
            "360 р",
            "200 р",
            "-25%",
            false
        ),
        ItemsCardStock(
            R.drawable.image_199, "Равиоли с грибами",
            "230 г",
            "1360 р",
            "1200 р",
            "-35%",
            false
        ),
        ItemsCardStock(
            R.drawable.image_199, "Черные спагетти с морепродуктам (большая порция)",
            "230 г",
            "360 р",
            "200 р",
            "-35%",
            false
        ),
        ItemsCardStock(
            R.drawable.image_199, "Черные спагетти с морепродуктам (большая порция)",
            "230 г",
            "360 р",
            "200 р",
            "-35%",
            false
        ),
        ItemsCardStock(
            R.drawable.image_199, "Черные спагетти с морепродуктам (большая порция)",
            "230 г",
            "360 р",
            "200 р",
            "-35%",
            false
        ),
        ItemsCardStock(
            R.drawable.image_199, "Черные спагетти с морепродуктам (большая порция)",
            "230 г",
            "360 р",
            "200 р",
            "-35%",
            false
        )
    )
    private val _stock = MutableLiveData<AdapterCardStock>().apply {
        value = AdapterCardStock(stock)
    }

    val listStock: LiveData<AdapterCardStock> = _stock


    private val catalog = listOf(
        ItemsCardCatalog(
            R.drawable.image_189,
            "Наборы",
            Color.parseColor("#FFC1B6")
        ),
        ItemsCardCatalog(
            R.drawable.image_188,
            "Пицца",
            Color.parseColor("#FFE1AD")
        ),
        ItemsCardCatalog(
            R.drawable.image_183,
            "Паста",
            Color.parseColor("#BAB892")
        ),
        ItemsCardCatalog(
            R.drawable.image_178,
            "Ризотто",
            Color.parseColor("#C4D3CE")
        ),
        ItemsCardCatalog(
            R.drawable.image_199,
            "Салаты",
            Color.parseColor("#B9C4C8")
        ),
        ItemsCardCatalog(
            R.drawable.image_182,
            "Полуфабрикаты",
            Color.parseColor("#A3AE9D")
        ),
        ItemsCardCatalog(
            R.drawable.image_185,
            "Десерты",
            Color.parseColor("#FFE6B6")
        ),
        ItemsCardCatalog(
            R.drawable.image_187,
            "Добавки к блюдам",
            Color.parseColor("#D3C4C4")
        ),
        ItemsCardCatalog(
            R.drawable.image_186,
            "Напитки",
            Color.parseColor("#FFD4AD")
        )
    )
    private val _catalog = MutableLiveData<AdapterCardCatalog>().apply {
        value = AdapterCardCatalog(catalog)
    }

    val listCatalog: LiveData<AdapterCardCatalog> = _catalog

}