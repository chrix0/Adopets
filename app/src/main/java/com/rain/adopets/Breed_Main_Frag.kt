package com.rain.adopets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_breed__main_.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Breed_Main_Frag.newInstance] factory method to
 * create an instance of this fragment.
 */
class Breed_Main_Frag : Fragment() {
    // TODO: Rename and change types of parameters
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
        val v : View = inflater.inflate(R.layout.fragment_breed__main_, container, false)
        return run(v)
    }
    private fun filter(searchText : String, data : MutableList<classBreed>) : MutableList<classBreed>{
        var newList : MutableList<classBreed> = mutableListOf()
        var text = searchText.trim().lowercase()
        if (text.equals("")){
            newList.addAll(data)
        }
        else{
            for(i : classBreed in data){
                if(i.tipe.lowercase().contains(text)){
                    newList.add(i)
                }
            }
        }

        return newList
    }
    private fun search(view : View, list : MutableList<classBreed>){
        var newList = mutableListOf<classBreed>()
        var search = view.findViewById<EditText>(R.id.search)
        search.setOnEditorActionListener { textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_DONE){
                newList.clear()
                newList.addAll(filter(search.text.toString(),list))
                recycleViewUpdate(view,newList)
            }
            return@setOnEditorActionListener true
        }
    }
    /*private fun filterAtoZ(view : View, list : MutableList<classBreed>){
        var filter = view.findViewById<ImageButton>(R.id.button_filter)
        filter.setOnClickListener() {
            list.sortBy { it.nama }
            list.reverse()
            recycleViewUpdate(view,list)
        }
    }*/

    private fun run(view:View) : View{
        var data : MutableList<classBreed> = singletonData.breedList
        recycleViewUpdate(view,data)
        search(view, data)
        //filterAtoZ(view, data)
        var history = view.findViewById<FloatingActionButton>(R.id.history)
        history.setOnClickListener(){
            var intent = Intent(requireContext(), breed_history::class.java)
            startActivity(intent)
        }
        return view
    }
    private fun recycleViewUpdate(view : View, data : MutableList<classBreed>){
        var breedRecycleView =view.findViewById<RecyclerView>(R.id.breedRecycleView)
        var MyAdapter = recycler_breed_adapter(requireContext(),data){
            var intent = Intent(requireContext(), breed_info::class.java)
            intent.putExtra(SHOW_BREED_INFO,it)
            startActivity(intent)
        }
        breedRecycleView.layoutManager = LinearLayoutManager(requireContext())
        breedRecycleView.adapter = MyAdapter
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Breed_Main_Frag.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Breed_Main_Frag().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}