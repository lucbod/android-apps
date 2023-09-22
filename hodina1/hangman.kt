//import na spracovanie suborov
import java.io.File

val hangman = listOf("""
_______
|      |
|      O
|     /|\
|     / \
|____________

""".trimIndent(),
"""
_______
|      |
|      O
|     /|\
|     / 
|____________

""".trimIndent(),
"""
_______
|      |
|      O
|     /|\
|     
|____________

""".trimIndent(),
"""
_______
|      |
|      O
|     /|
| 
|____________

""".trimIndent(),
"""
_______
|      |
|      O
|     /
|     
|____________

""".trimIndent(),
"""
_______
|      |
|      O
|     
|     
|____________

""".trimIndent(),
"""
_______
|      |
|      
|     
|     
|____________

""".trimIndent(),
"""
_______
|      
|      
|     
|     
|____________

""".trimIndent(),
"""

|      
|     
|     
|     
|____________

""".trimIndent())

fun main(){
    val word = File("words.txt").readLines().random()
    var status = ".".repeat(word.length).toCharArray()
    var life = hangman.lastIndex

    println(word)
    println(status)
    println(life)

    while(life>0 && String(status)!= word){
        println(hangman[life])
        println(status)

        var input = readLine()!!
        println(input)
        life--

        if(input.length >1){
            if(input==word){
                status = input.toCharArray()
            }else life--
        }else if(input in word) { //hladane pismeno je v slove
            word.forEachIndexed{ index, c->
                if(c in input){
                    status[index] = c
                }
            }
        }else life --
    }
    if(life>0)println("Hra ukoncena,vyhral si")
    else println("Hra ukoncena, prehral si. Slovo bolo $word")
}