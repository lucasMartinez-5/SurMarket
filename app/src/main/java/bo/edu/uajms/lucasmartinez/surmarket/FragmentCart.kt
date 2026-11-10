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

class FragmentCart : Fragment() {
    private lateinit var LNL_FRGCart_NavHome: LinearLayout
    private lateinit var LNL_FRGCart_NavCart: LinearLayout
    private lateinit var LNL_FRGCart_NavProfile: LinearLayout
    private lateinit var IMV_FRGCart_NavHome: ImageView
    private lateinit var TXV_FRGCart_NavHome: TextView
    private lateinit var IMV_FRGCart_NavCart: ImageView
    private lateinit var TXV_FRGCart_NavCart: TextView
    private lateinit var IMV_FRGCart_NavProfile: ImageView
    private lateinit var TXV_FRGCart_NavProfile: TextView
    private lateinit var IMV_FRGCart_Back: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        configureNavigationState()
        configureListeners()
    }

    private fun initializeViews(view: View) {
        LNL_FRGCart_NavHome = view.findViewById(R.id.LNL_FRGCart_NavHome)
        LNL_FRGCart_NavCart = view.findViewById(R.id.LNL_FRGCart_NavCart)
        LNL_FRGCart_NavProfile = view.findViewById(R.id.LNL_FRGCart_NavProfile)
        IMV_FRGCart_NavHome = view.findViewById(R.id.IMV_FRGCart_NavHome)
        TXV_FRGCart_NavHome = view.findViewById(R.id.TXV_FRGCart_NavHome)
        IMV_FRGCart_NavCart = view.findViewById(R.id.IMV_FRGCart_NavCart)
        TXV_FRGCart_NavCart = view.findViewById(R.id.TXV_FRGCart_NavCart)
        IMV_FRGCart_NavProfile = view.findViewById(R.id.IMV_FRGCart_NavProfile)
        TXV_FRGCart_NavProfile = view.findViewById(R.id.TXV_FRGCart_NavProfile)
        IMV_FRGCart_Back = view.findViewById(R.id.IMV_FRGCart_Back)
    }

    private fun configureNavigationState() {
        val colorActive = ContextCompat.getColor(requireContext(), R.color.navActive)
        val colorInactive = ContextCompat.getColor(requireContext(), R.color.navInactive)

        // Home (Inactive)
        IMV_FRGCart_NavHome.setColorFilter(colorInactive)
        TXV_FRGCart_NavHome.setTextColor(colorInactive)
        TXV_FRGCart_NavHome.setTypeface(null, Typeface.NORMAL)

        // Cart (Active)
        IMV_FRGCart_NavCart.setColorFilter(colorActive)
        TXV_FRGCart_NavCart.setTextColor(colorActive)
        TXV_FRGCart_NavCart.setTypeface(null, Typeface.BOLD)

        // Profile (Inactive)
        IMV_FRGCart_NavProfile.setColorFilter(colorInactive)
        TXV_FRGCart_NavProfile.setTextColor(colorInactive)
        TXV_FRGCart_NavProfile.setTypeface(null, Typeface.NORMAL)
    }

    private fun configureListeners() {
        LNL_FRGCart_NavHome.setOnClickListener {
            findNavController().navigate(R.id.action_cart_to_products_list)
        }
        LNL_FRGCart_NavProfile.setOnClickListener {
            findNavController().navigate(R.id.action_cart_to_profile)
        }
        IMV_FRGCart_Back.setOnClickListener {
            findNavController().navigate(R.id.action_cart_to_products_list)
        }
    }
}