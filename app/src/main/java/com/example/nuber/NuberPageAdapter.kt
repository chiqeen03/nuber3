package com.example.nuber

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class NuberPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                NUberMapsActivity()
            }
            1 -> NuberShoppingFragment()
            else -> {
                return NuberProductsFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Nuber Map"
            1 -> "Shop ME"
            else -> {
                return "My Car"
            }
        }
    }
}
