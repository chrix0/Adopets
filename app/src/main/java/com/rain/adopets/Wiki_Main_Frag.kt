package com.rain.adopets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_wiki__main_.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Wiki_Main_Frag.newInstance] factory method to
 * create an instance of this fragment.
 */
class Wiki_Main_Frag : Fragment() {
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
    ): View? {
        // Inflate the layout for this fragmento
        val v : View =inflater.inflate(R.layout.fragment_wiki__main_, container, false)
        return run(v)
    }

    private fun run(view : View) : View{
        var data : MutableList<classWiki> = singletonData.wikiSpecies
        var infoRecyclerView =view.findViewById<RecyclerView>(R.id.info)
        var tipsRecyclerView =view.findViewById<RecyclerView>(R.id.tip)
        var dataInfo = filter(data,"info")
        var tipsInfo = filter(data,"tips")
        var MyAdapter = recycler_wiki_adapter(requireContext(),dataInfo){
            var intent = Intent(requireContext(), wiki_info::class.java)
            intent.putExtra(SHOW_WIKI_INFO,it)
            startActivity(intent)
        }
        infoRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false)
        infoRecyclerView.adapter = MyAdapter

        var MyAdapter2 = recycler_wiki_adapter(requireContext(),dataInfo){
            var intent = Intent(requireContext(), wiki_info::class.java)
            intent.putExtra(SHOW_WIKI_INFO,it)
            startActivity(intent)
        }
        tipsRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false)
        tipsRecyclerView.adapter = MyAdapter2

        var moreInfo = view.findViewById<Button>(R.id.moreInfo)
        moreInfo.setOnClickListener(){
            var intent = Intent(requireContext(), wiki_more::class.java)
            intent.putExtra(SHOW_WIKI_MORE,"info")
            startActivity(intent)
        }
        var moreTips = view.findViewById<Button>(R.id.moreTips)
        moreTips.setOnClickListener(){
            var intent = Intent(requireContext(), wiki_more::class.java)
            intent.putExtra(SHOW_WIKI_MORE,"tips")
            startActivity(intent)
        }
        return view
    }
    private fun filter(data : MutableList<classWiki>, tipe : String) : MutableList<classWiki>{
        var newList : MutableList<classWiki> = mutableListOf()
        for(i : classWiki in data){
            if(i.tipe.contains(tipe)){
                newList.add(i)
            }
        }
        return newList
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Wiki_Main_Frag.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Wiki_Main_Frag().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}