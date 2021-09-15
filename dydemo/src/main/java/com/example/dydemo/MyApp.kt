package com.example.dydemo

import android.app.Application
import cn.dianyinhuoban.hm.DYHelper

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        DYHelper.init(this)
    }
}