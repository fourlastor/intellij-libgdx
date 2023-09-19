package com.github.fourlastor.gdxplayground.gdx

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.utils.DragListener
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport
import com.intellij.openapi.vfs.VirtualFile

class GdxEditorApplication(
    private val virtualFile: VirtualFile
) : ApplicationListener {
    private lateinit var stage: Stage
    private lateinit var label: Label

    override fun create() {
        stage = Stage(FitViewport(256f, 144f))
        label = object : Label("Drag me around", LabelStyle().apply {
            font = BitmapFont(Gdx.files.internal("fonts/quan-pixel-32.fnt"))
            fontColor = Color.CORAL
        }) {

            public var dragging = false
            private val position = Vector2()

            override fun act(delta: Float) {
                super.act(delta)
                if (dragging) {
                    position.set(Gdx.input.x.toFloat(), Gdx.input.y.toFloat())
                    stage.screenToStageCoordinates(position)
                    setPosition(position.x, position.y)
                }
            }


        }.apply {
            addListener(object : DragListener() {
                override fun dragStart(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                    dragging = true
                }

                override fun dragStop(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                    dragging = false
                }
            })
        }
        stage.addActor(label)
        Gdx.input.inputProcessor = stage
    }

    override fun dispose() {
        Gdx.input.inputProcessor = null
        stage.dispose()
    }

    override fun render() {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1f, true)
        stage.viewport.apply()
        stage.act()
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height)
    }
    override fun pause() {}
    override fun resume() {}
}
