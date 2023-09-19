package com.github.fourlastor.gdxplayground.gdx

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.ui.components.BorderLayoutPanel
import java.awt.BorderLayout
import java.awt.Dimension

class GdxFrame(
    private val factory: (file: VirtualFile) -> ApplicationListener,
    private val editorFile: VirtualFile
) : BorderLayoutPanel() {

    private lateinit var canvas: LwjglAWTCanvas

    init {
        initializeCanvas()
    }

    private fun initializeCanvas() {
        canvas = LwjglAWTCanvas(factory(editorFile))
        add(canvas.canvas, BorderLayout.CENTER)
    }

    override fun addNotify() {
        super.addNotify()
        initializeCanvas()
    }

    override fun removeNotify() {
        canvas.stop()
        remove(canvas.canvas)
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
