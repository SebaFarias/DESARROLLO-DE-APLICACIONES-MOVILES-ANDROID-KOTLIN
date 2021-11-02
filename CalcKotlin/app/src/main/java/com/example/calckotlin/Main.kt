package com.example.calckotlin

import java.lang.ArithmeticException

fun main()
{
    var continuar = true
    var num1 : Int
    var num2 : Int
    var opcion : Int

    do{
        println("Bienvenido a la calculadora de SebaFarias")
        println("Comenzaremos por el primer operando")
        num1 = askInt()
        println("Ahora, el segundo operando")
        num2 = askInt()
        opcion = askOption()
        operar( opcion, num1, num2 )
        continuar = askContinuar()
    }while (continuar)
    despedida()
}
fun operar( opcion : Int, num1: Int, num2: Int )
{
    when(opcion){
        1 -> { suma( num1, num2 ) }
        2 -> { resta( num1, num2 ) }
        3 -> { multiplicacion( num1, num2 ) }
        4 -> { division( num1, num2 ) }
        5 -> { mayor(num1, num2 ) }
        6 -> { menor(num1, num2 ) }
        else -> { println("Opción no válida") }
    }
}
fun askInt() : Int
{
    println("Ingrese un numero entero")
    try{
        var numero = readLine()?.toInt()
        return numero ?: 0
    }catch (err: Exception){
        println("Número no válido. Valor ingresado: 0")
        return 0
    }

}
fun suma( num1 : Int, num2 : Int )
{
  println("${num1} + ${num2} = ${num1 + num2}")
}
fun resta( num1 : Int, num2 : Int )
{
    println("${num1} - ${num2} = ${num1 - num2}")
}
fun multiplicacion( num1 : Int, num2 : Int )
{
    println("${num1} * ${num2} = ${num1 * num2}")
}
fun division ( num1 : Int, num2 : Int )
{
    try {
        println("${num1} / ${num2} = ${num1 / num2}")
    } catch (err: ArithmeticException) {
        println("No se puede dividir por 0")
    }
}
fun mayor( num1: Int, num2: Int)
{
    if( num1 == num2 ){
        println("${num1} es igual a ${num2}")
        return
    }
    println("${Math.max(num1,num2)} es mayor a ${Math.min(num1,num2)}.")
}
fun menor( num1: Int, num2: Int)
{
    if( num1 == num2 ){
        println("${num1} es igual a ${num2}")
        return
    }
    println("${Math.min(num1,num2)} es menor que ${Math.max(num1,num2)}.")
}
fun askOption() : Int
{
    println("Seleccione una operación:")
    println("(1) Sumar                Restar (2)")
    println("(3) Multiplicar         Dividir (4)")
    println("(5) Mayor                 Menor (6)")
    try{
        return readLine()!!.toInt()
    }catch (er  : Exception ){
        println("Opción no válida")
        return askOption()
    }
}
fun askContinuar() : Boolean
{
    try{
        println("Desea Continuar?")
        println("(S)í  /  (N)o")
        var respuesta = readLine()
        if(respuesta == null) respuesta == " "
        return (respuesta?.get(0) == 'S' || respuesta?.get(0)  == 's')
    }catch (err : Exception){
        return false
    }
}
fun despedida()
{
    println("Adiós. Hasta la Próxima")
}