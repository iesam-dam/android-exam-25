package educa.iesam.lista_desarrolladores.feature.domain

import educa.iesam.lista_desarrolladores.feature.data.local.DataSource

interface ObtenerRegistros {
    suspend fun getRemoteData(dataSource: DataSource)

    suspend fun getLocalData(dataSource: DataSource)

}