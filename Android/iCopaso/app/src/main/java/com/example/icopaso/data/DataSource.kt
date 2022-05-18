package com.example.icopaso.data

import com.example.icopaso.data.model.Drink
import com.example.icopaso.vo.Resource

class DataSource {

    val generateTragosList = Resource.Success(
       listOf(
        Drink("https://cdn5.recetasdeescandalo.com/wp-content/uploads/2018/09/Coctel-margarita-como-prepararlo.-Receta-e-ingredientes.jpg", "Margarita", "Con azucar, vodka y nueces"),
        Drink("https://www.recetas-argentinas.com/base/stock/Recipe/2-image/2-image_web.jpg", "Fernet", "Fernet con coca y dos hielos"),
        Drink("https://pbs.twimg.com/media/CERSHJwXIAATqjl.jpg", "Toro", "Toro con pritty"),
        Drink("https://www.losvinos.com.ar/wp-content/uploads/2019/12/tragos-con-gancia-1200x900.jpg", "Gancia", "Gancia con sprite")
       ))



}