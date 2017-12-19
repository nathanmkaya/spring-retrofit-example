package com.mobidev.billing.model.repos

import com.mobidev.billing.model.Repo
import org.springframework.data.jpa.repository.JpaRepository

interface RepoRepository: JpaRepository<Repo, Long> {
    fun findByLanguage(language : String) : List<Repo>
}