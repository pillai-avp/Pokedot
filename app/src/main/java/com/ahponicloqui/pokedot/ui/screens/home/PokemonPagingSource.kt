package com.ahponicloqui.pokedot.ui.screens.home

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ahponicloqui.pokedot.model.Result
import com.ahponicloqui.pokedot.repository.PokedotRepository
import timber.log.Timber

class PokemonPagingSource(private val repository: PokedotRepository) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val response = repository.getPokemonList(offset = params.key ?: 0, limit = 20)
            val prevKey =
                response.previous?.let { Uri.parse(it).getQueryParameter("offset")?.toInt() ?: 0 }
            Timber.d("PrevKey : $prevKey")
            LoadResult.Page(
                data = response.results,
                prevKey = prevKey,
                nextKey = Uri.parse(response.next).getQueryParameter("offset")?.toInt() ?: 20,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}