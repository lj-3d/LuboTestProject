package com.lubo.presentation.extension

import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import androidx.viewbinding.ViewBinding
import org.kodein.di.*
import org.kodein.di.DI.Builder
import org.kodein.di.DI.Builder.TypeBinder

inline fun <reified VM : AndroidViewModel> Builder.bindViewModel(override: Boolean = false): TypeBinder<VM> {
    return bind<VM>(VM::class.java.simpleName, override)
}

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

inline fun <reified VB : ViewBinding> AppCompatActivity.provideViewBinding(
    crossinline bindingInflater: (LayoutInflater) -> VB
): Lazy<VB> {
    return lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater(LayoutInflater.from(applicationContext))
    }
}

fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
    val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
    val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
    return layoutManager.getPosition(snapView)
}