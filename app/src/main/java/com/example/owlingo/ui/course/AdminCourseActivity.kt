package com.example.owlingo.ui.course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.owlingo.R
import com.example.owlingo.component.ClickListener
import com.example.owlingo.database.community.Comment
import com.example.owlingo.database.community.Question
import com.example.owlingo.database.course.Course
import com.example.owlingo.databinding.ActivityAdminCourseBinding
import com.example.owlingo.databinding.ActivityMainBinding
import com.example.owlingo.ui.community.CommunityAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Collections.list

class AdminCourseActivity : AppCompatActivity() {

    private lateinit var clickListener: ClickListener
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

        // Inside your activity's onCreate or a relevant method
        val requestQueue = Volley.newRequestQueue(this)
        val urlWithParams = "http://10.0.2.2/Owlingo/courseDAO.php"


        val courseList = mutableListOf<Course>()
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, urlWithParams, null,
            { response ->

                for (i in 0 until response.length()) {
                    val jsonObject = response.getJSONObject(i)
                    val course = Course(
                        course_id = jsonObject.getInt("course_id"),
                        course_name = jsonObject.getString("course_name"),
                        course_detail = jsonObject.getString("course_detail"),
                        course_lecture = jsonObject.getString("course_lecture"),
                        course_fee = jsonObject.getInt("course_fee"),
                        couse_schedule = jsonObject.getString("couse_schedule")
                    )
                    courseList.add(course)
                }

            },
            { error ->
                Toast.makeText(this, "Created Unsucessesful", Toast.LENGTH_SHORT).show()
            }
        )

        requestQueue.add(jsonArrayRequest)

        val courseAdapter = CourseAdapter(clickListener)
        courselistview.layoutManager = LinearLayoutManager(this)
        courselistview.adapter = courseAdapter
        courseAdapter.submitList(courseList)

    }
 }
