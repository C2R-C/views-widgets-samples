/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.viewpager2.integration.testapp.adaptador

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.integration.testapp.R
import androidx.viewpager2.integration.testapp.viewmodel.ItemsViewModel
import androidx.viewpager2.widget.ViewPager2

/**
 * Shows how to use notifyDataSetChanged with [ViewPager2]
 */
abstract class MutableCollectionBaseActivity : FragmentActivity() {
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mutable_collection)

        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = createViewPagerAdapter()

    }

    abstract fun createViewPagerAdapter(): RecyclerView.Adapter<*>
    val items: ItemsViewModel by viewModels()
}
