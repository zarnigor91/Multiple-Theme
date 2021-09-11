package uz.zn.mytestthema

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.GridLayout.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_switch_theme.*
import uz.zn.mytestthema.extension.setPrefValue
import uz.zn.mytestthema.model.ThemeModel

class SwitchThemeActivity : BaseActivity(), ThemeChangeListener {


    override fun onThemeChanged(themeModel: ThemeModel) {
        setPrefValue(getString(R.string.currentTheme), themeModel.themeName.toString())
        recreate()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_theme)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Switch Theme"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = MultiThemeListAdapter(this)
        Log.wtf("layout",""+rvThemes.layoutManager)
        rvThemes.adapter = adapter
        Log.wtf("layoutAdapter",""+ rvThemes.adapter)
        rvThemes.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)
        Log.wtf("layout",""+rvThemes.layoutManager)
        adapter.setData(getThemes())
        Log.wtf("layoutSet",""+adapter.setData(getThemes()))
    }

    private fun getThemes(): ArrayList<ThemeModel> {
        val themesList: ArrayList<ThemeModel> = ArrayList()

        val default = ThemeModel()
        default.themeColor = R.color.colorPrimary
        default.themeName = "Default"
        themesList.add(default)

        val black = ThemeModel()
        black.themeColor = R.color.blackColorPrimary
        black.themeName = "Black"
        themesList.add(black)

        val green = ThemeModel()
        green.themeColor = R.color.greenColorPrimary
        green.themeName = "Green"
        themesList.add(green)

        return themesList
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
                if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}