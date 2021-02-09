package com.lubo.presentation.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DIAware
import org.kodein.di.direct
import org.kodein.di.instance

inline fun <reified VM : AndroidViewModel, T> T.provideViewModel(): Lazy<VM>
        where T : AppCompatActivity, T : DIAware {
    return lazy {
        ViewModelProvider(this, direct.instance()).get(VM::class.java)
    }
}

inline fun <reified VM : AndroidViewModel, T> T.provideViewModel(): Lazy<VM>
        where T : Fragment, T : DIAware {
    return lazy {
        ViewModelProvider(this, direct.instance()).get(VM::class.java)
    }
}