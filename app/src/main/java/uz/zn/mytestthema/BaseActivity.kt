package uz.zn.mytestthema

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import uz.zn.mytestthema.extension.getPrefValue


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val currentTheme = getPrefValue(getString(R.string.currentTheme), "Default")
        when (currentTheme) {
            "Default" -> setTheme(R.style.Default)
            "Black" -> setTheme(R.style.Black)
            "Green" -> setTheme(R.style.Green)
            "Purple" -> setTheme(R.style.Purple)
        }
        super.onCreate(savedInstanceState)
    }
}