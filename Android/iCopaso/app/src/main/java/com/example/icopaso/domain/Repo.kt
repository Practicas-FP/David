package com.example.icopaso.domain

import com.example.icopaso.data.model.Drink
import com.example.icopaso.vo.Resource

interface Repo {
    fun getTragosList():Resource<List<Drink>>
}