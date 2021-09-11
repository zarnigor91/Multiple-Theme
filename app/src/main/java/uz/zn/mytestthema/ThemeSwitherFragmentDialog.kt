package uz.zn.mytestthema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_switch_theme.*
import uz.zn.mytestthema.extension.setPrefValue
import uz.zn.mytestthema.model.ThemeModel


class ThemeSwitherFragmentDialog : DialogFragment(), ThemeChangeListener {


    companion object {
        const val TAG = "SwitcherDialog"
    }

    override fun onThemeChanged(themeModel: ThemeModel) {
        mActivity.setPrefValue(getString(R.string.currentTheme), themeModel.themeName.toString())
        mActivity.recreate()
        dismiss()
    }

    lateinit var mActivity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_switch_theme, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity = activity as MainActivity

        val adapter = MultiThemeListAdapter(this)
        rvThemes?.adapter = adapter
        rvThemes.layoutManager = GridLayoutManager(mActivity, 4) as RecyclerView.LayoutManager?
        adapter.setData(getThemes())
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

        val purple = ThemeModel()
        purple.themeColor = R.color.purpleColorPrimary
        purple.themeName = "Purple"
        themesList.add(purple)

        return themesList
    }
}