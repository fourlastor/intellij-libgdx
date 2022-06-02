package com.github.fourlastor.intellijlibgdx.gdx

import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class GdxEditorProvider: FileEditorProvider, DumbAware {
    override fun accept(project: Project, file: VirtualFile): Boolean = true

    override fun createEditor(project: Project, file: VirtualFile): FileEditor {
        return GdxEditor(GdxEditorApplication(), file)
    }

    override fun getEditorTypeId(): String = "GDX-editor"

    override fun getPolicy(): FileEditorPolicy = FileEditorPolicy.HIDE_DEFAULT_EDITOR
}
