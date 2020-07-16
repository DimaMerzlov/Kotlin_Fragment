package cwgtech.com.my_test_fragment

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var isOrientationFirstFragment:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        retainInstance = true;
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var context= activity?.resources?.configuration?.orientation
        if (context== Configuration.ORIENTATION_PORTRAIT){
            isOrientationFirstFragment= false

        }
        if (context== Configuration.ORIENTATION_LANDSCAPE){
            isOrientationFirstFragment= true
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("MY TEG",isOrientationFirstFragment.toString())
        if (isOrientationFirstFragment==true){
            textView.setTextColor(resources.getColor(R.color.colorPrimary))
        }
        textView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var fragmentMYManager= activity?.supportFragmentManager
                var fragmentTransaction= fragmentMYManager?.beginTransaction()

                var secondFragment=SecondFragment()
                secondFragment.isOrientationSecondFragment=isOrientationFirstFragment
                fragmentTransaction?.replace(R.id.firstLayout,secondFragment,secondFragment.tag)
                    ?.commit()
            }

        })

    }

}