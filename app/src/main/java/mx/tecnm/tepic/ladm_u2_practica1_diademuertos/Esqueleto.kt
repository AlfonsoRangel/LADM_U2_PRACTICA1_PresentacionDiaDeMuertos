package mx.tecnm.tepic.ladm_u2_practica1_diademuertos

import android.graphics.*
import android.widget.Toast


class Esqueleto {

    var altura = 0f
    var ancho = 0f
    var tumbaActual = 1
    var tumbaAnterior = 1
    var xi = 0

    var tocadaRapida = false
    var desfaseBrazoIzq = 0f  // %
    var brazoIzqHaciaArriba = true

    var desfaseBrazoDer = 0f  // %
    var brazoDerHaciaLaDerecha = true
    var deslizamientoBrazoDer = -0.5f


    fun dibujar( c: Canvas , pantalla: MainActivity )
    {
        altura = c.height + 0f
        ancho = c.width + 0f
        val pincel = Paint()


        when( tumbaActual )
        {
            0 -> {  xi = -50 /* OCULTO */ }
            1 -> {  xi = 2   /* % inicial en eje X del esqueleto */  }
            2 -> {  xi = 30   /* % inicial en eje X del esqueleto */  }
            3 -> {  xi = 60   /* % inicial en eje X del esqueleto */  }
        }


        // PIE IZQUIERDO DEL ESQUELETO =====================================================================
        pincel.color = Color.rgb( 231 , 230 , 228 )   // GRIS LIGERO
        var pieIzq = Path()
        pieIzq.moveTo( posX(xi + 0f , 0f) , posY( 95f , 0f) )
        pieIzq.lineTo( posX(xi + 1.85f , 0f) , posY( 95f , 0f) )
        pieIzq.lineTo( posX(xi + 1.85f , 0f) , posY( 93f , 0f) )
        c.drawPath( pieIzq , pincel )


        // 1º HUESO IZQUIERDO DEL PIE =====================================================================
        c.drawCircle(
            posX(xi + 1.85f , 2f + 8f ) ,
            posY( 93f ,  - 5f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 1.85f ,  - 6f ) ,
            posY( 93f , -3f - 8f) ,
            8f , pincel
        )
        pincel.strokeWidth = 19f
        c.drawLine(
            posX(xi + 1.85f , 0f ) ,
            posY( 93f , -4f) ,
            posX(xi + 3.75f , -3f ) ,
            posY( 84f , 3f) , pincel
        )
        pincel.strokeWidth = 1f
        c.drawCircle(
            posX(xi + 3.75f , 4f ) ,
            posY( 84f ,  12f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 3.75f ,  - 12f ) ,
            posY( 84f , 5f ) ,
            8f , pincel
        )


        // 2º HUESO IZQUIERDO DEL PIE =====================================================================
        c.drawCircle(
            posX(xi + 3.75f , 2f + 8f ) ,
            posY( 84f ,  - 5f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 3.75f ,  - 6f ) ,
            posY( 84f , -3f - 8f) ,
            8f , pincel
        )
        pincel.strokeWidth = 19f
        c.drawLine(
            posX(xi + 3.75f , 0f ) ,
            posY( 84f , -4f) ,
            posX(xi + 5.6f , -3f ) ,
            posY( 75f , 3f) , pincel
        )
        pincel.strokeWidth = 1f
        c.drawCircle(
            posX(xi + 5.6f , 4f ) ,
            posY( 75f ,  12f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 5.6f ,  - 12f ) ,
            posY( 75f , 5f ) ,
            8f , pincel
        )


        // PIE DERECHO DEL ESQUELETO  =========================================================================
        var pieDer = Path()
        pieDer.moveTo( posX(xi + 15f , 0f) , posY( 95f , 0f) )
        pieDer.lineTo( posX(xi + 15f  - 1.85f , 0f) , posY( 95f , 0f) )
        pieDer.lineTo( posX(xi + 15f - 1.85f , 0f) , posY( 93f , 0f) )
        c.drawPath( pieDer , pincel )


        // 1º HUESO DERECHO DEL PIE =====================================================================
        c.drawCircle(
            posX(xi + 15f - 1.85f , -2f - 8f ) ,
            posY( 93f ,  - 5f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 15f - 1.85f ,  + 6f ) ,
            posY( 93f , -3f - 8f) ,
            8f , pincel
        )
        pincel.strokeWidth = 19f
        c.drawLine(
            posX(xi + 15f - 1.85f , 0f ) ,
            posY( 93f , -4f) ,
            posX(xi + 15f - 3.75f , -3f ) ,
            posY( 84f , 5f) , pincel
        )
        pincel.strokeWidth = 1f
        c.drawCircle(
            posX(xi + 15f - 3.75f , - 6f ) ,
            posY( 84f ,  12f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 15f - 3.75f ,  10f ) ,
            posY( 84f , 5f ) ,
            8f , pincel
        )


        // 2º HUESO DERECHO DEL PIE =====================================================================
        c.drawCircle(
            posX(xi + 15f - 3.75f , -6f - 8f ) ,
            posY( 84f ,  - 5f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 15f - 3.75f ,  2f ) ,
            posY( 84f , -3f - 8f) ,
            8f , pincel
        )
        pincel.strokeWidth = 19f
        c.drawLine(
            posX(xi + 15f - 3.75f , -2f ) ,
            posY( 84f , -4f) ,
            posX(xi + 15f - 5.6f , -4f ) ,
            posY( 75f , 5f) , pincel
        )
        pincel.strokeWidth = 1f
        c.drawCircle(
            posX(xi + 15f - 5.6f , -8f ) ,
            posY( 75f ,  12f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 15f - 5.6f ,  8f ) ,
            posY( 75f , 5f ) ,
            8f , pincel
        )


        // CADERA
        pincel.strokeWidth = 1f
        var cadera = Path()
        cadera.moveTo( posX(xi + 3.75f , 0f) , posY( 75f , -15f) )
        cadera.lineTo( posX(xi + 7.5f , 0f) , posY( 75f , 8f) )
        cadera.lineTo( posX(xi + 15f - 3.75f , 0f) , posY( 75f , -15f) )
        cadera.lineTo( posX(xi + 15f - 3.75f , -11f) , posY( 71f , 0f) )
        cadera.lineTo( posX(xi + 7.5f , 0f) , posY( 72f , 0f) )
        cadera.lineTo( posX(xi + 3.75f , 11f) , posY( 71f , 0f) )
        c.drawPath( cadera , pincel )

        // ESTOMAGO
        c.drawRect(
            posX(xi + 7.5f , -10f) ,
            posY( 68f , 0f) ,
            posX(xi + 7.5f , 10f) ,
            posY( 71f , 0f) , pincel
        )

        c.drawRect(
            posX(xi + 7.5f , -10f) ,
            posY( 65f , 0f) ,
            posX(xi + 7.5f , 10f) ,
            posY( 68f , -2f) , pincel
        )

        // PECHO
        c.drawOval(
            posX(xi + 3.75f , 7f) ,
            posY( 62.5f , 0f) ,
            posX(xi + 15f - 3.75f , -7f) ,
            posY( 65f , -1f) , pincel
        )

        c.drawOval(
            posX(xi + 3.75f , 7f) ,
            posY( 60f , 0f) ,
            posX(xi + 15f - 3.75f , -7f) ,
            posY( 62.5f , -1f) , pincel
        )

        c.drawOval(
            posX(xi + 3.75f , 7f) ,
            posY( 57.5f , 0f) ,
            posX(xi + 15f - 3.75f , -7f) ,
            posY( 60f , -1f) , pincel
        )


        // CUELLO
        c.drawRect(
            posX(xi + 7.5f , -10f) ,
            posY( 54f , 0f) ,
            posX(xi + 7.5f , 10f) ,
            posY( 57.5f , -2f) , pincel
        )


        // BARBILLA
        c.drawOval(
            posX(xi + 4.25f , 7f) ,
            posY( 49f , 0f) ,
            posX(xi + 15f - 4.25f , -7f) ,
            posY( 54f , -1f) , pincel
        )


        // BOCA
        pincel.color = Color.BLACK
        var boca = Path()
        boca.moveTo( posX(xi + 6.25f , 0f) , posY( 51f , 0f) )
        boca.lineTo( posX(xi + 6.25f , 6f) , posY( 52.5f , 0f) )
        boca.lineTo( posX(xi + 15f - 6.25f , -6f) , posY( 52.5f , 0f) )
        boca.lineTo( posX(xi + 15f - 6.25f , 0f) , posY( 51f , 0f) )
        c.drawPath( boca , pincel )


        // SOMBRERO
        pincel.color = Color.rgb( 234 , 190 , 101 )   // NARANJA-CAFE
        c.drawOval(
            posX(xi + 5f , 0f) ,
            posY( 33f , 0f) ,
            posX(xi + 15f - 5f , 0f) ,
            posY( 48f , 0f) , pincel
        )
        pincel.style = Paint.Style.STROKE
        pincel.strokeWidth = 3f
        pincel.color = Color.rgb( 103 , 163 , 69 )   // VERDE OSCURO
        c.drawOval(
            posX(xi + 5f , 0f) ,
            posY( 33f , 0f) ,
            posX(xi + 15f - 5f , 0f) ,
            posY( 48f , 0f) , pincel
        )

        pincel.style = Paint.Style.FILL
        pincel.strokeWidth = 1f
        pincel.color = Color.rgb( 234 , 190 , 101 )   // NARANJA-CAFE
        c.drawOval(
            posX(xi + 0f , 0f) ,
            posY( 38f , 0f) ,
            posX(xi + 15f , 0f) ,
            posY( 46f , 0f) , pincel
        )
        pincel.style = Paint.Style.STROKE
        pincel.strokeWidth = 3f
        pincel.color = Color.rgb( 103 , 163 , 69 )   // VERDE OSCURO
        c.drawOval(
            posX(xi + 0f , 0f) ,
            posY( 38f , 0f) ,
            posX(xi + 15f , 0f) ,
            posY( 46f , 0f) , pincel
        )


        // CABEZA
        pincel.style = Paint.Style.FILL
        pincel.strokeWidth = 1f
        pincel.color = Color.rgb( 231 , 230 , 228 )   // GRIS LIGERO
        c.drawOval(
            posX(xi + 3.7f , 0f) ,
            posY( 40f , 0f) ,
            posX(xi + 15f - 3.7f , 0f) ,
            posY( 50f , 4f) , pincel
        )

        // OJOS
        pincel.color = Color.BLACK
        c.drawCircle(
            posX(xi + 6.2f , 0f) ,
            posY( 44.5f , 0f) ,
            posY( 1.75f , 0f) , pincel
        )

        c.drawCircle(
            posX(xi + 15f - 6.2f , 0f) ,
            posY( 44.5f , 0f) ,
            posY( 1.75f , 0f) , pincel
        )

        // NARIZ
        var nariz = Path()
        nariz.moveTo( posX(xi + 7.5f , 0f) , posY( 46.5f , 0f) )
        nariz.lineTo( posX(xi + 6.5f , 0f) , posY( 48.5f , 0f) )
        nariz.lineTo( posX(xi + 7.5f , 0f) , posY( 48f , 0f) )
        nariz.lineTo( posX(xi + 15f - 6.5f , 0f) , posY( 48.5f , 0f) )
        c.drawPath( nariz , pincel )


        // TUMBAS ==================================================================================
        val tumbaIMG = BitmapFactory.decodeResource(pantalla.resources, R.drawable.tumba)

        var widthTumba = (posX(30f, 0f) - posX(15f - 5f, 0f)).toInt()
        var factor = (widthTumba.toFloat() / tumbaIMG.width.toFloat())
        var heightTumba = tumbaIMG.height.toFloat() * factor

        val tumba = Bitmap.createScaledBitmap(tumbaIMG, widthTumba, heightTumba.toInt(), false)
        c.drawBitmap(
            tumba,
            posX(30f - 15f - 4f, 0f),
            posY(98f, heightTumba * -1f),
            Paint()
        )
        c.drawBitmap(
            tumba,
            posX(60f - 15f - 4f, 0f),
            posY(98f, heightTumba * -1f),
            Paint()
        )
        c.drawBitmap(
            tumba,
            posX(90f - 15f - 4f, 0f),
            posY(98f, heightTumba * -1f),
            Paint()
        )



        // ==============================================================================================
        //                      GUITARRA
        // ==============================================================================================
        pincel.color = Color.rgb( 132 , 191 , 97 )   // VERDE LIGERO
        c.drawOval(
            posX(xi + 1f , 0f) ,
            posY( 67.25f , 0f) ,
            posX(xi + 9.6f , 0f) ,
            posY( 81.5f , 0f) , pincel
        )
        c.drawOval(
            posX(xi + 6.3f , 0f) ,
            posY( 68.25f , 0f) ,
            posX(xi + 15f - 3.3f , 0f) ,
            posY( 80.5f , 0f) , pincel
        )
        pincel.color = Color.WHITE
        var radioGuitarra = posY( ((80.5f - 68.25f ) / 2f) - 2.75f , 0f)
        c.drawCircle(
            posX(xi + 6.3f + 1f , 0f) ,
            posY( 67.25f + ((81.5f - 67.25f ) / 2f) , 0f) ,
            radioGuitarra , pincel
        )
        pincel.color = Color.rgb( 115 , 82 , 37 )   // CAFE
        pincel.style = Paint.Style.STROKE
        pincel.strokeWidth = 3f
        c.drawCircle(
            posX(xi + 6.3f + 1f , 0f) ,
            posY( 67.25f + ((81.5f - 67.25f ) / 2f) , 0f) ,
            radioGuitarra , pincel
        )

        // ==============================================================================================
        //                      1º HUESO DERECHO DEL BRAZO
        // ==============================================================================================
        pincel.color = Color.rgb( 231 , 230 , 228 )   // GRIS LIGERO
        pincel.style = Paint.Style.FILL
        pincel.strokeWidth = 1f
        c.drawCircle(
            posX( xi + 15f - 3.75f , -7f + 9f ) ,
            posY( 57.5f + ((60f - 57.5f) / 2f) ,  6f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 15f - 3.75f , -7f + 12f + 12f ) ,
            posY( 57.5f ,  9f) ,
            8f , pincel
        )
        pincel.strokeWidth = 19f
        c.drawLine(
            posX(xi + 15f - 3.75f , -7f + 12f + 4f ) ,
            posY( 57.5f + ((60f - 57.5f) / 2f) ,  -1f) ,
            posX(xi + 15f + desfaseBrazoDer + deslizamientoBrazoDer , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 9f) , 0f) ,
            pincel
        )


