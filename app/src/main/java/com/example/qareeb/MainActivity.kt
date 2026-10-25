package com.example.qareeb

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // إنشاء واجهة التطبيق برمجياً
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#E0E5EC")) // لون خلفية ناعم (Neumorphism)
            setPadding(50, 50, 50, 50)
        }

        val title = TextView(this).apply {
            text = "قريب - دردشة بلوتوث"
            textSize = 24f
            setTextColor(Color.parseColor("#3E4A59"))
            setPadding(0, 0, 0, 40)
        }

        val chatArea = TextView(this).apply {
            text = "مرحباً بك!\nهذه المرحلة الأولى (الواجهة).\nاكتب رسالة واضغط إرسال."
            textSize = 18f
            setTextColor(Color.BLACK)
            setPadding(30, 30, 30, 30)
            val bg = GradientDrawable().apply {
                setColor(Color.parseColor("#E0E5EC"))
                cornerRadius = 40f
                setStroke(5, Color.parseColor("#FFFFFF"))
            }
            background = bg
        }

        val inputLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, 40, 0, 0)
        }

        val input = EditText(this).apply {
            hint = "اكتب رسالة..."
            setSingleLine()
            setTextColor(Color.BLACK)
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }

        val btn = Button(this).apply {
            text = "إرسال"
            setTextColor(Color.WHITE)
            val bg = GradientDrawable().apply {
                setColor(Color.parseColor("#4A90E2"))
                cornerRadius = 40f
            }
            background = bg
        }

        inputLayout.addView(input)
        inputLayout.addView(btn)

        layout.addView(title)
        layout.addView(chatArea)
        layout.addView(inputLayout)

        setContentView(layout)

        // برمجة زر الإرسال (حالياً يضيف الرسالة في الشاشة فقط)
        btn.setOnClickListener {
            val msg = input.text.toString()
            if (msg.isNotEmpty()) {
                chatArea.append("\n\nأنت: $msg")
                input.text.clear()
            }
        }
    }
}
