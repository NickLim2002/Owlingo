package com.example.owlingo.ui.course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.owlingo.R
import com.example.owlingo.databinding.ActivityAdminCourseBinding
import com.example.owlingo.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class AdminCourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAdminCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courselistview = findViewById<RecyclerView>(com.example.owlingo.R.id.course_list)

        // Create some dummy course data (replace with real data)
        val dummyCourses = listOf(
            Course(1, "Course 1", "Course 1 Detail"),
            Course(2, "Course 2", "Course 2 Detail")
            // Add more dummy courses
        )

        // Initialize the adapter with the dummy data
        courseAdapter = CourseAdapter(dummyCourses)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = courseAdapter
    }
}
    }


}