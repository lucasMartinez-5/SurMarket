package bo.edu.uajms.lucasmartinez.surmarket

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FragmentProfile : Fragment() {
    private lateinit var LNL_FRGProfile_NavHome: LinearLayout
    private lateinit var LNL_FRGProfile_NavCart: LinearLayout
    private lateinit var LNL_FRGProfile_NavProfile: LinearLayout
    private lateinit var IMV_FRGProfile_NavHome: ImageView
    private lateinit var TXV_FRGProfile_NavHome: TextView
    private lateinit var IMV_FRGProfile_NavCart: ImageView
    private lateinit var TXV_FRGProfile_NavCart: TextView
    private lateinit var IMV_FRGProfile_NavProfile: ImageView
    private lateinit var TXV_FRGProfile_NavProfile: TextView
    private lateinit var IMV_FRGProfile_Back: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        configureListeners()
    }

    private fun initializeViews(view: View) {
        /*
        LNL_FRGProfile_NavHome = view.findViewById(R.id.LNL_FRGProfile_NavHome)
        LNL_FRGProfile_NavCart = view.findViewById(R.id.LNL_FRGProfile_NavCart)
        LNL_FRGProfile_NavProfile = view.findViewById(R.id.LNL_FRGProfile_NavProfile)
        IMV_FRGProfile_NavHome = view.findViewById(R.id.IMV_FRGProfile_NavHome)
        TXV_FRGProfile_NavHome = view.findViewById(R.id.TXV_FRGProfile_NavHome)
        IMV_FRGProfile_NavCart = view.findViewById(R.id.IMV_FRGProfile_NavCart)
        TXV_FRGProfile_NavCart = view.findViewById(R.id.TXV_FRGProfile_NavCart)
        IMV_FRGProfile_NavProfile = view.findViewById(R.id.IMV_FRGProfile_NavProfile)
        TXV_FRGProfile_NavProfile = view.findViewById(R.id.TXV_FRGProfile_NavProfile)

         */
        IMV_FRGProfile_Back = view.findViewById(R.id.IMV_FRGProfile_Back)
    }

    /*
    private fun configureNavigationState() {
        val colorActive = ContextCompat.getColor(requireContext(), R.color.navActive)
        val colorInactive = ContextCompat.getColor(requireContext(), R.color.navInactive)

        // Home (Inactive)
        IMV_FRGProfile_NavHome.setColorFilter(colorInactive)
        TXV_FRGProfile_NavHome.setTextColor(colorInactive)
        TXV_FRGProfile_NavHome.setTypeface(null, Typeface.NORMAL)

        // Cart (Inactive)
        IMV_FRGProfile_NavCart.setColorFilter(colorInactive)
        TXV_FRGProfile_NavCart.setTextColor(colorInactive)
        TXV_FRGProfile_NavCart.setTypeface(null, Typeface.NORMAL)

        // Profile (Active)
        IMV_FRGProfile_NavProfile.setColorFilter(colorActive)
        TXV_FRGProfile_NavProfile.setTextColor(colorActive)
        TXV_FRGProfile_NavProfile.setTypeface(null, Typeface.BOLD)
    }

     */

    private fun configureListeners() {
        /*
        LNL_FRGProfile_NavHome.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_products_list)
        }
        LNL_FRGProfile_NavCart.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_cart)
        }
        IMV_FRGProfile_Back.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_products_list)
        }

         */

        IMV_FRGProfile_Back.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}