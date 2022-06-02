package com.github.fourlastor.gdxplayground.services

import com.intellij.openapi.project.Project
import com.github.fourlastor.gdxplayground.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
