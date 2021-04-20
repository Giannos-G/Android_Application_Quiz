package project1.quiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_categories.*

class Categories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

      val team1 = intent.getSerializableExtra("Team1") as Team
      val team2 = intent.getSerializableExtra("Team2") as Team

        //Home Button
        val home_button = findViewById<Button>(R.id.homepage)
        home_button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Playing Team Title
        val playing_team_title = findViewById<TextView>(R.id.PlayingTeam)
        if (team1.isPlaying == true ) playing_team_title.text = (" " + team1.teamname + " ")
        else playing_team_title.text = (" " + team2.teamname + " ")

        //History Button
        val history_button = findViewById<Button>(R.id.history)
        history_button.setOnClickListener{
            //An paizoun istoria
            if (team1.isPlaying) {
                team1.playingHistory = true
                team1.playingTechnology = false
                team1.playingSports = false
                team1.playingNature = false
                team1.playingArts = false
                team1.playingGeography = false

            }

            else {
                team2.playingHistory = true
                team2.playingTechnology = false
                team2.playingSports = false
                team2.playingNature = false
                team2.playingArts = false
                team2.playingGeography = false
            }

            val intent = Intent(this,Question_and_Answer::class.java)
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
            startActivity(intent)
        }
        //History Score Text
        val history_score_text = findViewById<TextView>(R.id.historyscore)
        if (team1.isPlaying) {
            history_score_text.text = (team1.historyScore.toString() + "/" + team1.correctquestions.toString())
        }
        else if(team2.isPlaying) {
            history_score_text.text = (team2.historyScore.toString() + "/" + team2.correctquestions.toString())
        }

        //Geography Button
        geography.setOnClickListener{
            //An paizoun geographia
            if (team1.isPlaying == true) {
                team1.playingHistory = false
                team1.playingTechnology = false
                team1.playingSports = false
                team1.playingNature = false
                team1.playingArts = false
                team1.playingGeography = true
            }
            else {
                team2.playingHistory = false
                team2.playingTechnology = false
                team2.playingSports = false
                team2.playingNature = false
                team2.playingArts = false
                team2.playingGeography = true
            }
            val intent = Intent(this,Question_and_Answer::class.java)
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
            startActivity(intent)
        }
        //Geography Score Text
        val geography_score_text = findViewById<TextView>(R.id.geographyscore)
        if (team1.isPlaying) {
            geography_score_text.text = (team1.geographyScore.toString()+ "/" + team1.correctquestions.toString())
        }
        else if (team2.isPlaying){
            geography_score_text.text = (team2.geographyScore.toString()+ "/" + team2.correctquestions.toString())
        }

        //Arts Button
        art.setOnClickListener{
            //An paizoun texnes
            if (team1.isPlaying == true) {
                team1.playingHistory = false
                team1.playingTechnology = false
                team1.playingSports = false
                team1.playingNature = false
                team1.playingArts = true
                team1.playingGeography = false
            }
            else {
                team2.playingHistory = false
                team2.playingTechnology = false
                team2.playingSports = false
                team2.playingNature = false
                team2.playingArts = true
                team2.playingGeography = false
            }

            val intent = Intent(this,Question_and_Answer::class.java)
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
            startActivity(intent)
        }
        //Arts Score Text
        val arts_score_text = findViewById<TextView>(R.id.artsscore)
        if (team1.isPlaying) {
            arts_score_text.text = (team1.artsScore.toString() + "/" + team1.correctquestions.toString())
        }
        else if(team2.isPlaying){
            arts_score_text.text = (team2.artsScore.toString() + "/" + team2.correctquestions.toString())
        }

        //Nature Button
        nature.setOnClickListener{
            //An paizoun fisi
            if (team1.isPlaying == true) {
                team1.playingHistory = false
                team1.playingTechnology = false
                team1.playingSports = false
                team1.playingNature = true
                team1.playingArts = false
                team1.playingGeography = false
            }
            else {
                team2.playingHistory = false
                team2.playingTechnology = false
                team2.playingSports = false
                team2.playingNature = true
                team2.playingArts = false
                team2.playingGeography = false
            }

            val intent = Intent(this,Question_and_Answer::class.java)
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
            startActivity(intent)
        }
        //Nature Score Text
        val nature_score_text = findViewById<TextView>(R.id.naturescore)
        if (team1.isPlaying) {
            nature_score_text.text = (team1.natureScore.toString() + "/" + team1.correctquestions.toString())
        }
        else if (team2.isPlaying) {
            nature_score_text.text = (team2.natureScore.toString() + "/" + team2.correctquestions.toString())
        }

        //Sports Button
        sports.setOnClickListener{
            //An paizoun sports
            if (team1.isPlaying) {
                team1.playingHistory = false
                team1.playingTechnology = false
                team1.playingSports = true
                team1.playingNature = false
                team1.playingArts = false
                team1.playingGeography = false
            }
            else {
                team2.playingHistory = false
                team2.playingTechnology = false
                team2.playingSports = true
                team2.playingNature = false
                team2.playingArts = false
                team2.playingGeography = false
            }

            val intent = Intent(this,Question_and_Answer::class.java)
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
            startActivity(intent)
        }
        //Sports Score Text
        val sports_score_text = findViewById<TextView>(R.id.sportsscore)
        if (team1.isPlaying) {
            sports_score_text.text = (team1.sportsScore.toString() + "/" + team1.correctquestions.toString())
        }
        else if (team2.isPlaying) {
            sports_score_text.text = (team2.sportsScore.toString() + "/" + team2.correctquestions.toString())
        }

        //Technology Button
        technology.setOnClickListener{
            //An paizoun texnologia
            if (team1.isPlaying) {
                team1.playingHistory = false
                team1.playingTechnology = true
                team1.playingSports = false
                team1.playingNature = false
                team1.playingArts = false
                team1.playingGeography = false
            }
            else {
                team2.playingHistory = false
                team2.playingTechnology = true
                team2.playingSports = false
                team2.playingNature = false
                team2.playingArts = false
                team2.playingGeography = false
            }

            val intent = Intent(this,Question_and_Answer::class.java)
            intent.putExtra("Team1", team1)  //Pernao ta 2 objects
            intent.putExtra("Team2", team2)
            startActivity(intent)
        }
        //Technology Score Text
        val technology_score_text = findViewById<TextView>(R.id.technologyscore)
        if (team1.isPlaying) {
            technology_score_text.text = (team1.technologyScore.toString()+ " / " + team1.correctquestions.toString())
        }
        else if (team2.isPlaying) {
            technology_score_text.text = (team2.technologyScore.toString() + " / " + team2.correctquestions.toString())
        }

        //Elegxos an ftasame sto orio ton soston apantiseon
        if (team1.isPlaying) {
            if (team1.artsScore == team1.correctquestions) {
                art.isEnabled = false
                artsscore.setTextColor(Color.GREEN)
            }
            if (team1.historyScore == team1.correctquestions) {
                history_button.isEnabled = false
                historyscore.setTextColor(Color.GREEN)
            }
            if (team1.technologyScore == team1.correctquestions) {
                technology.isEnabled = false
                technologyscore.setTextColor(Color.GREEN)
            }
            if (team1.natureScore == team1.correctquestions) {
                nature.isEnabled = false
                naturescore.setTextColor(Color.GREEN)
            }
            if (team1.sportsScore == team1.correctquestions) {
                sports.isEnabled = false
                sportsscore.setTextColor(Color.GREEN)
            }
            if (team1.geographyScore == team1.correctquestions) {
                geography.isEnabled = false
                geographyscore.setTextColor(Color.GREEN)
            }
        }

        else {
            if (team2.artsScore == team2.correctquestions) {
                art.isEnabled = false
                artsscore.setTextColor(Color.GREEN)
            }
            if (team2.historyScore == team2.correctquestions) {
                history_button.isEnabled = false
                historyscore.setTextColor(Color.GREEN)
            }
            if (team2.technologyScore == team2.correctquestions) {
                technology.isEnabled = false
                technologyscore.setTextColor(Color.GREEN)
            }
            if (team2.natureScore == team2.correctquestions) {
                nature.isEnabled = false
                naturescore.setTextColor(Color.GREEN)
            }
            if (team2.sportsScore == team2.correctquestions) {
                sports.isEnabled = false
                sportsscore.setTextColor(Color.GREEN)
            }
            if (team2.geographyScore == team2.correctquestions) {
                geography.isEnabled = false
                geographyscore.setTextColor(Color.GREEN)
            }
        }
    }

}