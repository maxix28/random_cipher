package bullscows
import kotlin.random.Random
class chipher(){
    protected
    var secret_Code="9305"
    var attemp=""
    var bull=0
    var cows=0
    var turn = 1
    init{
        println("Please, enter the secret code's length")
        setCode()
        while (true){
            println("Turn $turn:")
            readAttemt()
            check()
            if(  Grade()){
                break
            }
            turn++
        }
        println("Congratulations! You guessed the secret code.")

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
        println("Okay, let's start a game!")
    }
    fun readAttemt(){
        attemp= readln()

    }
    fun check(){

        bull=0
        cows=0
        for ( i in 0..secret_Code.length-1){
            if(secret_Code[i] in attemp){
                cows++
            }
            if(secret_Code[i]==attemp[i]){
                bull++
                cows--
            }

        }}
    fun Grade():Boolean{
        var win = false
        if(bull==0&&cows==0){
            println("Grade: None")
        }
        else if(cows==0){
            println("Grade: $bull bull(s)")

        }
        else if(bull==0){
            println("Grade:$cows cow(s)")

        }
        else{
            println("Grade: $bull bull(s) and $cows cow(s)")
        }
        if(bull==secret_Code.length){
            win =true
        }
        if(win){
            return true
        }
        else return false

    }
}
fun main() {
    val game = chipher()
}