package uz.zn.mytestthema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_switch_theme.*

class MainActivity : BaseActivity() {
    var liveData: MutableLiveData<String> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_thema)

        setSupportActionBar(toolbar)
//        supportActionBar?.title = ""
        supportActionBar?.setDisplayShowTitleEnabled(false);

        liveData.observe(this, Observer {
            Log.d("MainActivity", it + "")
        })

        liveData.value = "Activity Created"
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.action_switch_theme) {
            //startActivity(Intent(this, SwitchThemeActivity::class.java))
            val dialog = ThemeSwitherFragmentDialog()
            liveData.value = "Option item selected"
            dialog.show(supportFragmentManager, ThemeSwitherFragmentDialog.TAG)
        }
        return super.onOptionsItemSelected(item)
    }
}