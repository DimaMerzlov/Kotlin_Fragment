package cwgtech.com.my_test_fragment

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstFragment=FirstFragment()
        println(getScreenOrientation().toString())
        println(getScreenOrientation().toString())
        println(getScreenOrientation().toString())
        var manager=supportFragmentManager
        manager.beginTransaction().replace(R.id.firstLayout,firstFragment,firstFragment.tag)
            .addToBackStack(null).commit()

    }
    fun getScreenOrientation():Boolean{
        if (resources.configuration.orientation==Configuration.ORIENTATION_PORTRAIT){
            return false

        }
        if (resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){
            return true
        }
        return true
    }

}