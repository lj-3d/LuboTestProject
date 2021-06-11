package com.lubo

sealed class RepoResult<out Entity : Any>() {
    data class Error(val exception: Exception?) : RepoResult<Nothing>()
    data class Success<out Entity : Any>(val data: Entity) : RepoResult<Entity>()
}