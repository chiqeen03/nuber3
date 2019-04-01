package com.example.nuber

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_nuber_products.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NuberProductsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NuberProductsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NuberProductsFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuber_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = NuberProductsAdapter(mutableListOf<Salad>())
        }
        getProducts()
    }


    private fun getProducts(){

        val ref = FirebaseDatabase.getInstance().getReference("/salands")

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                val list = mutableListOf<Salad>()
                p0.children.forEach {
                    val product = it.getValue(Salad::class.java)
                    list.add(product!!)

                }
                list_recycler_view.adapter = NuberProductsAdapter(list)
            }


        } )
    }


}
