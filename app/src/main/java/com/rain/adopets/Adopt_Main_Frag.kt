package com.rain.adopets


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rain.adopets.singletonData.adoptList
import kotlinx.android.synthetic.main.fragment_adopt__main_.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Adopt_Main_Frag.newInstance] factory method to
 * create an instance of this fragment.
 */
class Adopt_Main_Frag : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_adopt__main_, container, false)
        //Spinner Adapter for Pet Category


        return setSpinner(v)
    }

    private fun setSpinner(view: View) : View{
        val spinner : Spinner = view.findViewById(R.id.spinner_animalCategory)
        val adapterAnimalCategory = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.spinner_petCategoryItem,
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = adapterAnimalCategory
        var data : MutableList<classAdopt> = singletonData.adoptList
        var adoptRecycleView =view.findViewById<RecyclerView>(R.id.adoptRecycleView)
        var MyAdapter = recycler_adopt_adapter(requireContext(),singletonData.adoptList){
            var intent = Intent(requireContext(), adopt_info::class.java)
            intent.putExtra(SHOW_ADOPT_INFO,it)
            startActivity(intent)
        }
        adoptRecycleView.adapter = MyAdapter
        adoptRecycleView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Adopt_Main_Frag.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Adopt_Main_Frag().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}