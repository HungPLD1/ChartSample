package com.example.mansigoel.charts

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.LimitLine.LimitLabelPosition
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupLineChartData()

    }

    private fun setupLineChartData() {
        val yVals = ArrayList<Entry>()
        yVals.add(Entry(0f, 0f, "0"))
        yVals.add(Entry(1f, 2f, "1"))
        yVals.add(Entry(2f, 4f, "2"))
        yVals.add(Entry(3f, 6f, "3"))
        yVals.add(Entry(4f, 8f, "4"))
        yVals.add(Entry(5f, 10f, "5"))
        yVals.add(Entry(6f, 22f, "6"))
        yVals.add(Entry(7f, 12.5f, "7"))
        yVals.add(Entry(8f, 22f, "8"))
        yVals.add(Entry(9f, 32f, "9"))
        yVals.add(Entry(10f, 54f, "10"))
        yVals.add(Entry(11f, 280f, "11"))

        val set1: LineDataSet
        set1 = LineDataSet(yVals, "DataSet 1")

        set1.setCircleColor(Color.RED)
        set1.fillAlpha = 110
        set1.fillColor = Color.RED
        set1.lineWidth = 1f
        set1.circleRadius = 3f
        set1.setDrawCircleHole(false)
        set1.valueTextSize = 0f
        set1.mode = LineDataSet.Mode.CUBIC_BEZIER
        // drawables only supported on api level 18 and above
        val drawable = ContextCompat.getDrawable(this, R.drawable.fade_red)
        set1.setDrawFilled(true)
        set1.fillFormatter =
            IFillFormatter { _, _ -> lineChart.axisLeft.axisMinimum }
        set1.fillDrawable = drawable

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(set1)
        val data = LineData(dataSets)

        val ll2 = LimitLine(200F, "Middle")
        ll2.lineWidth = 4f
        ll2.enableDashedLine(10f, 10f, 0f)
        ll2.labelPosition = LimitLabelPosition.RIGHT_BOTTOM
        ll2.textSize = 10f


        // draw points over time
        lineChart.animateX(1500)
        // set data
        lineChart.data = data
        lineChart.description.isEnabled = false
        lineChart.legend.isEnabled = false
        lineChart.setPinchZoom(true)
        lineChart.xAxis.enableGridDashedLine(5f, 5f, 0f)
        // disable dual axis (only use LEFT axis)
        lineChart.axisRight.isEnabled = false
        lineChart.axisLeft.enableGridDashedLine(5f, 5f, 0f)
        lineChart.axisLeft.addLimitLine(ll2)
        lineChart.axisLeft.axisMinimum = 0F
        lineChart.axisLeft.axisMaximum = 500F
        //lineChart.setDrawGridBackground()
        lineChart.xAxis.labelCount = 11
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
    }
}
