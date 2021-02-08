package com.lubo.presentation.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {

    protected val resources = app.resources

}