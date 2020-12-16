package tk.zwander.android

import android.content.Context
import brut.androlib.Androlib
import brut.androlib.ApkOptions

class AndrolibAndroid : Androlib {
    private val context: Context

    constructor(context: Context) : super(AndrolibResourcesAndroid(context)) {
        this.context = context
    }

    constructor(context: Context, options: ApkOptions) : super(options, AndrolibResourcesAndroid(context)) {
        this.context = context
    }
}