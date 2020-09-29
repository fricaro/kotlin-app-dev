package br.edu.ifpb.pdm.francisco.truecolorslollipop.Adapter

import android.widget.BaseAdapter
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import br.edu.ifpb.pdm.francisco.truecolorslollipop.R
import br.edu.ifpb.pdm.francisco.truecolorslollipop.Model.Cor
import android.widget.TextView


class CorAdapter: BaseAdapter {
    private var cores: List<Cor>
    private var act: Activity

    constructor(cores: List<Cor>, act: Activity) {
        this.cores = cores
        this.act = act
    }

    override fun getCount(): Int {
        return cores.size
    }

    override fun getItem(position: Int): Any {
        return cores[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view = act.getLayoutInflater()
            .inflate(R.layout.activity_cores, parent, false)

        val cor: Cor = this.cores[position]
        val corCodigo = "#${cor.codigo}"
        val codigo = view.findViewById(R.id.tvCoresCodigo) as TextView
        val ivCor = view.findViewById(R.id.ivCoresCor) as ImageView

        // TextView text
        codigo.text = corCodigo

        // criar o canvas/retângulo e preenchê-lo com a cor correta
        val bitmap: Bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        var shapeDrawable: ShapeDrawable

        // rectangle positions
        var left = 100
        var top = 100
        var right = 600
        var bottom = 400

        // draw rectangle shape to canvas
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.getPaint().setColor(Color.parseColor(corCodigo))
        shapeDrawable.draw(canvas)

        //1000 horas pra acertar esse view.context.resources
        ivCor.background = BitmapDrawable(view.context.resources, bitmap)

        return view
    }
}
