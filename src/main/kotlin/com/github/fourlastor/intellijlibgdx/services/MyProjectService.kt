package com.github.fourlastor.intellijlibgdx.services

import com.intellij.openapi.project.Project
import com.github.fourlastor.intellijlibgdx.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
