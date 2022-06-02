package com.github.fourlastor.gdxplayground.gdx

import com.badlogic.gdx.ApplicationListener
import com.intellij.diff.util.FileEditorBase
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.JComponent

class GdxEditor(
    application: ApplicationListener,
    private val editorFile: VirtualFile,
) : FileEditorBase() {

    private val component = GdxFrame(application)

    override fun getComponent(): JComponent = component

    override fun getName(): String = "GDX"

    override fun getPreferredFocusedComponent(): JComponent? = null

    override fun getFile(): VirtualFile = editorFile
}
