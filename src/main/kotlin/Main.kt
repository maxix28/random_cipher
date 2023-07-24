
package bullscows
import java.util.Random
fun isNumericToX(toCheck: String): Boolean {
    return toCheck.toDoubleOrNull() != null
}
const val SYMBOLS = "0123456789abcdefghijklmnopqrstuvxywz"
class chipher(){
    protected
    val alphabetList = ('a'..'z').map { it.toString() }
    var secret_Code="9305"
    var attemp=""
    var bull=0
    var cows=0
    var turn = 1
    var stop = false
    init{
        println("Please, enter the secret code's length")
        setCode()
        if(!stop) {
            while (true) {
                println("Turn $turn:")
                readAttemt()
                check()
                if (Grade()) {
                    break
                }
                turn++
            }
            println("Congratulations! You guessed the secret code.")
        }
    }
    var digits=""
    fun setCode():Unit{
        stop=false
        var code = ""
        var digits=""
        while (true) {
            digits = readln()
            if( !isNumericToX(digits)){
                println("Error: \"$digits\" isn't a valid number.")
                stop =true
                break
            }
            if (digits.toInt() ==0) {
                println("Error: 0 isn't a valid number.")
                stop =true
                break}
            if (digits.toInt() > 36) {

                println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).")
                stop =true
                break}
            break
        }
        if(!stop){
            var symbol=0
            sembol@ while(true){

                println("Input the number of possible symbols in the code:")
                symbol= readln().toInt()
                if(symbol.toInt()<digits.toInt()){
                    println("Error: it's not possible to generate a code with a length of ${digits} with $symbol unique symbols.")
                    stop =true
                    break@sembol
                }
                if(symbol>36){
                    println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).")
                    stop =true
                    break@sembol

                    break}

                secret_Code=randomNumber(digits.toInt(),symbol)
                println("The secret is prepared: ${"*".repeat(secret_Code.length)} (0-9, a-${alphabetList[Math.abs(symbol-11)]}).")

                println("Okay, let's start a game!")
                break@sembol
            }
        }
    }
    fun readAttemt(){
        attemp= readln()

    }
    fun randomNumber(num: Int, symbols: Int): String {
        var secret = ""
        var number=0
        while (secret.length < num) {

            if(symbols<10){ number = Random().nextInt(symbols)}
            else number = Random().nextInt(symbols)
            val symbol = SYMBOLS[number]

            if (symbol !in secret) {
                secret += symbol
            }
        }
        return secret
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