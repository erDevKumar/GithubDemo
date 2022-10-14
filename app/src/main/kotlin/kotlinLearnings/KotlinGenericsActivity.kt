package kotlinLearnings

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.erkumardevender.githubdemo.R
import com.erkumardevender.githubdemo.databinding.ActivityKotlinGenericsBinding

class KotlinGenericsActivity:AppCompatActivity() {

    private lateinit var binding:ActivityKotlinGenericsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_kotlin_generics)

        setTommyClick()
        setSunilClick()
    }

    private fun setTommyClick(){
        binding.tommy.setOnClickListener {
            Species<Dog>(Dog("tommy"))
        }
    }

    private fun setSunilClick(){
        binding.sunil.setOnClickListener {
            Species(Human("Sunil"))
        }
    }




    inner class Species<SpeciesType:Any>(type:SpeciesType){
        //<SpeciesType:Any> was needed because we want to show "SpeciesType" as non null
        init{
                Toast.makeText(this@KotlinGenericsActivity,"This is a:"+type.javaClass.simpleName/*+" named as"*/, Toast.LENGTH_SHORT).show()
                //above line shows how we refer to context/activity that is parent
        }
    }

    inner class Dog(val name:String)
    inner class Human(name:String)

}