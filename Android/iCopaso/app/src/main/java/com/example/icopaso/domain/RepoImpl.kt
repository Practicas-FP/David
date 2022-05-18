package com.example.icopaso.domain

import com.example.icopaso.data.DataSource
import com.example.icopaso.data.model.Drink
import com.example.icopaso.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {
    override fun getTragosList(): Resource<List<Drink>> {
    return dataSource.generateTragosList
    }
}