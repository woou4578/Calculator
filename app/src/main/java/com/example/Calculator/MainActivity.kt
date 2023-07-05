package com.example.Calculator

//import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.Calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var op: String = ""
    private var usedOp: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.btnA.setOnClickListener {
//            val intent = Intent(this, SubActivity::class.java) // 다음 화면 이동 위한 인텐트 객체 생성
//            intent.putExtra("msg", binding.tvSendMsg.text.toString()) // hello world 넘겨짐 msg 라는 키로
//            startActivity(intent)
//        }
//        setContentView(R.layout.activity_main)

    }

    fun buttonClicked(v: View) {

        when (v.id) {
            R.id.btn_0 -> binding.inputValue.append("0")
            R.id.btn_1 -> binding.inputValue.append("1")
            R.id.btn_2 -> binding.inputValue.append("2")
            R.id.btn_3 -> binding.inputValue.append("3")
            R.id.btn_4 -> binding.inputValue.append("4")
            R.id.btn_5 -> binding.inputValue.append("5")
            R.id.btn_6 -> binding.inputValue.append("6")
            R.id.btn_7 -> binding.inputValue.append("7")
            R.id.btn_8 -> binding.inputValue.append("8")
            R.id.btn_9 -> binding.inputValue.append("9")

            R.id.btn_add -> {
                if(usedOp) {
                    Toast.makeText(this, "연산자는 1번만 가능합니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                binding.inputValue.append("+")
                op = "+"
                usedOp = true
            }
            R.id.btn_minus -> {
                if(usedOp) {
                    Toast.makeText(this, "연산자는 1번만 가능합니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                binding.inputValue.append("-")
                op = "-"
                usedOp = true
            }
            R.id.btn_mul -> {
                if(usedOp) {
                    Toast.makeText(this, "연산자는 1번만 가능합니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                binding.inputValue.append("*")
                op = "*"
                usedOp = true
            }
            R.id.btn_div -> {
                if(usedOp) {
                    Toast.makeText(this, "연산자는 1번만 가능합니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                binding.inputValue.append("/")
                op = "/"
                usedOp = true
            }
        }
    }

    fun resultButtonClicked(v: View) {
        val expressionTexts = binding.inputValue.text
        var opIdx: Int = -1
        for (i in 0..expressionTexts.length-1 )
            when(expressionTexts[i]) {
                '+', '-', '*', '/' -> {
                    opIdx = i
                    break
                }
            }
        val firstVal = expressionTexts.substring(0 until opIdx)
        val opVal = expressionTexts.substring(opIdx until opIdx+1)
        val secondVal = expressionTexts.substring(opIdx+1)
        var result: Int = -1
        var divError = false
        when(opVal) {
            "+" -> result = firstVal.toInt() + secondVal.toInt()
            "-" -> result = firstVal.toInt() - secondVal.toInt()
            "*" -> result = firstVal.toInt() * secondVal.toInt()
            "/" -> {
                if(secondVal.toInt() == 0) {
                    divError = true
                }else {
                    result = firstVal.toInt() / secondVal.toInt()
                }
            }
        }
        if(divError) {
            binding.outputValue.setText("Infinity")
        }else {
            binding.outputValue.setText(result.toString())
        }
    }

    fun clearButtonClicked(v: View) {
        usedOp = false
        binding.inputValue.setText("");
        binding.outputValue.setText("");
    }
}