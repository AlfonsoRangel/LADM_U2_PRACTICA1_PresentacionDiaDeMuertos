package mx.tecnm.tepic.ladm_u2_practica1_diademuertos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Nube( xi: Float ) {

    var xi = xi
    var altura = 0f
    var ancho = 0f

    fun mover( )
    {
        xi -= 0.1f
        if( xi < -25f ){ xi = 100f  }
    }

    fun dibujar(c: Canvas, pantalla: MainActivity )
    {
        altura = c.height + 0f
        ancho = c.width + 0f
        val pincel = Paint()
        pincel.color = Color.rgb( 158 , 198 , 193 )   // AZUL LIGERO
        c.drawOval(
            posX( xi , 10f ) ,
            posY( 5f , 0f ) ,
            posX( xi + 7f , 0f ) ,
            posY( 28f , 0f ) ,
            pincel
        )
        c.drawOval(
            posX( xi + 7f - 3f , 0f ) ,
            posY( 5f , 0f ) ,
            posX( xi + 7f - 3f + 7f , 0f ) ,
            posY( 28f , 0f ) ,
            pincel
        )
        c.drawOval(
            posX( xi + 7f - 3f + 7f - 3f , 0f ) ,
            posY( 5f , 0f ) ,
            posX( xi + 7f - 3f + 7f - 3f + 7f , 0f ) ,
            posY( 28f , 0f ) ,
            pincel
        )
        c.drawOval(
            posX( xi , 0f ) ,
            posY( 7f , 0f ) ,
            posX( xi + 7f - 3f + 7f - 3f + 7f , 10f ) ,
            posY( 17f , 0f ) ,
            pincel
        )
        c.drawOval(
            posX( xi , 0f ) ,
            posY( 11f , 0f ) ,
            posX( xi + 7f - 3f + 7f - 3f + 7f , 10f ) ,
            posY( 22f , 0f ) ,
            pincel
        )
        c.drawOval(
            posX( xi , 0f ) ,
            posY( 16f , 0f ) ,
            posX( xi + 7f - 3f + 7f - 3f + 7f , 10f ) ,
            posY( 27f , 0f ) ,
            pincel
        )
    }


    fun posX( porcentajeDeseado: Float , desplazamiento: Float ): Float
    {
        return ancho * porcentajeDeseado / 100 + desplazamiento
    }


    fun posY( porcentajeDeseado: Float , desplazamiento: Float ): Float
    {
        return altura * porcentajeDeseado / 100  + desplazamiento
    }
}