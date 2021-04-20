package project1.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_winner__page.*

class Winner_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner__page)
        val team1 = intent.getSerializableExtra("Team1") as Team
        val team2 = intent.getSerializableExtra("Team2") as Team
        if (team1.isTheWinner) WinnerTeam_text.text = (" " + team1.teamname + "")
        if (team2.isTheWinner) WinnerTeam_text.text = (" " + team2.teamname + "")
        Score_Team1.text = (" " + team1.sum + " ")
        Score_Team2.text = (" " + team2.sum + " ")
        Team1_text.text = (" " + team1.teamname + " ")
        Team2_text.text = (" " + team2.teamname + " ")

        val homepagebutton = findViewById<Button>(R.id.homepage)
        homepagebutton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}