package project1.quiz

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_teams__main_.*

class Teams_Main_Activity : AppCompatActivity() {
    internal lateinit var questionmark : Button
    internal lateinit var myDialog: Dialog
    internal lateinit var txt : TextView

    var counterforTeam1Text = false // flag to be sure that both texts have been filled
    var counterforTeam2Text = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams__main_)

        //Back Button
        val back_button = findViewById<Button>(R.id.back_button)
        back_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Question Mark Button
        questionmark = findViewById<View>(R.id.questionmark) as Button
        questionmark.setOnClickListener {
            ShowDialog()
        }

        Team1_in.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                if (Team1_in.text.toString().trim().isEmpty()) {
                    this@Teams_Main_Activity.counterforTeam1Text = true
                }
                next_button.isEnabled=true

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (Team1_in.text.toString().trim().isEmpty()) {
                    this@Teams_Main_Activity.counterforTeam1Text = true
                }
                next_button.isEnabled=true
            }

            override fun afterTextChanged(s: Editable?) {
                if (Team1_in.text.toString().trim().isEmpty()) {
                    this@Teams_Main_Activity.counterforTeam1Text = true
                }
                next_button.isEnabled=true
            }

        })

        Team2_in.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                if (Team2_in.text.toString().trim().isEmpty()) {
                    this@Teams_Main_Activity.counterforTeam2Text = true
                }
                next_button.isEnabled=true
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (Team2_in.text.toString().trim().isEmpty()) {
                    this@Teams_Main_Activity.counterforTeam2Text = true
                }
                next_button.isEnabled=true
            }

            override fun afterTextChanged(s: Editable?) {
                if (Team2_in.text.toString().trim().isEmpty()) {
                    this@Teams_Main_Activity.counterforTeam2Text = true
                }
                next_button.isEnabled = true
            }

        })

        //Next Button
        val nextbutton = findViewById<Button>(R.id.next_button)
        nextbutton.setOnClickListener {
            //Create the two teams
            val team1name = Team1_in.text.toString()
            val team2name = Team2_in.text.toString()
            val team1 = Team(team1name)
            team1.isPlaying = true      //Paizei proti i omada 1
            val team2 = Team(team2name)

            // Game Details
            // Difficulty
            val seekdiff = findViewById<SeekBar>(R.id.Difficulty_Choice)
            seekdiff.max = 2                   // 0-2
            seekdiff.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    next_button.isEnabled=true
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    next_button.isEnabled=true
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    next_button.isEnabled=true
                }
            })

            //Number of correct questions
            val seekquestions = findViewById<SeekBar>(R.id.question_choice_seekbar)
            seekquestions.max = 3 //0-3
            seekquestions.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    next_button.isEnabled=true
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    next_button.isEnabled=true
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    next_button.isEnabled=true
                }
            })

            //Pernao ti diskolia kai ton arithmo erotiseon stis klaseis
            // Dyskolia
            team1.difficulty = seekdiff.progress
            team2.difficulty = seekdiff.progress
            // Erotiseis
            team1.correctquestions = seekquestions.progress
            team1.correctquestions++
            team2.correctquestions = seekquestions.progress
            team2.correctquestions++

            if (counterforTeam1Text) {
                Team1_in.setText("Ομαδα 1")
                team1.teamname = ("Ομάδα 1")
            }
            if (counterforTeam2Text) {
                Team2_in.setText("Ομαδα 2")
                team2.teamname = ("Ομάδα 2")
            }

            val intent = Intent(this, Main_Game_Team_playing::class.java) //Next Activity
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
            startActivity(intent)
            // finish()
            // //PREPEI NA MPEI SE OLA---????????
        }

        // Check for the text of Teams to be filled


    }

    fun ShowDialog(){
        myDialog = Dialog(this)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        myDialog.setContentView(R.layout.dialog_activity)
        txt = myDialog.findViewById<View>(R.id.button_ok) as TextView
        txt.isEnabled = true
        txt.setOnClickListener{
            myDialog.cancel()
        }
       myDialog.show()
    }
}

