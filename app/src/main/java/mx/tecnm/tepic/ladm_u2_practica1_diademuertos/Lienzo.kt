package mx.tecnm.tepic.ladm_u2_practica1_diademuertos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.CountDownTimer
import android.view.View

class Lienzo(pantalla: MainActivity) : View(pantalla) {

    var altura = 0f
    var ancho = 0f
    val pantalla = pantalla
    var esqueleto = Esqueleto()
    var nube1 = Nube( 15f )
    var nube2 = Nube( 40f )
    var nube3 = Nube( 65f )
    var nube4 = Nube( 90f )
    var nube5 = Nube( 115f )
    val hiloEsqueleto = HiloEsqueleto( this )
    val animacionNube = object: CountDownTimer( 1000 , 100 ){
        override fun onTick(p0: Long) {
            nube1.mover()
            nube2.mover()
            nube3.mover()
            nube4.mover()
            nube5.mover()
            invalidate()
        }
        override fun onFinish() {
            start()
        }
    }
    val animacionBrazos = object: CountDownTimer( 3500 , 20 ){
        override fun onTick(p0: Long) {
            esqueleto.moverBrazos()
            invalidate()
        }
        override fun onFinish() {
            if( esqueleto.tocadaRapida == true )
            {
                esqueleto.tocadaRapida = false
                esqueleto.deslizamientoBrazoDer = -0.5f
            }
            else
            {
                esqueleto.tocadaRapida = true
                esqueleto.deslizamientoBrazoDer = -5f
            }
            start()
        }
    }

    init{
        animacionBrazos.start()
        animacionNube.start()
        hiloEsqueleto.start()
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        c.drawColor( Color.rgb( 14 , 19 , 55 ) ) // AZUL OSCURO
        val pincel = Paint()
        altura = c.height + 0f
        ancho = c.width + 0f

        //==============================================================================================
        //                              LUNA
        //==============================================================================================
        pincel.color = Color.WHITE
        c.drawCircle(
            posX(8f , posY(8f , 0f) ) ,
            posY(8f + 8f , 0f) ,
            posY(8f , 0f) ,
            pincel
        )
        pincel.color = Color.rgb( 14 , 19 , 55 )  // AZUL OSCURO
        c.drawOval(
            posX(7f , posY(8f , 0f) ) ,
            posY(8f + 2.25f , 0f) ,
            posX(20f , 0f) ,
            posY(8f + 8f + 8f - 2.35f , 0f) ,
            pincel
        )

        //==============================================================================================
        //                              TIERRA
        //==============================================================================================
        pincel.color = Color.rgb( 115 , 82 , 37 )   // CAFE
        c.drawRect(
            posX(0f , 0f) ,
            posY(95f , 0f) ,
            posX(100f , 0f) ,
            posY(100f , 0f) ,
            pincel
        )


        //==============================================================================================
        //                              ARBOL
        //==============================================================================================
        pincel.color = Color.rgb( 168 , 156 , 93 )   // CAFE LIGERO
        val arbol = Path()
        arbol.moveTo(
            posX(91f , 0f) ,
            posY(95f , 0f) ,
        )
        arbol.lineTo(
            posX(100f , 0f) ,
            posY(95f , 0f) ,
        )
        arbol.lineTo(
            posX(100f , 0f) ,
            posY(60f , 0f) ,
        )
        arbol.lineTo(
            posX(94f , 0f) ,
            posY(60f , 0f) ,
        )
        arbol.lineTo(
            posX(100f - 6f , 0f) ,
            posY(95f - 4f , 0f) ,
        )
        c.drawPath( arbol , pincel )

        // HOJAS
        pincel.color = Color.rgb( 132 , 191 , 97 )   // VERDE LIGERO
        var wHojaI = 94f - 8f  // %
        var wHojaF = wHojaI +8f // %
        c.drawOval(
            posX( wHojaI , 0f ) ,
            posY( 40f , 0f ) ,
            posX( wHojaF , 0f ) ,
            posY( 65f , 0f ) ,
            pincel
        )
        wHojaI = wHojaF - 4f
        wHojaF = wHojaI + 8f
        c.drawOval(
            posX( wHojaI , 0f ) ,
            posY( 40f , 0f ) ,
            posX( wHojaF , 0f ) ,
            posY( 65f , 0f ) ,
            pincel
        )
        wHojaI = wHojaF - 4f
        wHojaF = wHojaI + 8f
        c.drawOval(
            posX( wHojaI , 0f ) ,
            posY( 40f , 0f ) ,
            posX( wHojaF , 0f ) ,
            posY( 65f , 0f ) ,
            pincel
        )
        var hHojaI = 40f + 2f
        var hHojaF = hHojaI + 14f
        c.drawOval(
            posX( 94f - 8f , -8f ) ,
            posY( hHojaI , 0f ) ,
            posX( 92f , 0f ) ,
            posY( hHojaF , 0f ) ,
            pincel
        )
        hHojaI = hHojaF - 6f
        hHojaF = hHojaI + 13f
        c.drawOval(
            posX( 94f - 8f , -8f ) ,
            posY( hHojaI , 0f ) ,
            posX( 92f , 0f ) ,
            posY( hHojaF , 0f ) ,
            pincel
        )




        //==============================================================================================
        //                              NUBES Y ESQUELETO
        //==============================================================================================
        nube1.dibujar( c , pantalla )
        nube2.dibujar( c , pantalla )
        nube3.dibujar( c , pantalla )
        nube4.dibujar( c , pantalla )
        nube5.dibujar( c , pantalla )
        esqueleto.dibujar(c , pantalla )
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


class HiloEsqueleto( lienzo: Lienzo ): Thread() {
    val lienzo = lienzo

    override fun run() {
        super.run()
        while(true) {
            sleep( 8000 )
            lienzo.esqueleto.tumbaActual = 0
            lienzo.pantalla.runOnUiThread {
                lienzo.invalidate()
            }
            sleep( 3000 )
            lienzo.esqueleto.cambiarTumba()
            lienzo.pantalla.runOnUiThread {
                lienzo.invalidate()
            }
        }
    }
}

