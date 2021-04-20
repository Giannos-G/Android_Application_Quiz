package project1.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_rules_.*

class Rules_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules_)
        // On Click Listener to Main Activity
        val ok_button = findViewById<Button>(R.id.ok_button)
        ok_button.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java )
            startActivity(intent)
        }
    }
}