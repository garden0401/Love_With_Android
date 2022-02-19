import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomsheettest.R

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            findViewById<Button>(R.id.button).setOnClickListener {
            val bottomSheet = BottomSheetDialog(this)
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }

}