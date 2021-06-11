package com.lubo.presentation.base

import android.app.Application
import android.content.res.Resources
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.lubo.RepoResult
import com.lubo.entity.BaseEntity
import kotlinx.coroutines.launch
import java.lang.Exception

abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {

    protected val resources: Resources = app.resources

    protected var errorListener: ErrorListener? = null

    fun attachErrorListener(errorListener: ErrorListener) {
        this.errorListener = errorListener
    }

    public interface ErrorListener {
        fun showError(exception: Exception)
    }

}