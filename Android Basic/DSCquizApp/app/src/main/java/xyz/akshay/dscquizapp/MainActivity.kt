package xyz.akshay.dscquizapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var score = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener{
            start_game()
        }

        submit.setOnClickListener{
                check_answer()
        }
    }

    fun check_answer() {
        val check = checkAtLeastOneCheckBoxSelected()
        when(check) {
            true -> {
                val check_rg = checkRadioButtonSelected()
                    when(check_rg){
                        true -> {
                            showMessage(resources.getString(R.string.toast_alert))
                        }
                        false -> {
                            score = 0

                            if(option1_a.isChecked && option1_b.isChecked && option1_d.isChecked)
                                score+=5;
                            else if(option1_a.isChecked || option1_b.isChecked || option1_d.isChecked)
                                score+=2;

                            if (rg_ques2.getCheckedRadioButtonId() == R.id.option2_d)
                                score += 5;
                            if (rg_ques3.getCheckedRadioButtonId() == R.id.option3_d)
                                score += 5;
                            if (rg_ques4.getCheckedRadioButtonId() == R.id.option4_a)
                                score += 5;
                            if (rg_ques5.getCheckedRadioButtonId() == R.id.option5_a)
                                score += 5;

                            if(answer6.getText().toString().trim().toLowerCase().replace(" ","").equals("goa"))
                                score+=5;

                            showMessage(score.toString())
                            result.text = resources.getString(R.string.answers)
                            result.visibility = View.VISIBLE
                        }
                    }
            }
            false -> {showMessage(resources.getString(R.string.toast_alert))}
        }
    }

    fun checkRadioButtonSelected(): Boolean {
        return (rg_ques2.getCheckedRadioButtonId()== -1 || rg_ques3.getCheckedRadioButtonId()== -1 ||
                rg_ques4.getCheckedRadioButtonId()== -1 || rg_ques5.getCheckedRadioButtonId()== -1 ||
                answer6.getText().toString().trim().isEmpty())
    }

    fun checkAtLeastOneCheckBoxSelected() :Boolean {
        return (option1_a.isChecked || option1_b.isChecked || option1_c.isChecked || option1_d.isChecked)
    }

    fun showMessage(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    fun start_game(){

        if (et_name!!.text.toString().trim { it <= ' ' }.isEmpty()) {
            showMessage("Enter the Player Name")
        } else {
            welcome_name.text = et_name.text.toString()

            btn_start.visibility = View.GONE
            et_name.visibility = View.GONE
            tv_detail.visibility = View.GONE

            welcome_name.visibility = View.VISIBLE
            show_game.visibility = View.VISIBLE
        }
    }

}

