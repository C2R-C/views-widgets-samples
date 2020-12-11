package androidx.viewpager2.integration.testapp

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter

/**
 * This activity lists all the activities in this application.
 */
class MainActivity : ListActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listAdapter = SimpleAdapter(this, getData(),
                android.R.layout.simple_list_item_1, arrayOf("title"),
                intArrayOf(android.R.id.text1))
    }

    private fun getData(): List<Map<String, Any>> {
        val myData = mutableListOf<Map<String, Any>>()

        myData.add(mapOf("title" to "ViewPager2 with a Mutable Collection (Fragments)",
                "intent" to activityToIntent(MutableCollectionFragmentActivity::class.java.name)))

        return myData
    }

    private fun activityToIntent(activity: String): Intent =
            Intent(Intent.ACTION_VIEW).setClassName(this.packageName, activity)

    override fun onListItemClick(listView: ListView, view: View, position: Int, id: Long) {
        val map = listView.getItemAtPosition(position) as Map<*, *>

        val intent = Intent(map["intent"] as Intent)
        intent.addCategory(Intent.CATEGORY_SAMPLE_CODE)
        startActivity(intent)
    }
}
