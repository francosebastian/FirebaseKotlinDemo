package francosebastian.firebasekotlindemo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var editTextName : EditText
    lateinit var ratingBar: RatingBar
    lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        ratingBar = findViewById(R.id.ratingBar)
        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener({
            saveHero()
        })
    }

    private fun saveHero() {
        val name = editTextName.text.toString().trim()

        if(name.isEmpty()){
            editTextName.error = "Please enter a name"
            return
        }
        val ref = FirebaseDatabase.getInstance().getReference("heroes")
        val heroId= ref.push().key
        val hero = Hero(heroId, name, ratingBar.numStars)

        ref.child(heroId).setValue(hero).addOnCompleteListener{
            Toast.makeText(applicationContext, "Hero saved successfully", Toast.LENGTH_LONG).show()
        }



    }
}
