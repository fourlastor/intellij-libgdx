package com.github.fourlastor.gdxplayground.gdx

import com.github.fourlastor.gdxplayground.filetype.GltfFile
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class GdxEditorProvider : FileEditorProvider, DumbAware {
    override fun accept(project: Project, file: VirtualFile): Boolean = file.fileType is GltfFile

    override fun createEditor(project: Project, file: VirtualFile): FileEditor {
        return GdxEditor({ GdxEditorApplication() }, file)
    }

    override fun getEditorTypeId(): String = "GDX-editor"

    override fun getPolicy(): FileEditorPolicy = FileEditorPolicy.PLACE_AFTER_DEFAULT_EDITOR
}
