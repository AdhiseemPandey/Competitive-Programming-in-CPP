fun main(){
    val length = readLine()!!.toInt()
    val str = readLine()!!
    if( length == 1 ){
        println("Yes")
        return
    }

    val count = IntArray(26)
    for( char in str ) count[ char - 'a']++
    for( value in count ) if( value >= 2 ){
        println("Yes")
        return 
    }

    println("No")
}
