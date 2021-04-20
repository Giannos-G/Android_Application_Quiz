package project1.quiz

import android.content.Context
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_teams__main_.*
import java.io.Serializable

class Team (var teamname: String):Serializable {
    var historyScore: Int = 0
    var geographyScore: Int = 0
    var artsScore: Int = 0
    var technologyScore: Int = 0
    var sportsScore: Int = 0
    var natureScore: Int = 0
    var isPlaying: Boolean = false

    var difficulty: Int = 0
    var correctquestions: Int =0
    private var sumofcorrectquestions: Int = 0

    var playingHistory: Boolean = false
    var playingSports: Boolean = false
    var playingArts: Boolean = false
    var playingTechnology: Boolean = false
    var playingNature: Boolean = false
    var playingGeography: Boolean = false

    var sum =0
    var isTheWinner:Boolean = false

    fun findTheWinner(){
        sum = historyScore + geographyScore + artsScore + sportsScore + natureScore + technologyScore
        sumofcorrectquestions = 6*correctquestions
        if (sum == sumofcorrectquestions) isTheWinner = true
    }


}

