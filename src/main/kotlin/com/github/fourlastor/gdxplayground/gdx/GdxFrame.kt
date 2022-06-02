package com.github.fourlastor.gdxplayground.gdx

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas
import com.intellij.util.ui.components.BorderLayoutPanel
import java.awt.BorderLayout
import java.awt.Dimension

class GdxFrame(
    listener: ApplicationListener
) : BorderLayoutPanel() {

    private val canvas: LwjglAWTCanvas = LwjglAWTCanvas(listener)

    init {
        add(canvas.canvas, BorderLayout.CENTER)
    }

    override fun removeNotify() {
        canvas.stop()
        super.removeNotify()
    }

    override fun setSize(d: Dimension) {
        setSize(d.width, d.height)
    }

    override fun setSize(width: Int, height: Int) {
        super.setSize(width, height)
        canvas.canvas.setSize(width, height)
    }
}
