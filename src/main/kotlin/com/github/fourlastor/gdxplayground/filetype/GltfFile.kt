package com.github.fourlastor.gdxplayground.filetype

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.util.IconLoader

class GltfFile : FileType {
    override fun getName(): String {
        return "glTF Model"
    }

    override fun getDescription(): String {
        return "glTF™ (GL Transmission Format) is a royalty-free specification for the efficient transmission and loading of 3D scenes and models by applications. glTF minimizes both the size of 3D assets, and the runtime processing needed to unpack and use those assets. glTF defines an extensible, common publishing format for 3D content tools and services that streamlines authoring workflows and enables interoperable use of content across the industry."
    }

    override fun getDefaultExtension(): String {
        return "gdxscene"
    }

    override fun getIcon() = ICON

    override fun isBinary(): Boolean {
        return false
    }

    companion object {
        @Suppress("unused") // referenced in plugin.xml
        val INSTANCE = GltfFile()

        val ICON = IconLoader.getIcon("/icons/gltf.png", GltfFile::class.java)
    }
}
