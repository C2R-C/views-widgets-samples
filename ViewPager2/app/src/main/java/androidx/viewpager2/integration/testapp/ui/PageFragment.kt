package androidx.viewpager2.integration.testapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.integration.testapp.R

private const val KEY_ITEM_TEXT = "androidx.viewpager2.integration.testapp.KEY_ITEM_TEXT"

class PageFragment : Fragment() {

    private lateinit var textViewItemText: TextView

    companion object {
        fun create(itemText: String) =
            PageFragment().apply {
                arguments = Bundle(1).apply {
                    putString(KEY_ITEM_TEXT, itemText)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_mutable_collection, container, false)

        textViewItemText = view.findViewById(R.id.textViewItemText)

        textViewItemText.text = arguments?.getString(KEY_ITEM_TEXT) ?: throw IllegalStateException()


        return view
    }

}