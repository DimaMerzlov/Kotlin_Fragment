package cwgtech.com.my_test_fragment

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var isOrientationSecondFragment:Boolean=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isOrientationSecondFragment=getScreenOrientation()
        if (isOrientationSecondFragment==true){
            textView2.setTextColor(resources.getColor(R.color.colorPrimary))
        }
        textView2.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var fragmentMYManager= activity?.supportFragmentManager
                var fragmentTransaction= fragmentMYManager?.beginTransaction()

                var firstFragment=FirstFragment()
                fragmentTransaction?.replace(R.id.firstLayout,firstFragment,firstFragment.tag)
                    ?.commit()
            }

        })
    }
    fun getScreenOrientation():Boolean{
        if (resources.configuration.orientation== Configuration.ORIENTATION_PORTRAIT){
            return false

        }
        if (resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE){
            return true
        }
        return false
    }
}