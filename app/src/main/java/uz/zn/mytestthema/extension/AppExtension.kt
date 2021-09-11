package uz.zn.mytestthema.extension

import android.app.Activity
import android.preference.PreferenceManager


fun Activity.setPrefValue(valueKey: String, value: String) {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    val edit = prefs.edit()
    edit.putString(valueKey, value)
    edit.apply()
}

fun Activity.getPrefValue(valueKey: String, valueDefault: String): String? {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    return prefs.getString(valueKey, valueDefault)
}