package com.skill_factory.unit4

import android.graphics.Rect
import android.os.Bundle
import android.transition.*
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var expanded = false
        val transitionSet = TransitionSet()
            .addTransition(ChangeBounds())
            .addTransition(ChangeImageTransform())

        img.setOnClickListener {
            expanded = !expanded
            TransitionManager.beginDelayedTransition(root, transitionSet)
            val params: ViewGroup.LayoutParams = img.layoutParams
            params.height = if (expanded) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT
            img.layoutParams = params

            img.scaleType = if (expanded) ImageView.ScaleType.CENTER_CROP else ImageView.ScaleType.FIT_CENTER
        }
    }
}
