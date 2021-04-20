package project1.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import kotlinx.android.synthetic.main.activity_question_and__answer.*


class Question_and_Answer : AppCompatActivity() {

    private lateinit var timer:CountDownTimer
    private var secondsRemaining = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_and__answer)
        timer_button.setOnClickListener{v->
            startTimer()
        }
        val team1 = intent.getSerializableExtra("Team1") as Team
        val team2 = intent.getSerializableExtra("Team2") as Team

        if (team1.isPlaying) PlayingTeam.text = (" " + team1.teamname + " ")
        else PlayingTeam.text = (" " + team2.teamname + " ")
        // Lathos Apantisi
        val wronganswer = findViewById<Button>(R.id.wrong_button)
        wronganswer.setOnClickListener{
            if (team1.isPlaying) {
                team1.isPlaying = false
                team2.isPlaying = true
            }
            else if (team2.isPlaying){
                team2.isPlaying = false
                team1.isPlaying = true
            }

            val intent = Intent(this,Main_Game_Team_playing::class.java)
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
            startActivity(intent)
        }

        //Sosti Apantisi
        val correctanswer = findViewById<Button>(R.id.correct_button)
        correctanswer.setOnClickListener{
            //Afksisi tou score
            if (team1.isPlaying){
                if (team1.playingArts) team1.artsScore = team1.artsScore+1
                if (team1.playingGeography) team1.geographyScore = team1.geographyScore+1
                if (team1.playingHistory) team1.historyScore = team1.historyScore+1
                if (team1.playingNature) team1.natureScore = team1.natureScore +1
                if (team1.playingSports) team1.sportsScore = team1.sportsScore +1
                if (team1.playingTechnology) team1.technologyScore = team1.technologyScore +1
            }
            else {
                if  (team2.playingArts) team2.artsScore++
                if (team2.playingGeography) team2.geographyScore++
                if (team2.playingHistory) team2.historyScore++
                if (team2.playingNature) team2.natureScore++
                if (team2.playingSports) team2.sportsScore++
                if (team2.playingTechnology) team2.technologyScore++
            }

            // Epanafora stin categories i sto telos
            team1.findTheWinner()
            team2.findTheWinner()

            if (team1.isTheWinner || team2.isTheWinner){
                val intent = Intent(this,Winner_Page::class.java)
                intent.putExtra("Team1", team1)  //Pernao ta 2 objects
                intent.putExtra("Team2", team2)
                startActivity(intent)
            }
            else{
            val intent = Intent(this,Categories::class.java)
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
            startActivity(intent)
            }
        }

    }

    override fun onStart(){
        super.onStart()
        initTimer()
    }
    private fun initTimer(){
        startTimer()
        updateCountdownUI()
    }
    private fun onTimerFinished(){
        updateCountdownUI()
    }
    private fun startTimer(){
        timer = object : CountDownTimer(65 * 1000,1000){
                override fun onFinish(){
                    onTimerFinished()
                    correct_button.isEnabled = false                                       //den mporei o xristis na epileksei to koumpi sosti apanthsh
                }
        override fun onTick(millisUntilFinished: Long) {
            secondsRemaining = millisUntilFinished/1000
            updateCountdownUI()
            }
        }.start()
    }
    @SuppressLint("SetTextI18n")
    private fun updateCountdownUI(){
        val minutesUntilFinished = secondsRemaining/60
        val secondsInMinuteUntilFinished = secondsRemaining - minutesUntilFinished*60
        val secondsStr = secondsInMinuteUntilFinished.toString()
        countdown_text.text = "$minutesUntilFinished:${
        if (secondsStr.length == 2) secondsStr
        else "0$secondsStr"
        }"
    }
}