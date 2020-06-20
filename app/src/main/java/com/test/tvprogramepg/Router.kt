package com.test.tvprogramepg

import androidx.annotation.IdRes
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.navOptions

class Router(private val activity: MainActivity) {

    fun navigate(@IdRes resId: Int, options: NavOptions =  navOptions {}) {
        val item = Navigation.findNavController(activity,R.id.nav_host_fragment)
        when {
            item.currentDestination?.id != resId ->item.navigate(resId,null,options)
            else -> {
                //TODO:
                item.navigate(resId,null, navOptions {
                    launchSingleTop = true
                })
            }
        }
    }

}