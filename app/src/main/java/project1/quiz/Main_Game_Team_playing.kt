package project1.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main__game__team_playing.*
import kotlinx.android.synthetic.main.activity_teams__main_.*

class Main_Game_Team_playing : AppCompatActivity() {
    lateinit var PlayingTeamText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__game__team_playing)

        //Next Button
        val next_button = findViewById<Button>(R.id.next_button)
        next_button.setOnClickListener{ //Show which Team is playing next
            val team1 = intent.getSerializableExtra("Team1") as Team
            val team2 = intent.getSerializableExtra("Team2") as Team
            val intent = Intent(this, Categories::class.java)
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
                startActivity(intent)
        }

        //Home Button
       val home_button = findViewById<Button>(R.id.homepage)
            home_button.setOnClickListener{
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
      }

        val team1 = intent.getSerializableExtra("Team1") as Team
        val team2 = intent.getSerializableExtra("Team2") as Team
        PlayingTeamText = findViewById(R.id.PlayingTeamName)

        if (team1.isPlaying) {
            PlayingTeamText.text = team1.teamname
        }
        else {
            PlayingTeamText.text = team2.teamname
        }
        //Pernao ta classes sto epomeno
        //intent.putExtra("Team1", team1)
        //intent.putExtra("Team2", team2)



    }


}