package androidx.viewpager2.integration.testapp.viewmodel

import androidx.lifecycle.ViewModel

/** A very simple collection of items. Optimized for simplicity (i.e. not performance). */
class ItemsViewModel : ViewModel() {
    private var nextValue = 1L

    private val items = (1..4).map { longToItem(nextValue++) }.toMutableList()


    fun getItemById(id: Long): String = items.first { itemToLong(it) == id }
    fun itemId(position: Int): Long = itemToLong(items[position])
    fun contains(itemId: Long): Boolean = items.any { itemToLong(it) == itemId }
    val size: Int get() = items.size

    private fun longToItem(value: Long): String = "item#$value"
    private fun itemToLong(value: String): Long = value.split("#")[1].toLong()
}