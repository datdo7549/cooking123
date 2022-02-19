package com.example.cookdiary

import android.app.Activity
import android.content.Context

object SharePreferenceUtils {


    fun getCount(activity: Activity) : Int {
        val sharedPref = activity.getSharedPreferences("COOKY", Context.MODE_PRIVATE) ?: return 0
        val count = sharedPref.getInt("COUNT", 0)
        return count
    }

    fun saveCount(count: Int, activity: Activity) {
        val sharedPref = activity.getSharedPreferences("COOKY", Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putInt("COUNT", count)
            apply()
        }
    }

    fun getRating(id: String, activity: Activity) : Int {
        val sharedPref = activity.getSharedPreferences("COOKY", Context.MODE_PRIVATE) ?: return 0
        val count = sharedPref.getInt(id + "RATING_NUM", 0)
        return count
    }

    fun getComment(id: String, activity: Activity) : String? {
        val sharedPref = activity.getSharedPreferences("COOKY", Context.MODE_PRIVATE) ?: return ""
        val count = sharedPref.getString(id + "COMMENT", "")
        return count
    }

    fun saveRating(id: String, num: Int, comment: String, activity: Activity) {
        val sharedPref = activity.getSharedPreferences("COOKY", Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putInt(id + "RATING_NUM", num)
            putString(id+ "COMMENT", comment)
            apply()
        }
    }

    fun getDish(id: String, activity: Activity): Dish {
        val sharedPref = activity.getSharedPreferences("COOKY", Context.MODE_PRIVATE)
        val name = sharedPref.getString(id + "name", "")

        val step1 = sharedPref.getString(id + "step_1", "")
        val url1 = sharedPref.getString(id + "url_1", "")

        val step2 = sharedPref.getString(id + "step_2", "")
        val url2 = sharedPref.getString(id + "url_2", "")

        val step3 = sharedPref.getString(id + "step_3", "")
        val url3 = sharedPref.getString(id + "url_3", "")

        val step4 = sharedPref.getString(id + "step_4", "")
        val url4 = sharedPref.getString(id + "url_4", "")

        val step5 = sharedPref.getString(id + "step_5", "")
        val url5 = sharedPref.getString(id + "url_5", "")

        return Dish(id, name, step1, url1, step2, url2, step3, url3, step4, url4, step5, url5)
    }

    fun getListDish(count: Int, activity: Activity) : ArrayList<Dish>{
        val sharedPref = activity.getSharedPreferences("COOKY", Context.MODE_PRIVATE)
        val list = arrayListOf<Dish>()
        for (i in 1..count) {
            val id = sharedPref.getString("mon_$i", "")
            val name = sharedPref.getString(id + "name", "")

            val step1 = sharedPref.getString(id + "step_1", "")
            val url1 = sharedPref.getString(id + "url_1", "")

            val step2 = sharedPref.getString(id + "step_2", "")
            val url2 = sharedPref.getString(id + "url_2", "")

            val step3 = sharedPref.getString(id + "step_3", "")
            val url3 = sharedPref.getString(id + "url_3", "")

            val step4 = sharedPref.getString(id + "step_4", "")
            val url4 = sharedPref.getString(id + "url_4", "")

            val step5 = sharedPref.getString(id + "step_5", "")
            val url5 = sharedPref.getString(id + "url_5", "")

            val dish = Dish(id, name, step1, url1, step2, url2, step3, url3, step4, url4, step5, url5)
            list.add(dish)
        }
        return list
    }

    fun addDish(id: String, name: String, step_1: String, url1: String,
                step_2: String, url2: String,
                step_3: String, url3: String,
                step_4: String, url4: String,
                step_5: String, url5: String,activity: Activity) {
        val sharedPref = activity.getSharedPreferences("COOKY", Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(id, id)
            putString(id+ "name", name)

            putString(id+ "step_1", step_1)
            putString(id+ "url_1", url1)

            putString(id+ "step_2", step_2)
            putString(id+ "url_2", url2)

            putString(id+ "step_3", step_3)
            putString(id+ "url_3", url3)

            putString(id+ "step_4", step_4)
            putString(id+ "url_4", url4)

            putString(id+ "step_5", step_5)
            putString(id+ "url_5", url5)
            apply()
        }
    }
}