        pincel.color = Color.WHITE
        pincel.style = Paint.Style.FILL
        pincel.strokeWidth = 1f
        c.drawRect(
            posX(xi + 6.3f + 1f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) ,
            posX(xi + 15f + 1.3f , 0f) ,
            posY( 81.5f - (((81.5f - 67.25f ) / 20f) * 7f) , 0f) ,
            pincel
        )
        pincel.color = Color.rgb( 170 , 170 , 169 )    // NEGRO LIGERO
        pincel.strokeWidth = 3f
        var incrementoCuerda = (posY( 81.5f - (((81.5f - 67.25f ) / 20f) * 7f) , 0f) -
                posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) ) / 5f

        c.drawLine(
            posX(xi + 5.75f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) + incrementoCuerda ,
            posX(xi + 15f + 1.3f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) + incrementoCuerda ,
            pincel
        )
        c.drawLine(
            posX(xi + 5.65f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) + incrementoCuerda * 2f ,
            posX(xi + 15f + 1.3f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) + incrementoCuerda * 2f ,
            pincel
        )
        c.drawLine(
            posX(xi + 5.65f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) + incrementoCuerda * 3f ,
            posX(xi + 15f + 1.3f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) + incrementoCuerda * 3f ,
            pincel
        )
        c.drawLine(
            posX(xi + 5.75f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) + incrementoCuerda * 4f ,
            posX(xi + 15f + 1.3f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7f)  , 0f) + incrementoCuerda * 4f ,
            pincel
        )
        pincel.color = Color.rgb( 225 , 46 , 18 )   // ROJO
        var contornoCuerdas = Path()
        contornoCuerdas.moveTo(
            posX(xi + 15f + 1.3f , 0f) ,
            posY( 67.25f + 3f  , 0f)
        )
        contornoCuerdas.lineTo(
            posX(xi + 15f + 1.3f , 0f) ,
            posY( 81.5f - 3f  , 0f)
        )
        contornoCuerdas.lineTo(
            posX(xi + 15f + 1.3f + 2.75f , 0f) ,
            posY( 81.5f - (((81.5f - 67.25f ) / 20f) * 7.5f) , 0f)
        )
        contornoCuerdas.lineTo(
            posX(xi + 15f + 1.3f + 2.75f , 0f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 7.5f) , 0f)
        )
        c.drawPath( contornoCuerdas , pincel )


        // ==============================================================================================
        //                      1º HUESO IZQUIERDO DEL BRAZO
        // ==============================================================================================
        pincel.color = Color.rgb( 231 , 230 , 228 )   // GRIS LIGERO
        c.drawCircle(
            posX(xi + 1f , 2f + 12f ) ,
            posY( 67.25f ,  0f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 1f ,  - 2f ) ,
            posY( 67.25f , -3f - 3f) ,
            8f , pincel
        )
        pincel.strokeWidth = 19f
        c.drawLine(
            posX(xi + 1f , 4f ) ,
            posY( 67.25f , 1f) ,
            posX(xi + 3.75f , -6f ) ,
            posY( 57.5f , 6f) , pincel
        )
        pincel.strokeWidth = 1f
        c.drawCircle(
            posX(xi + 3.75f , 0f ) ,
            posY( 57.5f ,  12f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 3.75f ,  - 12f ) ,
            posY( 57.5f , 7f ) ,
            8f , pincel
        )


        // ==============================================================================================
        //                      2º HUESO IZQUIERDO DEL BRAZO
        // ==============================================================================================
        pincel.color = Color.rgb( 231 , 230 , 228 )   // GRIS LIGERO
        c.drawCircle(
            posX( xi + 1f , 2f + 12f + 5f ) ,
            posY( 67.25f ,  18f) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 1f , 8f + 22f ) ,
            posY( 67.25f ,  7f) ,
            8f , pincel
        )
        pincel.strokeWidth = 19f
        c.drawLine(
            posX(xi + 1f , 18f ) ,
            posY( 67.25f , 10f) ,
            posX(xi + 6.3f , -7f) ,
            posY( 67.25f + ((81.5f - 67.25f ) / 2f) + desfaseBrazoIzq , -12f) ,
            pincel
        )
        pincel.strokeWidth = 1f
        c.drawCircle(
            posX(xi + 6.3f ,  -5f - 5f ) ,
            posY( 67.25f + ((81.5f - 67.25f ) / 2f) + desfaseBrazoIzq , -8f ) ,
            8f , pincel
        )
        c.drawCircle(
            posX(xi + 6.3f ,  -5f + 0f ) ,
            posY( 67.25f + ((81.5f - 67.25f ) / 2f) + desfaseBrazoIzq , -16f ) ,
            8f , pincel
        )



        // MANO IZQUIERDA
        pincel.color = Color.rgb( 227 , 167 , 75 )   // NARANJA
        pincel.strokeWidth = 1f
        c.drawOval(
            posX(xi + 6.3f + 1f , -10f) ,
            posY( 67.25f + ((81.5f - 67.25f ) / 2f) + desfaseBrazoIzq , -8f) ,
            posX(xi + 6.3f + 1f , 10f) ,
            posY( 67.25f + ((81.5f - 67.25f ) / 2f) + desfaseBrazoIzq , 8f) , pincel
        )

        // MANO DERECHA
        c.drawOval(
            posX(xi + 15f + desfaseBrazoDer + deslizamientoBrazoDer, -8f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 10f)  , -10f) ,
            posX(xi + 15f + desfaseBrazoDer + deslizamientoBrazoDer , 8f) ,
            posY( 67.25f + (((81.5f - 67.25f ) / 20f) * 10f)  , 10f) , pincel
        )

    }




    fun cambiarTumba()
    {
        var aleatorio = Math.random() * 100
        when( tumbaActual )
        {
            0 -> {
                if( tumbaAnterior == (1).toInt() )
                {
                    if( aleatorio < 50 ){  tumbaActual = 2;   tumbaAnterior = 2;  }
                    else{ tumbaActual = 3;   tumbaAnterior = 3; }
                }
                else if( tumbaAnterior == (2).toInt() )
                {
                    if( aleatorio < 50 ){  tumbaActual = 1;   tumbaAnterior = 1;  }
                    else{ tumbaActual = 3;   tumbaAnterior = 3; }
                }
                else{
                    if( aleatorio < 50 ){  tumbaActual = 1;   tumbaAnterior = 1;  }
                    else{ tumbaActual = 2;   tumbaAnterior = 2; }
                }
            }
            1 -> {
                if( aleatorio < 50 ){  tumbaActual = 2 }
                else{ tumbaActual = 3 }
            }
            2 -> {
                if( aleatorio < 50 ){  tumbaActual = 1 }
                else{ tumbaActual = 3 }
            }
            3 -> {
                if( aleatorio < 50 ){  tumbaActual = 1 }
                else{ tumbaActual = 2 }
            }
        }
    }


    fun moverBrazos()
    {
        if( tocadaRapida == true )
        {
            if( brazoIzqHaciaArriba == true )
            {
                desfaseBrazoIzq -= 0.4f
                if( desfaseBrazoIzq < -0.75f ) { brazoIzqHaciaArriba = false }
            }
            else
            {
                desfaseBrazoIzq += 0.4f
                if( desfaseBrazoIzq > 0.75f ) { brazoIzqHaciaArriba = true }
            }

            // BRAZO DERECHO
            if( brazoDerHaciaLaDerecha == true )
            {
                desfaseBrazoDer += 0.15f
                if( desfaseBrazoDer > 0.25f ) { brazoDerHaciaLaDerecha = false }
            }
            else
            {
                desfaseBrazoDer -= 0.15f
                if( desfaseBrazoDer < -0.25f ) { brazoDerHaciaLaDerecha = true }
            }

        } // FIN TOCADA RAPIDA
        else
        {
            if( brazoIzqHaciaArriba == true )
            {
                desfaseBrazoIzq -= 0.9f
                if( desfaseBrazoIzq < -5f ) { brazoIzqHaciaArriba = false }
            }
            else
            {
                desfaseBrazoIzq += 0.9f
                if( desfaseBrazoIzq > 5f ) { brazoIzqHaciaArriba = true }
            }

            // BRAZO DERECHO
            if( brazoDerHaciaLaDerecha == true )
            {
                desfaseBrazoDer += 0.15f
                if( desfaseBrazoDer > 0.85f ) { brazoDerHaciaLaDerecha = false }
            }
            else
            {
                desfaseBrazoDer -= 0.15f
                if( desfaseBrazoDer < -0.85f ) { brazoDerHaciaLaDerecha = true }
            }
        }
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