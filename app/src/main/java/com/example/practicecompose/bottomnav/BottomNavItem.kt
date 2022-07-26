package com.example.practicecompose.bottomnav

import com.example.practicecompose.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String, var badgeCount: Int = 0){

    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object MyNetwork: BottomNavItem("My Network",R.drawable.ic_group,"my_network")
    object AddPost: BottomNavItem("Post",R.drawable.ic_add,"add_post")
    object Notification: BottomNavItem("Notification",R.drawable.ic_notifications,"notification", 10)
    object Jobs: BottomNavItem("Jobs",R.drawable.ic_job,"jobs")
}