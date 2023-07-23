package bullscows
import kotlin.random.Random
class chipher(){
    protected
    var secret_Code="9305"
    var attemp=""
    var bull=0
    var cows=0
    var pseudoRandomNumber = System.nanoTime()
    init{

        setCode()
        //readAttemt()
        // check()
        //  Grade()
    }
    fun setCode(){
        var code = ""
        while (true) {
            var digits = readln().toInt()
            if (digits > 10) {
                println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.")
                break}
            var rnd = 0L
            while (code.length < digits) {
                if (rnd < 1) rnd = System.nanoTime()
                val digit = (rnd % 10).toString().also { rnd /= 10 }
                if (code.isEmpty() && digit == "0" || digit in code) continue
                code += digit
            }
            break
        }
        secret_Code= code
        println("The random secret number is $secret_Code.")
    }
    fun readAttemt(){
        attemp= readln()

    }
    fun check(){
        bull=0
        cows=0
        for ( i in 0..3){
            if(secret_Code[i] in attemp){
                cows++
            }
            if(secret_Code[i]==attemp[i]){
                bull++
                cows--
            }

        }}
    fun Grade(){
        if(bull==0&&cows==0){
            println("Grade: None. The secret code is $secret_Code.")
        }
        else if(cows==0){
            println("Grade: $bull bull(s). The secret code is $secret_Code.")

        }
        else if(bull==0){
            println("Grade:$cows cow(s). The secret code is $secret_Code.")

        }
        else{
            println("Grade: $bull bull(s) and $cows cow(s). The secret code is $secret_Code.")
        }
    }
}
fun main() {
    val game = chipher()
}