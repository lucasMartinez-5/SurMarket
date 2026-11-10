package bo.edu.uajms.lucasmartinez.surmarket

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bo.edu.uajms.lucasmartinez.surmarket.models.product

class FragmentProductsList : Fragment() {
    private lateinit var IMV_FRGProductsList_ShoppingCart: ImageView
    private lateinit var IMV_FRGProductsList_Search: ImageView
    private lateinit var ETX_FRGProductsList_Search: EditText
    private lateinit var BTN_FRGProductsList_AddProduct: Button
    private lateinit var RCV_FRGProductsList_ProductsList: RecyclerView
    private lateinit var LNL_FRGProductsList_NavHome: LinearLayout
    private lateinit var LNL_FRGProductsList_NavCart: LinearLayout
    private lateinit var LNL_FRGProductsList_NavProfile: LinearLayout
    private lateinit var IMV_FRGProductsList_NavHome: ImageView
    private lateinit var TXV_FRGProductsList_NavHome: TextView
    private lateinit var IMV_FRGProductsList_NavCart: ImageView
    private lateinit var TXV_FRGProductsList_NavCart: TextView
    private lateinit var IMV_FRGProductsList_NavProfile: ImageView
    private lateinit var TXV_FRGProductsList_NavProfile: TextView
    private lateinit var adapterProducts: AdapterProducts
    private var listaProductos = mutableListOf<product>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        configureNavigationState()
        configureListeners()
        configureRecyclerView()
        loadSampleProducts()
    }

    private fun initializeViews(view: View) {
        IMV_FRGProductsList_ShoppingCart = view.findViewById(R.id.IMV_FRGProductsList_ShoppingCart)
        IMV_FRGProductsList_Search = view.findViewById(R.id.IMV_FRGProductsList_Search)
        ETX_FRGProductsList_Search = view.findViewById(R.id.ETX_FRGProductsList_Search)
        BTN_FRGProductsList_AddProduct = view.findViewById(R.id.BTN_FRGProductsList_AddProduct)
        RCV_FRGProductsList_ProductsList = view.findViewById(R.id.RCV_FRGProductsList_ProductsList)
        LNL_FRGProductsList_NavHome = view.findViewById(R.id.LNL_FRGProductsList_NavHome)
        LNL_FRGProductsList_NavCart = view.findViewById(R.id.LNL_FRGProductsList_NavCart)
        LNL_FRGProductsList_NavProfile = view.findViewById(R.id.LNL_FRGProductsList_NavProfile)
        IMV_FRGProductsList_NavHome = view.findViewById(R.id.IMV_FRGProductsList_NavHome)
        TXV_FRGProductsList_NavHome = view.findViewById(R.id.TXV_FRGProductsList_NavHome)
        IMV_FRGProductsList_NavCart = view.findViewById(R.id.IMV_FRGProductsList_NavCart)
        TXV_FRGProductsList_NavCart = view.findViewById(R.id.TXV_FRGProductsList_NavCart)
        IMV_FRGProductsList_NavProfile = view.findViewById(R.id.IMV_FRGProductsList_NavProfile)
        TXV_FRGProductsList_NavProfile = view.findViewById(R.id.TXV_FRGProductsList_NavProfile)
    }

    private fun configureNavigationState() {
        val colorActive = ContextCompat.getColor(requireContext(), R.color.navActive)
        val colorInactive = ContextCompat.getColor(requireContext(), R.color.navInactive)

        // Home (Active)
        IMV_FRGProductsList_NavHome.setColorFilter(colorActive)
        TXV_FRGProductsList_NavHome.setTextColor(colorActive)
        TXV_FRGProductsList_NavHome.setTypeface(null, Typeface.BOLD)

        // Cart (Inactive)
        IMV_FRGProductsList_NavCart.setColorFilter(colorInactive)
        TXV_FRGProductsList_NavCart.setTextColor(colorInactive)
        TXV_FRGProductsList_NavCart.setTypeface(null, Typeface.NORMAL)

        // Profile (Inactive)
        IMV_FRGProductsList_NavProfile.setColorFilter(colorInactive)
        TXV_FRGProductsList_NavProfile.setTextColor(colorInactive)
        TXV_FRGProductsList_NavProfile.setTypeface(null, Typeface.NORMAL)
    }

    private fun configureListeners() {
        BTN_FRGProductsList_AddProduct.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.addProduct), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_product_list_to_add_product)
        }
        IMV_FRGProductsList_ShoppingCart.setOnClickListener {
            findNavController().navigate(R.id.action_products_list_to_cart)
        }
        LNL_FRGProductsList_NavCart.setOnClickListener {
            findNavController().navigate(R.id.action_products_list_to_cart)
        }
        LNL_FRGProductsList_NavProfile.setOnClickListener {
            findNavController().navigate(R.id.action_products_list_to_profile)
        }
    }

    private fun configureRecyclerView() {
        adapterProducts = AdapterProducts(
            productsList = listaProductos,
            clickOnBuy = { product ->
                Toast.makeText(
                    requireContext(),
                    getString(R.string.addCart) + "${product.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
        RCV_FRGProductsList_ProductsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterProducts
        }
    }

    private fun loadSampleProducts() {
        val productsSample = listOf(
            product(
                id = 1,
                name = "Camisa",
                category = "Ropa de Varón",
                price = 180.0,
                imageUrl = "",
                description = "Camisa de Varón Tommy Roja",
                availabel = true,
                stock = 1
            ),
            product(
                id = 2,
                name = "Pantalon",
                category = "Ropa de Varón",
                price = 180.0,
                imageUrl = "",
                description = "Pantalon de Varón Tommy Roja",
                availabel = true,
                stock = 1
            ),
            product(
                id=3,
                name="Zapatilla",
                category="Zapatilla de Varón",
                price=180.0,
                imageUrl="",
                description="Camisa de Varón Tommy Roja",
                availabel=true,
                stock=1
            ),
            product(
                id=4,
                name="Zapatos",
                category="Ropa de Varón",
                price=180.0,
                imageUrl="",
                description="Camisa de Varón Tommy Roja",
                availabel=true,
                stock=1
            ),
            product(
                id=5,
                name="Corbata",
                category="Ropa de Varón",
                price=180.0,
                imageUrl="",
                description="Camisa de Varón Tommy Roja",
                availabel=true,
                stock=1
            )
        )
        listaProductos.clear()
        listaProductos.addAll(productsSample)
        adapterProducts.notifyChanged()
    }
}