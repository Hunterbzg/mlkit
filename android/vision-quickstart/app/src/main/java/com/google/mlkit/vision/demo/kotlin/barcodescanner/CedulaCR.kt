package com.google.mlkit.vision.demo.kotlin.barcodescanner

class CedulaCR {

    private companion object {
        val keysArray = byteArrayOf(
            0x27,
            0x30,
            0x04,
            0xA0.toByte(),
            0x00,
            0x0F,
            0x93.toByte(),
            0x12,
            0xA0.toByte(),
            0xD1.toByte(),
            0x33,
            0xE0.toByte(),
            0x03,
            0xD0.toByte(),
            0x00,
            0xDf.toByte(),
            0x00
        )
    }

    fun parse(raw: ByteArray): Persona? {
        val d = StringBuilder()
        var j = 0
        for (i in raw.indices) {
            if (j == 17) {
                j = 0
            }
            val c = (keysArray[j].toInt() xor raw[i].toInt()).toChar()
            if (c.isLetterOrDigit()) {
                d.append(c)
            } else {
                d.append(' ')
            }
            j++
        }

        val p = Persona()
        try {
            p.cedula = d.substring(0, 9).trim()
            p.apellido1 = d.substring(9, 35).trim()
            p.apellido2 = d.substring(35, 61).trim()
            p.nombre = d.substring(61, 91).trim()
            p.genero = d.get(91)
            p.fechaNacimiento =
                d.substring(92, 96) + "-" + d.substring(96, 98) + "-" + d.substring(98, 100)
            p.fechaVencimiento =
                d.substring(100, 104) + "-" + d.substring(104, 106) + "-" + d.substring(106, 108)
        } catch (e: Exception) {
            return null
        }
        return p
    }
}