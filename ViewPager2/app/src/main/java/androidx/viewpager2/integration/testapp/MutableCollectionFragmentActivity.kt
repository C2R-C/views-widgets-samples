package androidx.viewpager2.integration.testapp

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.integration.testapp.adaptador.MutableCollectionBaseActivity
import androidx.viewpager2.integration.testapp.ui.PageFragment
import androidx.viewpager2.widget.ViewPager2


/**
 * Shows how to use [FragmentStateAdapter.notifyDataSetChanged] with [ViewPager2]. Here [ViewPager2]
 * represents pages as [Fragment]s.
 */
class MutableCollectionFragmentActivity : MutableCollectionBaseActivity() {
    override fun createViewPagerAdapter(): RecyclerView.Adapter<*> {
        val items = items // avoids resolving the ViewModel multiple times
        return object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): PageFragment {
                val itemId = items.itemId(position)
                val itemText = items.getItemById(itemId)
                return PageFragment.create(itemText)
            }
            override fun getItemCount(): Int = items.size
            override fun getItemId(position: Int): Long = items.itemId(position)
            override fun containsItem(itemId: Long): Boolean = items.contains(itemId)
        }
    }
}
