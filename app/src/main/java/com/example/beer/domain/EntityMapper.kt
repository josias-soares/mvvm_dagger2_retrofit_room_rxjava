package com.example.beer.domain

interface EntityMapper<DataSourceModel, DomainModel> {

    fun mapFromEntity(dataSourceModel: DataSourceModel): DomainModel

    fun mapToEntity(domainModel: DomainModel): DataSourceModel
}