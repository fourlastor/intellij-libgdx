package com.github.fourlastor.intellijlibgdx.gdx

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils

class GdxEditorApplication : ApplicationListener {
    private lateinit var batch: SpriteBatch
    private lateinit var font: BitmapFont


    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont()
        font.color = Color.RED
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }

    override fun render() {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1f, true)
        batch.begin()
        font.draw(batch, "Hello World", 200f, 200f)
        batch.end()
    }

    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
}
