package project1.quiz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Rules Button
        val Rules_Button = findViewById<Button>(R.id.Rules_Button) //Rules Button Implementation
        Rules_Button.setOnClickListener{
            val intent = Intent(this, Rules_Activity::class.java)
            startActivity(intent)
        }

        //Adds Button
        val Adds_Button = findViewById<Button>(R.id.Adds_Button) //Rules Button Implementation
        Adds_Button.setOnClickListener{
            val intent = Intent(this, No_More_Adds_Activity::class.java)
            startActivity(intent)
        }

        //Rate Us Button
        val Rate_Us_Button = findViewById<Button>(R.id.Rate_Us_Button) //Rate Us Button Implementation
        Rate_Us_Button.setOnClickListener{
            val intent = Intent(this, RateUs::class.java)
            startActivity(intent)
        }

        //Start Button
        val Start_Button = findViewById<Button>(R.id.Start_Button) //Start Button Implementation
        Start_Button.setOnClickListener{
            val intent = Intent(this, Teams_Main_Activity::class.java)
            startActivity(intent)
        }

        //Exit Button
        Exit_Button.setOnClickListener{

            val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)
            builder.setTitle("Έξοδος")
            builder.setIcon(R.drawable.ic_action_warning)
            builder.setMessage("Επιθυμείτε έξοδο απο την εφαρμογή;")
            builder.setPositiveButton("Ναι"){ dialog, which ->
                finish()
                System.exit(0)
            }
            builder.setNegativeButton("Όχι"){ dialog, which ->  }
            val dialog : AlertDialog = builder.create()
            dialog.show()
        }
    }
}