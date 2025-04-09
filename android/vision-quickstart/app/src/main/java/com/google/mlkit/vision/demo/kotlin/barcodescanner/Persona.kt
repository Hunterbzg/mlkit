package com.google.mlkit.vision.demo.kotlin.barcodescanner

data class Persona(
    var cedula: String = "",
    var nombre: String = "",
    var apellido1: String = "",
    var apellido2: String = "",
    var genero: Char = 'N',
    var fechaNacimiento: String = "",
    var fechaVencimiento: String = ""
) {

    override fun toString(): String = buildString {
        append(cedula)
        append(" ")
        append(apellido1)
        append(" ")
        append(apellido2)
        append(" ")
        append(nombre)
        append(" ")
        append(fechaNacimiento)
        append(" ")
        append(fechaVencimiento)
    }
}
