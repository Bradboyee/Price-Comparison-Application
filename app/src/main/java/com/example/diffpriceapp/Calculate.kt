package com.example.diffpriceapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.calculate.*
import kotlinx.android.synthetic.main.layout_list_item.*


class Calculate : AppCompatActivity() {
    private lateinit var realm: Realm
    private lateinit var product: Product
    var e1: EditText? = null
    var e2: EditText? = null
    var topic: EditText? = null
    var pAname: EditText? = null
    var pBsize: EditText? = null
    var pAsize: EditText? = null
    var pBname: EditText? = null
    var t1: TextView? = null
    var num1 = 0
    var num2 = 0
    var sizea =0
    var sizeb =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculate)
        realm = Realm.getDefaultInstance()


        saveButton.setOnClickListener {
            val student = Product(
                this.Product_topic.text.toString(),
                this.productA.text.toString(),
                this.productB.text.toString(),
                this.sizeA.text.toString(),
                this.sizeB.text.toString(),
                this.e1!!.text.toString(),
                this.e2!!.text.toString(),
                this.t1!!.text.toString())

            realm.executeTransaction{
                realm.insertOrUpdate(student)
            }
            finish()
        }


    }// converting string to int.


    // converting string to int.
// defining the edit text 1 to e1

    // defining the edit text 2 to e2

    // defining the text view to t1

    // taking input from text box 1

    // taking input from text box 2

    // condition to check if box is not empty
    // a public method to get the input numbers
    val numbers: Boolean
        get() {

            // defining the edit text 1 to e1
            e1 = findViewById<View>(R.id.priceAedit) as EditText

            // defining the edit text 2 to e2
            e2 = findViewById<View>(R.id.priceBedit) as EditText

            // defining the text view to t1
            t1 = findViewById<View>(R.id.resultedit) as TextView

            //***
            pAname = findViewById<View>(R.id.productA) as EditText
            pBname = findViewById<View>(R.id.productB) as EditText
            pAsize = findViewById<View>(R.id.sizeA) as EditText
            pBsize = findViewById<View>(R.id.sizeB) as EditText
            topic = findViewById<(View)>(R.id.Product_topic) as EditText


            //***

            // taking input from text box 1
            val s1 = e1!!.text.toString()

            // taking input from text box 2
            val s2 = e2!!.text.toString()
            //***
            val s3 = pAsize!!.text.toString()
            val s4 = pBsize!!.text.toString()
            val s5 = productA.getText().toString()
            val s6 = productB.getText().toString()
            val s7 = Product_topic.getText().toString()


            //***

            // condition to check if box is not empty
            if (s1 == null || s2 == null || s3==null || s4==null || s5==null || s6==null || s7==null
                || s1 == "" || s2 == "" || s3=="" || s4=="" || s5=="" || s6=="" || s7==""
            ) {
                val result = "โปรดป้อนข้อมูล"
                t1!!.text = result
                return false
            } else {
                // converting string to int.
                num1 = s1.toInt()

                // converting string to int.
                num2 = s2.toInt()
                //*
                sizea = s3.toInt()
                sizeb = s4.toInt()

            }
            return true
        }






    // a public method to perform modulus function
    fun doMod(v: View?) {

        // get the input numbers
        if (numbers) {
            num1 = num1/sizea
            num2 = num2/sizeb
            val diff = Math.abs(num1 - num2)
            val full = Math.max(num1, num2)
            val cheap = Math.min(num1, num2)
            val sum = diff.toDouble() / full * 100
            var cheapproduct: String ?= null
            if(cheap==num2){
            cheapproduct = productB.getText().toString()}else{cheapproduct = productA.getText().toString()}

            t1!!.text = "product "+cheapproduct+" is cheapper "+java.lang.Double.toString(sum)+" %"
        }
    }
    companion object {
        const val EXTRA_STUDENT_ID = "EXTRA_STUDENT_ID"
    }



}

